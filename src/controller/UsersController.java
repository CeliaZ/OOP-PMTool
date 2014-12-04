/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import services.*;

import javax.persistence.Persistence;
import entity.*;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import model.*;
import view.AdminPanel;


/**
 *
 * @author tanmaykuruvilla
 */
public class UsersController implements ListSelectionListener, TableModelListener{
    

    private UsersTableModel usersTableModel;
    private AdminPanel adminPanel;
    //UsersService userService;
    
 
    public UsersController(AdminPanel gui) {
            this.adminPanel = gui;
            usersTableModel = new UsersTableModel();
    }
    
    public boolean authenticateUser(String email, String password)
    {
        System.out.println("in controller suthUser");
        //usersTableModel = new UsersTableModel();
        
        String pass = usersTableModel.getPassword(email);
        System.out.println("after call to services! now back in controller authUser");
        if(password.equals(pass))
        {
            System.out.println("User Authenticated");
            return true;
        }
        else
            return false;
    }
    
    public TableModel getTableModel() {
    return usersTableModel;
   }

    public void addRow(String[] vals) {
        System.out.println("in controller add row");
        usersTableModel.addRow(vals);
    }
    
    public void deleteRow(String email) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        usersTableModel.deleteRow(email);
    }

     
   
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("in valuechanged method");
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
        int firstIndex = selectModel.getMinSelectionIndex();
        // read the data in each column using getValueAt and
        //display it on corresponding textfield
//        adminView.setF_NameTextField((String)usersTableModel.getValueAt(firstIndex, 1));
//        adminView.setL_nameTextField((String)usersTableModel.getValueAt(firstIndex, 2));
//        adminView.setEmailTextField((String)usersTableModel.getValueAt(firstIndex, 6));
//        adminView.setPasswordTextField((String)usersTableModel.getValueAt(firstIndex, 3));
        
        adminPanel.setF_NameTextField((String)usersTableModel.getValueAt(firstIndex, 1));
        adminPanel.setL_nameTextField((String)usersTableModel.getValueAt(firstIndex, 2));
        adminPanel.setEmailTextField((String)usersTableModel.getValueAt(firstIndex, 6));
        adminPanel.setPasswordTextField((String)usersTableModel.getValueAt(firstIndex, 3));
        
        
        
        //adminView.setPMidTextField((String)usersTableModel.getValueAt(firstIndex, 2));

        
        
    }
    

    @Override
    public void tableChanged(TableModelEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
               System.out.println("In tableChanged of user controller !!!");
	    	// get the index of the inserted row
	        //tableModel.getRowSet().moveToCurrentRow();
	    	int firstIndex =  e.getFirstRow();
	    	
	    	// create a new table model with the new data
	        usersTableModel = new UsersTableModel(usersTableModel.getList(), usersTableModel.getEntityManager());
	        usersTableModel.addTableModelListener(this);
	        // update the JTable with the data
	    	//adminView.updateTable();
                adminPanel.updateTable();
	    
	        // read the data in each column using getValueAt and display it on corresponding textfield
//			adminView.setF_NameTextField((String)usersTableModel.getValueAt(firstIndex, 1));
//                        adminView.setL_nameTextField((String)usersTableModel.getValueAt(firstIndex, 2));
//                        adminView.setEmailTextField((String)usersTableModel.getValueAt(firstIndex, 6));
//                        adminView.setPasswordTextField((String)usersTableModel.getValueAt(firstIndex, 3));
//                        
//                        adminView.populateCombUserList();
                        
                        adminPanel.setF_NameTextField((String)usersTableModel.getValueAt(firstIndex, 1));
                        adminPanel.setL_nameTextField((String)usersTableModel.getValueAt(firstIndex, 2));
                        adminPanel.setEmailTextField((String)usersTableModel.getValueAt(firstIndex, 6));
                        adminPanel.setPasswordTextField((String)usersTableModel.getValueAt(firstIndex, 3));
                        
                        adminPanel.populateCombUserList();

	} catch(Exception exp) {
		exp.getMessage();
		exp.printStackTrace();
	}
    }

    /////added to fill combobox
    public String[] getUserList() {
        return (usersTableModel.getUserList());
    }

   
    
    
    
    
    
    
}
