/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cherry
 */
@Entity
@Table(name = "tasks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tasks.findAll", query = "SELECT t FROM Tasks t"),
    @NamedQuery(name = "Tasks.findById", query = "SELECT t FROM Tasks t WHERE t.id = :id"),
    @NamedQuery(name = "Tasks.findByProjectId", query = "SELECT t FROM Tasks t WHERE t.projectId = :projectId"),
    @NamedQuery(name = "Tasks.findByTaskName", query = "SELECT t FROM Tasks t WHERE t.taskName = :taskName"),
    @NamedQuery(name = "Tasks.findByStartTime", query = "SELECT t FROM Tasks t WHERE t.startTime = :startTime"),
    @NamedQuery(name = "Tasks.findByEndTime", query = "SELECT t FROM Tasks t WHERE t.endTime = :endTime"),
    @NamedQuery(name = "Tasks.findByOwnerId", query = "SELECT t FROM Tasks t WHERE t.ownerId = :ownerId"),
    @NamedQuery(name = "Tasks.findByCreatedAt", query = "SELECT t FROM Tasks t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "Tasks.findByUpdatedAt", query = "SELECT t FROM Tasks t WHERE t.updatedAt = :updatedAt"),
// add query by cherry
    @NamedQuery(name = "Tasks.findByStatus", query = "SELECT t FROM Tasks t WHERE t.status = :status"),
    @NamedQuery(name = "Tasks.findByDependency", query = "SELECT t FROM Tasks t WHERE t.dependency = :dependency")
})
public class Tasks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "project_id")
    private int projectId;
    @Column(name = "task_name")
    private String taskName;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Column(name = "owner_id")
    private Integer ownerId;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    // add by cherry
    @Column(name = "status")
    private String status;
    @Column(name = "dependency")
    private Integer dependency;
    @Column(name = "closed_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closedAt;
            
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name="project_id")
    private Projects project;
    
    public Tasks() {
    }

    public Tasks(Integer id) {
        this.id = id;
    }

    public Tasks(String taskName, String description, Integer owner) {
        this.taskName = taskName;
        this.description = description;
        this.ownerId = owner;
    }
    
    public Tasks(String taskName, String description, Integer owner, Date startTime, Date endTime) {
        this.taskName = taskName;
        this.description = description;
        this.ownerId = owner;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public Tasks(Integer id, int projectId) {
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

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
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

    public void setProject(Projects proj) {
        project = proj;
    }

    public Projects getProject() {
        return project;
    }
    // add by cherry 
    public String getStatus() {
        return status;// only open and closed
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Integer getDependency() {
        return dependency;
    }

    public void setDependency(Integer dependency) {
        this.dependency = dependency;
    }
    
    public Date getClosedAt() {
        return closedAt;
    }
    
    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
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
        if (!(object instanceof Tasks)) {
            return false;
        }
        Tasks other = (Tasks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + id + ": " + taskName;
    }
 
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PMToolPU");
//        EntityManager manager = emf.createEntityManager();
//        EntityTransaction transaction = manager.getTransaction();
//
//        Tasks task1 = new Tasks(1,1);
//        Tasks task2 = new Tasks(2,1);
//        Tasks task3 = new Tasks(3,1);
//
//
//        // create a set of the records
//
//        Set<Tasks> tasks = new HashSet<Tasks>();
//        tasks.add(task1);
//        tasks.add(task2);
//        tasks.add(task3);
//
//        Projects project1 = new Projects();
//        project1.setId(1);
//        project1.setProjectName("Project1");
//        
//        // suppose that student1 and student2  are in department1
//        project1.setRecords(tasks);
//        task1.setProject(project1);
//        task2.setProject(project1);
//        task3.setProject(project1);
//
//        transaction.begin();
//        manager.persist(task1);
//        manager.persist(task2);
//        manager.persist(task3);
//        transaction.commit();
//        emf.close();
//    }
}
