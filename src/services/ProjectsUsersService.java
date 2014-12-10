/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.ProjectsUsers;
import entity.ProjectsUsersPK;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author tanmaykuruvilla
 */
public class ProjectsUsersService {
    //private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit"; // Used in persistence.xml
    private EntityManager manager; // JPA
    
    public ProjectsUsersService(EntityManager manager) {
        this.manager = manager;
    }
    
     
    public String getPassword(String email)
    {
        
        EntityTransaction userTransaction = manager.getTransaction();
        //userTransaction.begin();
//        TypedQuery<ProjectsUsers> query = 
//        manager.createQuery("SELECT e.passwordHash FROM users e WHERE e.email = :cnum", ProjectsUsers.class);
        TypedQuery<ProjectsUsers> query = manager.createNamedQuery("ProjectsUsers.findPassByEmail", ProjectsUsers.class);
        query.setParameter("email", email);
        List<ProjectsUsers> result = query.getResultList(); 
        if(result.isEmpty())
        {
            return null;
        }
        Object[] res = result.toArray();
            
         System.out.println("pass word : "+res[0]);  
         return res[0].toString();

    }

    public ProjectsUsers createRow(String[] array) {
//        System.out.println("in services create row");
//        ProjectsUsers newUser =  new ProjectsUsers();
//        newUser.setId(1);
//        newUser.setFirstName(array[0]);
//        newUser.setLastName(array[1]);
//        newUser.setPasswordHash(array[2]);
//        newUser.setPasswordSalt("random");
//        newUser.setEmail(array[3]);
//        newUser.setCreatedAt(null);
//        newUser.setUpdatedAt(null);
//        manager.persist(newUser);
//        return newUser;
        return null;
    }
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

    public void deleteRow(String email) 
    {
      
//        TypedQuery<ProjectsUsers> query = 
//        manager.createQuery("SELECT e.id FROM users e WHERE e.email = :cnum", ProjectsUsers.class);
          TypedQuery<ProjectsUsers> query = manager.createNamedQuery("ProjectsUsers.findIdByEmail", ProjectsUsers.class);
          query.setParameter("email", email);
          List<ProjectsUsers> result = query.getResultList(); 
        
        Object[] res = result.toArray();
            
           
        int id = Integer.parseInt(res[0].toString());
        
        System.out.println(id);
       ProjectsUsers users = manager.find(ProjectsUsers.class,id);
        if (users != null) {
        manager.remove(users);
       }
    }
    
       // method to delete a record
    public void deleteProjectsUsers(ProjectsUsersPK puPK) {
        ProjectsUsers pu = manager.find(ProjectsUsers.class, puPK);
    	 if (puPK != null) {
    		 manager.remove(pu);
    	 }
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
    
    
    public List<ProjectsUsers> readAll() 
    {
        //TypedQuery<ProjectsUsers> query = manager.createQuery("SELECT T FROM " +ProjectsUsers.class.getName()+" T", ProjectsUsers.class); 
        TypedQuery<ProjectsUsers> query = manager.createNamedQuery("ProjectsUsers.findAll", ProjectsUsers.class);
        List<ProjectsUsers> result = query.getResultList();
        return result; 
    }

   

//    public List<ProjectsUsers> readSelected() {
//        TypedQuery<ProjectsUsers> query = manager.createQuery("SELECT e.firstName,e.lastName, e.email FROM users e", ProjectsUsers.class);
//        List<ProjectsUsers> result = query.getResultList(); 
//        return result;
//    }

    public String[] getUserList() {
        //TypedQuery<ProjectsUsers> query = manager.createQuery("SELECT T FROM " +ProjectsUsers.class.getName()+" T", ProjectsUsers.class);
        TypedQuery<ProjectsUsers> query = manager.createNamedQuery("ProjectsUsers.findAll", ProjectsUsers.class);
        List<ProjectsUsers> result = query.getResultList();
        int size = result.size();
        String[] data = new String[size];
        int x=0;
        for(ProjectsUsers c: result)
        {
            
                //data[x] = c.getEmail();         
                x++;
            
        }
        return data;
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
     
 
    
    
    public static void main(String[] args) {
        
    }
    
    
}
