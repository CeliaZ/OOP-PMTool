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
    private int sumProjected = 0;
    private int sumActual = 0;
    
    public ProjectBudgetsModel(Projects project) {
        this.project = project;
        EntityManager em = ApplicationController.getEnitityManager();
        TypedQuery<Budgets> query = (TypedQuery<Budgets>) em.createNamedQuery("Budgets.findByProjectId");
        budgets = query.setParameter("projectId", project.getId()).getResultList();
        for (Budgets b : budgets) {
            sumProjected += b.getProjected();
            sumActual += b.getActual();
        }
    }
    
    @Override
    public int getRowCount() {
        return budgets.size() + 1;
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
        Budgets b = rowIndex == getRowCount() - 1 ? null : budgets.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return b == null ? "" : b.getId();
            case 1:
                return b == null ? sumProjected : b.getProjected();
            case 2:
                return b == null ? sumActual : b.getActual();
            case 3:
                return b == null ? "Summary" : b.getDescription();
        }
        return null;
    }
    
    public Budgets getBudgetAt(int row) {
        if (row >= getRowCount() - 1) {
            return null;
        }
        return budgets.get(row);
    }
}
