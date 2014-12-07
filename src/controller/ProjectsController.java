/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import model.*;
import view.AdminPanel;


/**
 *
 * @author tanmaykuruvilla
 */
public class ProjectsController implements ListSelectionListener, TableModelListener {

    private ProjectsTableModel projectsTableModel;
    private UsersTableModel usersTableModel;

    private AdminPanel adminPanel;
    
 
    public ProjectsController(AdminPanel gui) {
            this.adminPanel = gui;
            projectsTableModel = new ProjectsTableModel();
    }
    
    public TableModel getTableModel() {
    return projectsTableModel;
   }

    public void addRow(String[] vals) {
        System.out.println("in controller add row");
        projectsTableModel.addRow(vals);
    }
    
    public void deleteRow(String email) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        projectsTableModel.deleteRow(email);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("in value changed of projt table");
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
        int firstIndex = selectModel.getMinSelectionIndex();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //adminView.setTeamNameTextField((String)usersTableModel.getValueAt(firstIndex, 2));
        //adminView.setPMidTextField((String)projectsTableModel.getValueAt(firstIndex, 0));
        adminPanel.setPMidTextField((String)projectsTableModel.getValueAt(firstIndex, 0));
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String[][] getSearchResults(String cat) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         
        return projectsTableModel.getSearchResults(cat);
    }
    
}
