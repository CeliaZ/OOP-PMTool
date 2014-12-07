/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.event.*;
import model.*;
import view.*;

/**
 *
 * @author Shruti
 */
public class ProjectUsersController{
    private ProjectUsersModel tableModel;
	private ManageTeamsPanel gui;
	
	public ProjectUsersController(ManageTeamsPanel gui) {
		this.gui = gui;   
         // create the tableModel using the data in the cachedRowSet
    		tableModel = new ProjectUsersModel(); 
    	}
	
	
	// new code
	public TableModel getTableModel() {
		return tableModel;
	}
        
        
//	public void tableChanged(TableModelEvent e)
//	{
//	   try {
//	    	// get the index of the inserted row
//	        //tableModel.getRowSet().moveToCurrentRow();
//	    	int firstIndex =  e.getFirstRow();
//	    	
//	    	// create a new table model with the new data
//	        tableModel = new ProjectUsersModel(tableModel.getList(), tableModel.getEntityManager());
//	        tableModel.addTableModelListener(this);
//	        // update the JTable with the data
//	    	gui.updateTable();
//	    
////	        // read the data in each column using getValueAt and display it on corresponding textfield
//		gui.setuserIdTextField( (String) tableModel.getValueAt(firstIndex, 0));
////			gui.setfnameTextField( (String) tableModel.getValueAt(firstIndex, 1));
////			gui.setlnameTextField( (String) tableModel.getValueAt(firstIndex, 2));
////			gui.setpasswordTextField( (String) tableModel.getValueAt(firstIndex, 3));
////			gui.setemailTextField( (String) tableModel.getValueAt(firstIndex, 4));
//	} catch(Exception exp) {
//		exp.getMessage();
//		exp.printStackTrace();
//	}
//}
//
//
//	public void valueChanged(ListSelectionEvent e) {
//		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
//		int firstIndex = selectModel.getMinSelectionIndex();
//		
//		// read the data in each column using getValueAt and display it on corresponding textfield
//		gui.setuidTextField( (String) tableModel.getValueAt(firstIndex, 0));
//		gui.setfnameTextField( (String) tableModel.getValueAt(firstIndex, 1));
//		gui.setlnameTextField( (String) tableModel.getValueAt(firstIndex, 2));
//		gui.setpasswordTextField( (String) tableModel.getValueAt(firstIndex, 3));
//		gui.setemailTextField( (String) tableModel.getValueAt(firstIndex, 4));
//	}
	
	public void addRow(Object[] array) {
		tableModel.addRow(array);			
	}

        public void deleteRow(Object[] array) {
		// TODO Auto-generated method stub
		tableModel.deleteRow(array);
		
	}
    
}
