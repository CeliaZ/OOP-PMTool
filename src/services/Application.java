/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import view.MainAppFrame;

/**
 *
 * @author Cherry
 */
public class Application {
    private static MainAppFrame mainFrame;
    private static EntityManager entityManager;
    
    public static MainAppFrame getMainFrame () {      
        return mainFrame;
    }
    
    public static void init(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PMToolPU");
        entityManager = emf.createEntityManager();
    }
    
    public static void init(MainAppFrame frame) { 
        mainFrame = frame;
//        System.out.println("app init");
    }
    
    public static EntityManager getEnitityManager() {
        return entityManager;
    }
}
