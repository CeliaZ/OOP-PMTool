/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author tanmaykuruvilla
 */
public class ProjectsService {
    private EntityManager manager; // JPA
    
    public ProjectsService(EntityManager manager) {
        this.manager = manager;
    }
    
    public Projects createRow(String[] array) {
        String email = array[1];
//        TypedQuery<Projects> query = 
//        manager.createQuery("SELECT e.id FROM users e WHERE e.email = :cnum", Projects.class);
//        query.setParameter("cnum", email);
//        List<Projects> result = query.getResultList(); 
        
//        TypedQuery<Users> query = 
//        manager.createQuery("SELECT e.id FROM users e WHERE e.email = :cnum", Users.class);
        TypedQuery<Users> query = manager.createNamedQuery("Users.findIdByEmail", Users.class);      
        query.setParameter("email", email);
        List<Users> result = query.getResultList(); 
        
        
        Object[] res = result.toArray();
            
           
        int id = Integer.parseInt(res[0].toString());
        
        TypedQuery<Users> query1 = manager.createNamedQuery("Users.findById", Users.class);
        query1.setParameter("id", id);
        //List <Users> result1 = query1.getResultList();
        Users result1 = query1.getSingleResult();
        System.out.println(result1);
        
        System.out.println("in services create row");
        Projects newProject =  new Projects();
        newProject.setId(1);
        newProject.setProjectName(array[0]);
        newProject.setPmId(id);
        newProject.setDescription("");
        newProject.setStatus("Initialezed");
        newProject.setCategory(array[2]);
        newProject.setCreatedAt(null);
        newProject.setUpdatedAt(null);
        
        manager.persist(newProject);
        
        TypedQuery<Projects> query4 = manager.createNamedQuery("Projects.findProjectIdByName", Projects.class);
        query4.setParameter("projectName", array[0]);      
        List<Projects> result4 = query4.getResultList(); 
         
        
        Object[] res4 = result4.toArray();
        int pid = Integer.parseInt(res4[0].toString());
        
        System.out.println("value of project id :"+pid);
        System.out.println("value of user id :"+ id);
        
//      query1.getSingleResult().setProjectsUsersCollection(query3.getResultList());
        
        
        
        ProjectsUsers projUser = new ProjectsUsers();
        projUser.setId(1);
        projUser.setProjects(newProject);
        projUser.setUsers(query1.getSingleResult());
        projUser.setRole("ProjManager");
        ProjectsUsersPK pk = new ProjectsUsersPK(pid, id);
        projUser.setProjectsUsersPK(pk);
       
        projUser.setCreatedAt(null);
        projUser.setUpdatedAt(null);
        
        //manager.persist(newProject);
        manager.persist(projUser);
        
        
        //////new 
//        TypedQuery<ProjectsUsers> query2 = manager.createNamedQuery("ProjectsUsers.findByUserId", ProjectsUsers.class);
//        query2.setParameter("userId", id);
//        newProject.setProjectsUsersCollection(query2.getResultList());
//        
//        TypedQuery<ProjectsUsers> query3 = manager.createNamedQuery("ProjectsUsers.findByProjectId", ProjectsUsers.class);
//        query3.setParameter("projectId", id);
//        query1.getSingleResult().setProjectsUsersCollection(query3.getResultList());
        
        
        //manager.persist(newProject);
        //manager.persist(projUser);
        //manager.persist(query1.getSingleResult());
        //manager.persist(projUser);
        
        return newProject;
    }

    public void deleteRow(String _id) 
    {
      
//        System.out.println(id);
//        TypedQuery<Projects> query = 
//        manager.createQuery("SELECT e.id FROM projects e WHERE e.email = :cnum", Projects.class);
//        query.setParameter("cnum", email);
//        List<Projects> result = query.getResultList(); 
//        
//        Object[] res = result.toArray();
//            
//           
//        int id = Integer.parseInt(res[0].toString());
        int id = Integer.parseInt(_id);
        System.out.println(id);
        Projects projects = manager.find(Projects.class,id);
        if (projects != null) {
        manager.remove(projects);
       }
    }
    public List<Projects> readAll() 
    {
        //TypedQuery<Projects> query = manager.createQuery("SELECT T FROM " +Projects.class.getName()+" T", Projects.class);  
        TypedQuery<Projects> query = manager.createNamedQuery("Projects.findAll", Projects.class);
        List<Projects> result = query.getResultList();
        return result; 
    }

    public String[][] getSearchResults(String category) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TypedQuery<Projects> query = manager.createNamedQuery("Projects.findByCategory", Projects.class);
        query.setParameter("category", category);
        List<Projects> result = query.getResultList();
        
        int size = result.size();
        
        //String[] columnName = {"cid","cname","enrollment"};
        String[][] data = new String[size][7];
        int x= 0;
        for(Projects c: result)
        {
            
                data[x][0] = c.getId().toString();
                data[x][1] = c.getProjectName();
                data[x][2] = c.getCategory();
                data[x][3] = c.getPmId().toString();
                data[x][4] = c.getDescription();
                data[x][5] = c.getCreatedAt().toString();
                data[x][6] = c.getStatus();
                
                
                x++;
            
        }
        //String[] colnames = {"Project_id","Proj Name","Category","PmID","Description","Created Project At","Status"};
        
        return data;
    
    }

    
}
