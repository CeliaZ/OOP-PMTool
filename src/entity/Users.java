/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import services.Application;

/**
 *
 * @author Cherry
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByFirstName", query = "SELECT u FROM Users u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM Users u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Users.findByPasswordHash", query = "SELECT u FROM Users u WHERE u.passwordHash = :passwordHash"),
    @NamedQuery(name = "Users.findByPasswordSalt", query = "SELECT u FROM Users u WHERE u.passwordSalt = :passwordSalt"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByIsAdmin", query = "SELECT u FROM Users u WHERE u.isAdmin = :isAdmin"),
    @NamedQuery(name = "Users.findByCreatedAt", query = "SELECT u FROM Users u WHERE u.createdAt = :createdAt"),
    @NamedQuery(name = "Users.findByUpdatedAt", query = "SELECT u FROM Users u WHERE u.updatedAt = :updatedAt")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "password_hash")
    private String passwordHash;
    @Basic(optional = false)
    @Column(name = "password_salt")
    private String passwordSalt;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "is_admin")
    private boolean isAdmin;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    
//    
//    // many to many  with join table
//    
//    @ManyToMany(cascade=CascadeType.ALL)
//    @JoinTable(name="projects_users", 
//  joinColumns = @JoinColumn(name="user_id"),
//  inverseJoinColumns = @JoinColumn(name="project_id"))
//    private Set<Projects> projects;
//    
//    
//    public  Set<Projects> getProjects() {
//
//return projects;
//
//}
//
// 
//
//public void setProjects(Set<Projects> projectsList) {
//
//projects = projectsList;
//
//}
    
    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String firstName, String passwordHash, String passwordSalt, String email, boolean isAdmin) {
        this.id = id;
        this.firstName = firstName;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public Users(String firstName, String passwordHash, String passwordSalt, String email, boolean isAdmin) {
        this.firstName = firstName;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
        this.email = email;
        this.isAdmin = isAdmin;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Users[ id=" + id + " ]";
    }
    
    
//    // test for many to many
//    public static void main(String[] args) {
//    
//    // create sets of courses
//        
//        // create a set of student records
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PMToolPU");
//        EntityManager manager = emf.createEntityManager();
//    EntityTransaction transaction = manager.getTransaction();
//    Users user1 = new Users("testjoin2", "passwordHash", "Salt", "String@email.com", false);
//
////Users user2 = new Users("testjoin", "passwordHash", "String passwordSalt", "String@email.com", false);
// 
//
////
////HashSet<Users> set1 = new HashSet<Users>();
////
////set1.add(user1);
//
////set1.add(user2);
//
//
//transaction.begin();
//        manager.persist(user1);
////         Application.getEnitityManager().persist(user2);
//        transaction.commit();
//
//
//Projects project1 = new Projects("String projectName2");
//
////HashSet<Projects> projectSet1 = new HashSet<Projects>();
////        
////projectSet1.add(project1);
//
//
//transaction.begin();
//        manager.persist(project1);
////         Application.getEnitityManager().persist(user2);
//        transaction.commit();
//
//
//
////// students in set1 are enrolled in course1
////
////project1.setUsers(set1);
////
////user1.setProjects(projectSet1);
////
////transaction.begin();
////        manager.persist(project1);
//////         Application.getEnitityManager().persist(user2);
////        transaction.commit();
//
//
//        ProjectsUsers pu = new ProjectsUsers(project1.getId(),user1.getId());
//        pu.setRole("projectmanager");
//        transaction.begin();
//        manager.persist(pu);
//        transaction.commit();
//    }
}
