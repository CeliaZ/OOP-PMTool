/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;
import services.ProjectsService;

/**
 *
 * @author tanmaykuruvilla
 */
public class ProjectsTableModel extends AbstractTableModel{
    
    private static final String PERSISTENCE_UNIT_NAME ="PMToolPU"; // Used in persistence.xml
    private static EntityManagerFactory factory; // JPA
    private EntityManager manager; // JPA
    private Projects projects;//
    private ProjectsService projectsService;
    private int numcols, numrows;
    List<Projects> projectsResultList;
    
    public  ProjectsTableModel() {

        factory =Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        projects = new Projects();
        // read all the records from userInfo
         projectsService = new ProjectsService(manager);
        //projectsService = new ProjectsService();
        // update the number of rows and columns in the model
       projectsResultList = projectsService.readAll();

        numrows = projectsResultList.size();
        numcols = projects.getNumberOfColumns();
}
   
 public ProjectsTableModel(List<Projects> list, EntityManager em) {
        projectsResultList = list;
        numrows = projectsResultList.size();
        projects = new Projects();
        numcols = projects.getNumberOfColumns();
        manager = em;
        projectsService = new ProjectsService(manager);
 }
    

    @Override
    public int getRowCount() {
           return numrows;
    }

    @Override
    public int getColumnCount() {
           return numcols;
    }

    @Override
    public Object getValueAt(int row, int col) {
      try {
        return projectsResultList.get(row).getColumnData(col);
    } catch (Exception e) {
         e.getMessage();
        return null;
    }
    }
    
    public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;
}
public Class<?> getColumnClass(int col) {
     
        return getValueAt(0, col).getClass();
}
public String getColumnName(int col) {
try {
          return projects.getColumnName(col);
    } catch (Exception err) {
        return err.toString();
    }
}
public void setValueAt(Object aValue, int row, int col) {
try {
        Projects element = projectsResultList.get(row);
        element.setColumnData(col, aValue);
        fireTableCellUpdated(row, col);
    } catch(Exception err) {
    err.toString();
    }
}
public List<Projects> getList() {
    return projectsResultList;
}

public EntityManager getEntityManager() {
    return manager;
}
    
    
    public void addRow(String[] array)
    {
    System.out.println("in table model addRow before commit");
    EntityTransaction userTransaction = manager.getTransaction();
    userTransaction.begin();
    
    Projects newRecord = projectsService.createRow(array);

    userTransaction.commit();
    System.out.println("in table model addRow after commit");

    projectsResultList.add(newRecord);
    int row = projectsResultList.size();
    int col = 0;

    fireTableDataChanged();
    numrows++;
   }

public void deleteRow(String id)
{
    EntityTransaction userTransaction = manager.getTransaction();
    userTransaction.begin();
    projectsService.deleteRow(id);
    userTransaction.commit();
    projectsResultList = projectsService.readAll();
    fireTableDataChanged();
    
    numrows--;
}   

    public String[][] getSearchResults(String category) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return projectsService.getSearchResults(category);
    }
}
