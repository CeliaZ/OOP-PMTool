/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tanmaykuruvilla
 */
import java.awt.BorderLayout;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.*;
import javax.swing.event.*;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.*;
import entity.*;
import services.*;


public class UsersTableModel extends AbstractTableModel {
/*private String[] columnNames = {"course name", "course number",
"enrollment", "start date", "end date"};
private String[][] data = {
{"Object Oriented Programming", "COEN 275", "39", "31-3-2014", "13-6-2014" },
{"Real Time Systems", "COEN 120", "16", "31-3-2014", "13-6-2014"},
{"Logic Design", "ELEN 21", "40", "31-3-2014", "13-6-2014"}
};*/
    private static final String PERSISTENCE_UNIT_NAME ="PMToolPU"; // Used in persistence.xml
    private static EntityManagerFactory factory; // JPA
    private EntityManager manager; // JPA
    private Users users;//
    private UsersService usersService;
    private int numcols, numrows;
    List<Users> usersResultList;
  
public  UsersTableModel() {

        factory =Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        users = new Users();
        // read all the records from userInfo
         usersService = new UsersService(manager);
        //usersService = new UsersService();
        // update the number of rows and columns in the model
       usersResultList = usersService.readAll();

        numrows = usersResultList.size();
        numcols = users.getNumberOfColumns();
}
   
 public UsersTableModel(List<Users> list, EntityManager em) {
        usersResultList = list;
        numrows = usersResultList.size();
        users = new Users();
        numcols = users.getNumberOfColumns();
        manager = em;
        usersService = new UsersService(manager);
 }
 

   public void addRow(Object[] array) {
//data[rowIndex][columnIndex] = (String) aValue;
// complete the code
}
public int getRowCount() {
    return numrows;
}
public int getColumnCount() {
    return numcols;
}
public Object getValueAt(int row, int col) {
try {
        return usersResultList.get(row).getColumnData(col);
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
          return users.getColumnName(col);
    } catch (Exception err) {
        return err.toString();
    }
}
public void setValueAt(Object aValue, int row, int col) {
try {
        Users element = usersResultList.get(row);
        element.setColumnData(col, aValue);
        fireTableCellUpdated(row, col);
    } catch(Exception err) {
    err.toString();
    }
}
public List<Users> getList() {
    return usersResultList;
}

public EntityManager getEntityManager() {
    return manager;
}

public String getPassword(String email)
{
    System.out.println("in table model getpassword");
    EntityTransaction userTransaction = manager.getTransaction();
    userTransaction.begin();
    String pass = usersService.getPassword(email);
    userTransaction.commit();
    return pass;
    
}

public void addRow(String[] array)
{
    System.out.println("in table model addRow before commit");
    EntityTransaction userTransaction = manager.getTransaction();
    userTransaction.begin();
    
    Users newRecord = usersService.createRow(array);

    userTransaction.commit();
    System.out.println("in table model addRow after commit");

    usersResultList.add(newRecord);
    int row = usersResultList.size();
    int col = 0;

    fireTableDataChanged();
    numrows++;
}

public void deleteRow(String email)
{
    EntityTransaction userTransaction = manager.getTransaction();
    userTransaction.begin();
    usersService.deleteRow(email);
    userTransaction.commit();
    usersResultList = usersService.readAll();
    fireTableDataChanged();
    
    numrows--;
}   
  /// to populate the combobox
    public String[] getUserList() {
        return(usersService.getUserList());
    }


}
