/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Projects;
import entity.Tasks;
import entity.Users;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.table.AbstractTableModel;
import services.ApplicationController;

/**
 *
 * @author Cherry
 */
public class TasksTableModel extends AbstractTableModel {
    private List<Tasks> tasks;
    
    public TasksTableModel(String owner) {
        EntityManager em = ApplicationController.getEnitityManager();
        TypedQuery<Tasks> queryTasks = (TypedQuery<Tasks>) em.createNamedQuery("Tasks.findByProjectId");
        Integer proId = ApplicationController.getCurrentProject().getId();
        tasks = queryTasks.setParameter("projectId", proId).getResultList();
        if (owner.length() > 0) {
            TypedQuery<Users> queryOwner = (TypedQuery<Users>) em.createNamedQuery("Users.findByFirstName");
            Users user = queryOwner.setParameter("firstName", owner).getResultList().get(0);
            if (user != null) {
                System.out.println(user);
                Iterator<Tasks> iter = tasks.iterator();
                while (iter.hasNext()) {
                    if (iter.next().getOwnerId() != user.getId()) {
                        iter.remove();
                    }
                }
            }
        }
    }
    
    public TasksTableModel() {
        this("");
    }

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        String colNames[] = {"Task ID", "Task Owner", "Status", "Dependency", "Task Name", "Due day"};
        return colNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tasks t = tasks.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return t.getId();
            case 1:
                int ownerId = t.getOwnerId();
                EntityManager em = ApplicationController.getEnitityManager();
                TypedQuery<Users> queryUserById = (TypedQuery<Users>) em.createNamedQuery("Users.findById");
                Users taskOwner = queryUserById.setParameter("id", ownerId).getSingleResult();
                String ownerName = taskOwner.getFirstName();
                return ownerName;
            case 2:
                return t.getStatus() == null ? "open" : t.getStatus();
            case 3:
                return t.getDependency() == null ? "" : t.getDependency();
            case 4:
                return t.getTaskName();
            case 5:
                return t.getEndTime();
        }
        return null;
    }
    
    public Tasks getTaskAt(int row) {
        return tasks.get(row);
    }
}
