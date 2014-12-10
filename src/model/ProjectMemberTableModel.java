/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Projects;
import entity.ProjectsUsers;
import entity.Tasks;
import entity.Users;
import java.util.ArrayList;
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
public class ProjectMemberTableModel extends AbstractTableModel {
    private List<Users> members = new ArrayList<Users>();
    private List<String> memberRoles = new ArrayList<String>();
    
    public ProjectMemberTableModel(Projects project) {
        EntityManager em = ApplicationController.getEnitityManager();
        TypedQuery<ProjectsUsers> queryRoles = (TypedQuery<ProjectsUsers>)em.createNamedQuery("ProjectsUsers.findByProjectId");
        Integer proId = ApplicationController.getCurrentProject().getId();
        List<ProjectsUsers> roles = queryRoles.setParameter("projectId", proId).getResultList();
        for (ProjectsUsers role : roles) {
            members.add(role.getUsers());
            memberRoles.add(role.getRole());
        }
    }

    @Override
    public int getRowCount() {
        return members.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        String colNames[] = {"First Name", "Last Name", "Role"};
        return colNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return members.get(rowIndex).getFirstName();
            case 1:
                return members.get(rowIndex).getLastName();
            case 2:
                return memberRoles.get(rowIndex);
        }
        return null;
    }

}
