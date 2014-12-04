/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Users;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author tanmaykuruvilla
 */
public class UsersService {
    
    //private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit"; // Used in persistence.xml
    private EntityManager manager; // JPA
    
    public UsersService(EntityManager manager) {
        this.manager = manager;
    }
    
     
    public String getPassword(String email)
    {
        
        EntityTransaction userTransaction = manager.getTransaction();
        //userTransaction.begin();
//        TypedQuery<Users> query = 
//        manager.createQuery("SELECT e.passwordHash FROM users e WHERE e.email = :cnum", Users.class);
        TypedQuery<Users> query = manager.createNamedQuery("Users.findPassByEmail", Users.class);
        query.setParameter("email", email);
        List<Users> result = query.getResultList(); 
        if(result.isEmpty())
        {
            return null;
        }
        Object[] res = result.toArray();
            
         System.out.println("pass word : "+res[0]);  
         return res[0].toString();

    }

    public Users createRow(String[] array) {
        System.out.println("in services create row");
        Users newUser =  new Users();
        newUser.setId(1);
        newUser.setFirstName(array[0]);
        newUser.setLastName(array[1]);
        newUser.setPasswordHash(array[2]);
        newUser.setPasswordSalt("random");
        newUser.setEmail(array[3]);
        newUser.setCreatedAt(null);
        newUser.setUpdatedAt(null);
        manager.persist(newUser);
        return newUser;
    }

    public void deleteRow(String email) 
    {
      
//        TypedQuery<Users> query = 
//        manager.createQuery("SELECT e.id FROM users e WHERE e.email = :cnum", Users.class);
          TypedQuery<Users> query = manager.createNamedQuery("Users.findIdByEmail", Users.class);
          query.setParameter("email", email);
          List<Users> result = query.getResultList(); 
        
        Object[] res = result.toArray();
            
           
        int id = Integer.parseInt(res[0].toString());
        
        System.out.println(id);
       Users users = manager.find(Users.class,id);
        if (users != null) {
        manager.remove(users);
       }
    }
    public List<Users> readAll() 
    {
        //TypedQuery<Users> query = manager.createQuery("SELECT T FROM " +Users.class.getName()+" T", Users.class); 
        TypedQuery<Users> query = manager.createNamedQuery("Users.findAll", Users.class);
        List<Users> result = query.getResultList();
        return result; 
    }

   

//    public List<Users> readSelected() {
//        TypedQuery<Users> query = manager.createQuery("SELECT e.firstName,e.lastName, e.email FROM users e", Users.class);
//        List<Users> result = query.getResultList(); 
//        return result;
//    }

    public String[] getUserList() {
        //TypedQuery<Users> query = manager.createQuery("SELECT T FROM " +Users.class.getName()+" T", Users.class);
        TypedQuery<Users> query = manager.createNamedQuery("Users.findAll", Users.class);
        List<Users> result = query.getResultList();
        int size = result.size();
        String[] data = new String[size];
        int x=0;
        for(Users c: result)
        {
            
                data[x] = c.getEmail();         
                x++;
            
        }
        return data;
    }
    
    
    public static void main(String[] args) {
        
    }
    
            
}
