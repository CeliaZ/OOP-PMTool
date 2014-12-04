/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Projects;
import entity.Tasks;
import entity.Users;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.table.AbstractTableModel;
import services.Application;

/**
 *
 * @author Cherry
 */
public class TasksTableModel extends AbstractTableModel {
    private List<Tasks> tasks;
    
    public TasksTableModel() {
        EntityManager em = Application.getEnitityManager();
        TypedQuery<Projects> queryProById = (TypedQuery<Projects>) em.createNamedQuery("Projects.findById");
        Integer proId = 24;
        Projects pro = queryProById.setParameter("id", proId).getSingleResult();
        tasks = pro.getTasks();
    }

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        String colNames[] = {"Task ID", "Task Name", "Task Owner", "Due day", "Updated Time"};
        return colNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tasks t = tasks.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return t.getTaskName();
            case 2:
                int ownerId = t.getOwnerId();
                EntityManager em = Application.getEnitityManager();
                TypedQuery<Users> queryUserById = (TypedQuery<Users>) em.createNamedQuery("Users.findById");
                Users taskOwner = queryUserById.setParameter("id", ownerId).getSingleResult();
                String ownerName = taskOwner.getFirstName();
                return ownerName;
            case 3:
                return t.getEndTime();
            case 4:
                return t.getUpdatedAt();
        }
        return null;
    }
    
    public Tasks getTaskAt(int row) {
        return tasks.get(row);
    }
}
