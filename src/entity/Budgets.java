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
import javax.persistence.Lob;
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
@Table(name = "budgets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Budgets.findAll", query = "SELECT b FROM Budgets b"),
    @NamedQuery(name = "Budgets.findById", query = "SELECT b FROM Budgets b WHERE b.id = :id"),
    @NamedQuery(name = "Budgets.findByProjectId", query = "SELECT b FROM Budgets b WHERE b.projectId = :projectId"),
    @NamedQuery(name = "Budgets.findByProjected", query = "SELECT b FROM Budgets b WHERE b.projected = :projected"),
    @NamedQuery(name = "Budgets.findByActual", query = "SELECT b FROM Budgets b WHERE b.actual = :actual"),
    @NamedQuery(name = "Budgets.findByCreatedAt", query = "SELECT b FROM Budgets b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "Budgets.findByUpdatedAt", query = "SELECT b FROM Budgets b WHERE b.updatedAt = :updatedAt")})
public class Budgets implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "project_id")
    private int projectId;
    @Column(name = "projected")
    private Integer projected;
    @Column(name = "actual")
    private Integer actual;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Lob
    @Column(name = "description")
    private String description;

    public Budgets() {
    }

    public Budgets(Integer id) {
        this.id = id;
    }

    public Budgets(Integer id, int projectId) {
        this.id = id;
        this.projectId = projectId;
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

    public Integer getProjected() {
        return projected;
    }

    public void setProjected(Integer projected) {
        this.projected = projected;
    }

    public Integer getActual() {
        return actual;
    }

    public void setActual(Integer actual) {
        this.actual = actual;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Budgets)) {
            return false;
        }
        Budgets other = (Budgets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Budgets[ id=" + id + " ]";
    }
    
}
