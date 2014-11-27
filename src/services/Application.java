/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;

/**
 *
 * @author Cherry
 */
public class Application {
    private JFrame mainFrame;
    private static EntityManager entityManager;
    
    public JFrame getMainFrame () {
        return mainFrame;
    }
    
    public static void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PMToolPU");
        entityManager = emf.createEntityManager();
    }
    
    public static EntityManager getEnitityManager() {
        return entityManager;
    }
}
