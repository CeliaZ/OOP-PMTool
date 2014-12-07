/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import javax.persistence.*;
import java.util.*;
import entity.*;
/**
 *
 * @author Shruti
 */
public class ProjectUsersService {
    
    private EntityManager manager;
	 
	 public ProjectUsersService(EntityManager manager) {
		 this.manager = manager;
	 }
	 
    // method to create a new record
     public ProjectsUsers createProjectsUsers(int id, int projectId, int userId, String role) {
    	ProjectsUsers pu = new ProjectsUsers();
        ProjectsUsersPK puPK = new ProjectsUsersPK();
        pu.setId(id);
//            pu.setCreatedAt(createdAt);
//            pu.setUpdatedAt(updatedAt);
        pu.setRole(role);
        puPK.setProjectId(projectId);
        puPK.setUserId(userId);
        pu.setProjectsUsersPK(puPK);
        return pu;
     }    
    // method to read a record
     public ProjectsUsers readProjectsUsers(ProjectsUsersPK puPK) {
         ProjectsUsers pu = manager.find(ProjectsUsers.class, puPK);return pu;
     }

     public List<ProjectsUsers> readProjectsUsers(int projectId) {
         //TypedQuery<ProjectsUsers> query = manager.createQuery("SELECT e FROM ProjectsUsers e where e.projectId =:arg1 ", ProjectsUsers.class);
         Query query = manager.createNamedQuery("ProjectsUsers.findByProjectId");
         query.setParameter("projectId", projectId);
         List<ProjectsUsers> result =  query.getResultList();
    	 return result;    
     }
     
     // method to read all records
     public List<ProjectsUsers> readAll() {
    	 TypedQuery<ProjectsUsers> query = manager.createQuery("SELECT e FROM ProjectsUsers e", ProjectsUsers.class);
    	 List<ProjectsUsers> result =  query.getResultList();

    	 return result;   	 
     }
     
    // method to update a record
     public ProjectsUsers updateUserInfo(ProjectsUsersPK puPK, int id, String role, Date createdAt, Date updatedAt) {
    	 ProjectsUsers pu = manager.find(ProjectsUsers.class, puPK);
    	 if (puPK != null) {
    	    pu.setId(id);
            pu.setCreatedAt(createdAt);
            pu.setUpdatedAt(updatedAt);
            pu.setRole(role);
            pu.setProjectsUsersPK(puPK);
                    
    	 }
    	 return pu;
     }

    // method to delete a record
    public void deleteProjectsUsers(ProjectsUsersPK puPK) {
        ProjectsUsers pu = manager.find(ProjectsUsers.class, puPK);
    	 if (puPK != null) {
    		 manager.remove(pu);
    	 }
    }
    
}
