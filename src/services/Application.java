/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.awt.Component;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JPanel;
import view.MainAppFrame;

/**
 *
 * @author Cherry
 */
public class Application {
    private static MainAppFrame mainFrame;
    private static JPanel panel;
    private static EntityManager entityManager;
    
    public static MainAppFrame getMainFrame () {      
        return mainFrame;
    }
    
//    public static JPanel getPanel () {
//        for (Component component : mainFrame.getComponents())
//            if (component.isVisible()) {
//                 panel = (JPanel) component;
//                 break;
//            }   
//        //mainFrame.getComponents()[0];
//        return panel;
//    }
    
    public static void init(MainAppFrame frame) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PMToolPU");
        entityManager = emf.createEntityManager();
        mainFrame = frame;
    }
    
    public static EntityManager getEnitityManager() {
        return entityManager;
    }
}
