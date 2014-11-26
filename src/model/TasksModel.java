/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import javax.swing.table.*;
import java.sql.*;
import javax.sql.*;
import javax.sql.rowset.*;
import com.sun.rowset.CachedRowSetImpl;
/**
 *
 * @author Cherry
 */
public class TasksModel  extends AbstractTableModel{
    CachedRowSet userRowSet; // contains data
    ResultSetMetaData metadata;     // Additional information about the data
    Connection connection;
    int numcols, numrows;           // number of rows and columns
    
    public TasksModel() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
          } catch (Exception  e) {
            System.err.println("Unable to find and load driver");
            System.exit(1);
         }

        try {
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/oop?zeroDateTimeBehavior=convertToNull", "root", "");
        
        } catch(SQLException err) {
            System.out.println(err.getMessage());
            err.printStackTrace();
        }
         
        System.out.println("Connected successfully");
    	try {
                connection.setAutoCommit(false);
                userRowSet = new CachedRowSetImpl();
                userRowSet.setCommand("SELECT * FROM user");
                userRowSet.execute(connection);
                metadata = userRowSet.getMetaData();
                numcols = metadata.getColumnCount();
                numrows = userRowSet.size(); 
                userRowSet.first();
    	} catch(SQLException exp) { 
 	    exp.printStackTrace();        	  
 	}
    }
    
    public TasksModel(RowSet rowset, Connection conn)  {
    	try {
            userRowSet = (CachedRowSet) rowset;
            metadata = userRowSet.getMetaData();
            numcols = metadata.getColumnCount();
            numrows = userRowSet.size();
            connection = conn;   
    	} catch(SQLException exp) {
            exp.printStackTrace();
    	}
    }

    public Connection getConnection() {
    	return connection;
    }
    
    public int getRowCount() {
        return numrows;
    }
	
    public int getColumnCount() {
            return numcols;
    }

    public Object getValueAt(int row, int col) {
        try {
            userRowSet.absolute(row + 1);
             Object obj = userRowSet.getObject(col + 1);
            if (obj == null)
                return null;
            else
                return obj.toString();
        } catch (SQLException err) {
            return err.toString();
        }
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public String getColumnName(int col) {
        try {
            return metadata.getColumnLabel(col+1);
        } catch (SQLException err) {
            return err.toString();
        }             
    }

    public void setValueAt(Object aValue, int row, int col) {
            //data[rowIndex][columnIndex] = (String) aValue;

        try {
            userRowSet.moveToInsertRow();
            System.out.println(aValue+"setvalueAt "+(row+1)+" " +(col+1));
            userRowSet.updateObject(col+1, (String) aValue);	
        } catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }

    }
    
    public RowSet getRowSet() {
            return (RowSet) userRowSet;
    }	
    
    public void addRow(Object[] array) {
    try {
            //userRowSet.last();
            //userRowSet.moveToInsertRow();
            userRowSet.updateString("task_name", (String) array[0]);
            userRowSet.updateString("description", (String) array[1]);                  
            userRowSet.updateInt("owner_id",  Integer.valueOf((String) array[2]).intValue());
            //userRowSet.updateString("budget", (String) array[3]);
            
            //userRowSet.insertRow();
            //userRowSet.moveToCurrentRow();
            userRowSet.acceptChanges(connection);	
        } catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    } 
}
