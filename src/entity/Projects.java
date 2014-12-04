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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tanmaykuruvilla
 */
@Entity
@Table(name = "projects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projects.findAll", query = "SELECT p FROM Projects p"),
    @NamedQuery(name = "Projects.findById", query = "SELECT p FROM Projects p WHERE p.id = :id"),
    @NamedQuery(name = "Projects.findByProjectName", query = "SELECT p FROM Projects p WHERE p.projectName = :projectName"),
    @NamedQuery(name = "Projects.findByPmId", query = "SELECT p FROM Projects p WHERE p.pmId = :pmId"),
    @NamedQuery(name = "Projects.findByStatus", query = "SELECT p FROM Projects p WHERE p.status = :status"),
    @NamedQuery(name = "Projects.findByCategory", query = "SELECT p FROM Projects p WHERE p.category = :category"),
    @NamedQuery(name = "Projects.findByCreatedAt", query = "SELECT p FROM Projects p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "Projects.findByUpdatedAt", query = "SELECT p FROM Projects p WHERE p.updatedAt = :updatedAt"),
    @NamedQuery(name = "Projects.findProjectIdByName", query = "SELECT p.id FROM Projects p WHERE p.projectName = :projectName"),})
public class Projects implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "pm_id")
    private Integer pmId;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private String status;
    @Column(name = "category")
    private String category;
    @Column(name = "created_at",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projects")
    private Collection<ProjectsUsers> projectsUsersCollection;

//cherry

      @OneToMany(cascade = CascadeType.ALL, mappedBy="project")
    private List<Tasks> tasks;
    


    public Projects() {
    }

    public Projects(Integer id) {
        this.id = id;
    }


//cherry
    public Projects(String projectName) {
        this.projectName = projectName;
    }

    public Projects(Integer id, String projectName) {
        this.id = id;
        this.projectName = projectName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getPmId() {
        return pmId;
    }

    public void setPmId(Integer pmId) {
        this.pmId = pmId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
    
    public int getNumberOfColumns() {
    return 8;
    }
    
    public String getColumnName(int i) throws Exception {
        System.out.println("hi getColumnName");
    String colName = null;
    if (i == 0)
    colName = "projID";
    else if (i == 1)
    colName = "name";
    else if (i == 2)
   colName = "manager ID";
    else if (i == 3)
    colName = "description";
    else if (i == 4)
    colName = "status" ; 
    else if (i == 5)
    colName = "categoty";
    else if (i == 6)
    colName = "created_at" ; 
    else if (i == 7)
    colName = "updated_at";
    
    else    
    throw new Exception("Access to invalid column number in courselist table");
    return colName;
    }
    
    public String getColumnData(int i) throws Exception
    {
    if (i == 0)
    return getId().toString();
    else if (i == 1)
    return getProjectName();
    else if (i == 2)
    return getPmId().toString();
    else if (i == 3)
    return getDescription();
    else if (i == 4)
    return getStatus();
    else if (i == 5)
    return getCategory();
    else if (i == 6)
     return  getCreatedAt()+"";
    else if (i == 7)
    return getUpdatedAt()+"";
    else
    throw new Exception("Error: invalid column index in courselist table");
    }


    @XmlTransient
    public Collection<ProjectsUsers> getProjectsUsersCollection() {
        return projectsUsersCollection;
    }

    public void setProjectsUsersCollection(Collection<ProjectsUsers> projectsUsersCollection) {
        this.projectsUsersCollection = projectsUsersCollection;
    }



//cherry

   public List<Tasks> getTasks() {
        return tasks;
   }

   
   public void setTasks(List<Tasks> tasks) {
       this.tasks = tasks;
   }
   //===

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projects)) {
            return false;
        }
        Projects other = (Projects) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Projects[ id=" + id + " ]";
    }

    public void setColumnData(int col, Object aValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
