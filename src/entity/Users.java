/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tanmaykuruvilla
 */
//SELECT e.id FROM users e WHERE e.email = :cnum
//manager.createQuery("SELECT T FROM " +Projects.class.getName()+" T", Projects.class);
//SELECT e.passwordHash FROM users e WHERE e.email = :cnum
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
    @NamedQuery(name = "Users.findByUpdatedAt", query = "SELECT u FROM Users u WHERE u.updatedAt = :updatedAt"),
    @NamedQuery(name = "Users.findIdByEmail", query = "SELECT e.id FROM Users e WHERE e.email = :email"),
    @NamedQuery(name = "Users.findPassByEmail", query = "SELECT e.passwordHash FROM Users e WHERE e.email = :email")
 })
public class Users implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<ProjectsUsers> projectsUsersCollection;
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
    @Column(name = "created_at",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

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

    //cherry

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

    public String getColumnData(int i) throws Exception
    {
    if (i == 0)
    return getId().toString();
    else if (i == 1)
    return getFirstName();
    else if (i == 2)
    return getLastName();
    else if (i == 3)
    return getPasswordHash();
    else if(i == 4)
    return getPasswordSalt();
    else if(i == 5)
        return (""+getIsAdmin());
    else if(i == 6)
        return getEmail();
    else if(i == 7)
        return getCreatedAt()+"";
    else if(i == 8)
        return getUpdatedAt()+"";
    
    else
    throw new Exception("Error: invalid column index in courselist table");
    }
    
    public String getColumnName(int i) throws Exception {

    String colName = null;
    if (i == 0)
    colName = "userID";
    else if (i == 1)
    colName = "firstName";
    else if (i == 2)
   colName = "lastName";
    else if (i == 3)
    colName = "password";
    else if (i == 4)
    colName = "passSalt" ; 
    else if (i == 5)
    colName = "isAdmin";
    else if (i == 6)
    colName = "email";
    else if (i == 7)
    colName = "createdAt";
    else if (i == 8)
    colName = "updatedAt";
    
    else    
    throw new Exception("Access to invalid column number in courselist table");
    return colName;
    }
    
    public void setColumnData(int col, Object aValue) {
    }
    
     public int getNumberOfColumns() {
    return 9;
    }
    
    public static void  main(String [] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PMToolPU");
        EntityManager manager = emf.createEntityManager();
        //EntityTransaction trans = manager.getTransaction();
        //Courselist obj = new Courselist();
        EntityTransaction userTransaction = manager.getTransaction();
        userTransaction.begin();
        Users newUser =  new Users();
        newUser.setId(null);
        newUser.setFirstName("Test1");
        newUser.setLastName("Test2");
        newUser.setPasswordHash("test0000");
        newUser.setPasswordSalt("");
        newUser.setEmail("test@emaol");
        //newUser.setCreatedAt(1);
        //newUser.setUpdatedAt(null);
        manager.persist(newUser);
        userTransaction.commit();
        
        
        manager.close();
        emf.close();
    }

    

   

    @XmlTransient
    public Collection<ProjectsUsers> getProjectsUsersCollection() {
        return projectsUsersCollection;
    }

    public void setProjectsUsersCollection(Collection<ProjectsUsers> projectsUsersCollection) {
        this.projectsUsersCollection = projectsUsersCollection;
    }
    
}
