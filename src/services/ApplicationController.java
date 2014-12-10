/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Projects;
import entity.Tasks;
import entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import view.MainAppFrame;
import view.ProjectManagerPanel;

/**
 *
 * @author Cherry
 */
public class ApplicationController {
    private static MainAppFrame mainFrame;
    private static ProjectManagerPanel mainPanel;
    private static EntityManager entityManager;
    private static Projects currentProject;
    private static Users currentUser;
    
    public static MainAppFrame getMainFrame () {      
        return mainFrame;
    }
    
    public static void setMainPanel(ProjectManagerPanel panel) {
        mainPanel = panel;
    }
    
    public static ProjectManagerPanel getMainPanel() {
        return mainPanel;
    }
    
    public static void init(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PMToolPU");
        entityManager = emf.createEntityManager();
        switchCurrentProject(24); // TODO
        setCurrentUser(1); // TODO
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
    
    public static Users getCurrentUser() {
        return currentUser;
    }
    
    public static void setCurrentUser(Integer id) {
        TypedQuery<Users> query = (TypedQuery<Users>) entityManager.createNamedQuery("Users.findById");
        currentUser = query.setParameter("id", id).getSingleResult();
    }
    
    public static void switchCurrentProject(int projectId) {
        if (currentProject != null && currentProject.getId() == projectId) {
            return;
        }
        TypedQuery<Projects> query = (TypedQuery<Projects>) entityManager.createNamedQuery("Projects.findById");
        currentProject = query.setParameter("id", projectId).getSingleResult();
    }
}
