/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Projects;
import entity.Tasks;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import view.MainAppFrame;

/**
 *
 * @author Cherry
 */
public class ApplicationController {
    private static MainAppFrame mainFrame;
    private static EntityManager entityManager;
    private static Projects currentProject;
    
    public static MainAppFrame getMainFrame () {      
        return mainFrame;
    }
    
    public static void init(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PMToolPU");
        entityManager = emf.createEntityManager();
        switchCurrentProject(24); // TODO
    }
    
    public static void init(MainAppFrame frame) { 
        mainFrame = frame;
//        System.out.println("app init");
    }
    
    public static EntityManager getEnitityManager() {
        return entityManager;
    }
    
    public static Projects getCurrentProject() {
        return currentProject;
    }
    
    public static void switchCurrentProject(int projectId) {
        if (currentProject != null && currentProject.getId() == projectId) {
            return;
        }
        TypedQuery<Projects> query = (TypedQuery<Projects>) entityManager.createNamedQuery("Projects.findById");
        currentProject = query.setParameter("id", projectId).getSingleResult();
    }
}
