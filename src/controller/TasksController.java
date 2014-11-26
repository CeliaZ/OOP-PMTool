/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.TasksModel;
import view.MainAppFrame;

/**
 *
 * @author Cherry
 */
public class TasksController implements ListSelectionListener, RowSetListener{
    private TasksModel tasksModel;
    private MainAppFrame gui;
    
    public void addRow(String[] a) {
        for (String i: a) {
            System.out.print(i + " ");
        }
        System.out.println();
        tasksModel.addRow(a);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rowSetChanged(RowSetEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rowChanged(RowSetEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cursorMoved(RowSetEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
