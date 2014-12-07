/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.table.AbstractTableModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.*;
import javax.persistence.*;
import entity.*;
import java.util.*;
import services.*;

/**
 *
 * @author Shruti
 */
public class ProjectUsersModel extends AbstractTableModel {
	List<ProjectsUsers> projectsUsersResultList;   // stores the model data in a List collection of type ProjectsUsers
	  private static final String PERSISTENCE_UNIT_NAME = "JPAProject";  // Used in persistence.xml
	  private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;				// JPA 
	  private ProjectsUsers pu;			    // represents the entity proejctsusers
	  private ProjectUsersService projectUsersService;
	
	   // This field contains additional information about the results   
	    int numcols, numrows;           // number of rows and columns

	public ProjectUsersModel() {
	    factory = Persistence.createEntityManagerFactory("PMToolPU");
	    manager = factory.createEntityManager();
	  
	    pu = new ProjectsUsers();
	    projectUsersService = new ProjectUsersService(manager);
	    
	    // read all the records from ProjectsUsers
	    projectsUsersResultList = projectUsersService.readProjectsUsers(2);
	    
	    // update the number of rows and columns in the model
	    numrows = projectsUsersResultList.size();
	    numcols = pu.getNumberOfColumns();
    }

	 // returns a count of the number of rows
	 public int getRowCount() {
		return numrows;
	 }
	
	 // returns a count of the number of columns
	 public int getColumnCount() {
		return numcols;
	 }
	
	 // returns the data at the given row and column number
	 public Object getValueAt(int row, int col) {
		try {
		  return projectsUsersResultList.get(row).getColumnData(col);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	 }
	
	 // table cells are not editable
	 public boolean isCellEditable(int rowIndex, int colIndex) {
		return false;
	 }
	
	 public Class<?> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	 }
	
	 // returns the name of the column
	 public String getColumnName(int col) {
		   try {
				return pu.getColumnName(col);
			} catch (Exception err) {
	             return err.toString();
	       }             
	 }
	
	 // update the data in the given row and column to aValue
	 public void setValueAt(Object aValue, int row, int col) {
		//data[rowIndex][columnIndex] = (String) aValue;
		try {
		   ProjectsUsers element = projectsUsersResultList.get(row);
                 element.setColumnData(col, aValue); 
          fireTableCellUpdated(row, col);
		} catch(Exception err) {
			err.toString();
		}	
	 }
	
	 public List<ProjectsUsers> getList() {
		 return projectsUsersResultList;
	 }

	 public EntityManager getEntityManager() {
	      return manager;
	 }

	 // create a new table model using the existing data in list
	 public ProjectUsersModel(List<ProjectsUsers> list, EntityManager em)  {
	    projectsUsersResultList = list;
	    numrows = projectsUsersResultList.size();
	    pu = new ProjectsUsers();
	   	numcols = pu.getNumberOfColumns();     
		manager = em;
                projectUsersService = new ProjectUsersService(manager);
         }
	 
	 // In this method, a newly inserted row in the GUI is added to the table model as well as the database table
	 // The argument to this method is an array containing the data in the textfields of the new row.
	 public void addRow(Object[] array) {
		//data[rowIndex][columnIndex] = (String) aValue;
			
	    // add row to database
		EntityTransaction userTransaction = manager.getTransaction();  
		userTransaction.begin();
		ProjectsUsers newRecord = projectUsersService.createProjectsUsers((int) array[0],(int) array[1],(int) array[2], (String) array[3]);
		manager.persist(newRecord);
                userTransaction.commit();
		
		// set the current row to rowIndex
      projectsUsersResultList.add(newRecord);
      int row = projectsUsersResultList.size();  
      int col = 0;

      // update the data in the model to the entries in array
       for (Object data : array) {
        	 setValueAt(data, row-1, col++);
       }
       numrows++;
       fireTableRowsInserted(row-1, row-1);
       
	}	
	 public void deleteRow(Object[] array){
		 
                        int projectId =(int) array[1];
                        int userId = (int) array[2];
                        ProjectsUsersPK puPK = new ProjectsUsersPK(projectId, userId);
			
			if(projectId == 0 || userId == 0) {
				return;
			}
			 EntityTransaction userTransaction = manager.getTransaction();  
				userTransaction.begin();
			projectUsersService.deleteProjectsUsers(puPK);
			int counter=0;
			for(ProjectsUsers record: projectsUsersResultList){
                            if(record.getProjectsUsersPK().equals(puPK))
                            {
                                projectsUsersResultList.remove(counter);
                                break;
                            }
				counter++;
			}
			System.out.println(counter);
			userTransaction.commit();
			numrows--;
			fireTableRowsDeleted(counter, counter);
			
	 }
	

    
}
