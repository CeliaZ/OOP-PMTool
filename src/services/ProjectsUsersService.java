/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.ProjectsUsers;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
    
    
    public static void main(String[] args) {
        
    }
    
    
}
