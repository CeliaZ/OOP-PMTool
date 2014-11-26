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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cherry
 */
@Entity
@Table(name = "projects_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectsUsers.findAll", query = "SELECT p FROM ProjectsUsers p"),
    @NamedQuery(name = "ProjectsUsers.findById", query = "SELECT p FROM ProjectsUsers p WHERE p.id = :id"),
    @NamedQuery(name = "ProjectsUsers.findByProjectId", query = "SELECT p FROM ProjectsUsers p WHERE p.projectId = :projectId"),
    @NamedQuery(name = "ProjectsUsers.findByUserId", query = "SELECT p FROM ProjectsUsers p WHERE p.userId = :userId"),
    @NamedQuery(name = "ProjectsUsers.findByRole", query = "SELECT p FROM ProjectsUsers p WHERE p.role = :role"),
    @NamedQuery(name = "ProjectsUsers.findByCreatedAt", query = "SELECT p FROM ProjectsUsers p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "ProjectsUsers.findByUpdatedAt", query = "SELECT p FROM ProjectsUsers p WHERE p.updatedAt = :updatedAt")})
public class ProjectsUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "project_id")
    private int projectId;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "role")
    private String role;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public ProjectsUsers() {
    }

    public ProjectsUsers(Integer id) {
        this.id = id;
    }

    public ProjectsUsers(Integer id, int projectId, int userId) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectsUsers)) {
            return false;
        }
        ProjectsUsers other = (ProjectsUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProjectsUsers[ id=" + id + " ]";
    }
    
}
