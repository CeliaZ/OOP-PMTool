/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tanmaykuruvilla
 */
@Entity
@Table(name = "projects_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectsUsers.findAll", query = "SELECT p FROM ProjectsUsers p"),
    @NamedQuery(name = "ProjectsUsers.findById", query = "SELECT p FROM ProjectsUsers p WHERE p.id = :id"),
    @NamedQuery(name = "ProjectsUsers.findByProjectId", query = "SELECT p FROM ProjectsUsers p WHERE p.projectsUsersPK.projectId = :projectId"),
    @NamedQuery(name = "ProjectsUsers.findByUserId", query = "SELECT p FROM ProjectsUsers p WHERE p.projectsUsersPK.userId = :userId"),
    @NamedQuery(name = "ProjectsUsers.findByRole", query = "SELECT p FROM ProjectsUsers p WHERE p.role = :role"),
    @NamedQuery(name = "ProjectsUsers.findByCreatedAt", query = "SELECT p FROM ProjectsUsers p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "ProjectsUsers.findByUpdatedAt", query = "SELECT p FROM ProjectsUsers p WHERE p.updatedAt = :updatedAt")})
public class ProjectsUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjectsUsersPK projectsUsersPK;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Column(name = "role")
    private String role;
    @Column(name = "created_at" , insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "project_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Projects projects;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public ProjectsUsers() {
    }

    public ProjectsUsers(ProjectsUsersPK projectsUsersPK) {
        this.projectsUsersPK = projectsUsersPK;
    }

    public ProjectsUsers(ProjectsUsersPK projectsUsersPK, int id) {
        this.projectsUsersPK = projectsUsersPK;
        this.id = id;
    }

    public ProjectsUsers(int projectId, int userId) {
        this.projectsUsersPK = new ProjectsUsersPK(projectId, userId);
    }

    public ProjectsUsersPK getProjectsUsersPK() {
        return projectsUsersPK;
    }

    public void setProjectsUsersPK(ProjectsUsersPK projectsUsersPK) {
        this.projectsUsersPK = projectsUsersPK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public Projects getProjects() {
        return projects;
    }

    public void setProjects(Projects projects) {
        this.projects = projects;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectsUsersPK != null ? projectsUsersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectsUsers)) {
            return false;
        }
        ProjectsUsers other = (ProjectsUsers) object;
        if ((this.projectsUsersPK == null && other.projectsUsersPK != null) || (this.projectsUsersPK != null && !this.projectsUsersPK.equals(other.projectsUsersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProjectsUsers[ projectsUsersPK=" + projectsUsersPK + " ]";
    }
     public String getColumnData(int i) throws Exception {
		if (i == 0)
			return ""+getId();
		else if (i == 1)
			return projectsUsersPK.getProjectId()+"";
		else if (i == 2) 
			return projectsUsersPK.getUserId()+"";
		else if (i == 3)
			return getRole();
		else if (i == 4)
			return getCreatedAt()+"";
                else if (i==5)
                        return getUpdatedAt()+"";
                   
			throw new Exception("Error: invalid column index in courselist table");    
	}

	// return the name of column i
	public String getColumnName(int i) throws Exception {
		String colName = null;
		if (i == 0) 
			colName = "id";
		else if (i == 1)
			colName = "project_id";
		else if (i == 2)
			colName = "user_id";
		else if (i == 3)
			colName = "role";
		else if (i == 4)
			colName = "created at";
                else if (i==5)
                        colName = "updated at";
		else 
			throw new Exception("Access to invalid column number in courselist table");

		return colName;
	}
        // set data column i to value
	public void setColumnData(int i, Object value) throws Exception {
		if (i == 0) 
			id =  (int)value;
		else if (i == 1) 
			projectsUsersPK.setProjectId((int) value);
		else if (i == 2) 
			projectsUsersPK.setUserId((int) value);
		else if (i == 3)
			role = (String) value;
		else if (i == 4)
			createdAt =  (Date) value;
                else if (i==5)
                        updatedAt = (Date) value;
		else
                    throw new Exception("Error: invalid column index in courselist table");    
    	}
        
        
        public int getNumberOfColumns() {
            return 6;
        }
    
}
