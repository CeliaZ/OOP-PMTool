/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Budgets;
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
public class ProjectBudgetsModel extends AbstractTableModel {
    private List<Budgets> budgets;
    private Projects project;
    
    public ProjectBudgetsModel(Projects project) {
        this.project = project;
        EntityManager em = ApplicationController.getEnitityManager();
        TypedQuery<Budgets> query = (TypedQuery<Budgets>) em.createNamedQuery("Budgets.findByProjectId");
        budgets = query.setParameter("projectId", project.getId()).getResultList();
    }
    
    @Override
    public int getRowCount() {
        return budgets.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        String colNames[] = {"Budget ID", "Projected", "Actual", "Description"};
        return colNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Budgets b = budgets.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return b.getId();
            case 1:
                return b.getProjected();
            case 2:
                return b.getActual();
            case 3:
                return b.getDescription();
        }
        return null;
    }
}
