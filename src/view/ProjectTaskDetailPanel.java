/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Messages;
import entity.Tasks;
import entity.Users;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import services.Application;

/**
 *
 * @author Cherry
 */
public class ProjectTaskDetailPanel extends javax.swing.JPanel {
    
    private Tasks task;

    /**
     * Creates new form java
     */
    public ProjectTaskDetailPanel(Tasks task) {
        this.task = task;
        initComponents();
        textTitle.setText(task.getTaskName());
        // get taskowner name with join query from task's owner id and user in user table
        int ownerId = task.getOwnerId();
        EntityManager em = Application.getEnitityManager();
        TypedQuery<Users> queryUserById = (TypedQuery<Users>) em.createNamedQuery("Users.findById");
        Users taskOwner = queryUserById.setParameter("id", ownerId).getSingleResult();
        String ownerName = taskOwner.getFirstName();
        textOwner.setText(ownerName);
        textDescription.setText(task.getDescription());//check whether will change line
        
        textTitle.setEditable(false);
        textOwner.setEditable(false);
        textDescription.setEditable(false);
        textComments.setEditable(false);
        reloadComments();
        
        buttonComment.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Messages m = new Messages();
                m.setTaskId(task.getId());
                m.setContent(textComment.getText());
                m.setSenderId(1); // TODO change to user id
                m.setCreatedAt(new Date());
                EntityTransaction transaction = Application.getEnitityManager().getTransaction();
                transaction.begin();
                Application.getEnitityManager().persist(m);
                transaction.commit();
                reloadComments();
            }
        });
    }
    
    private void reloadComments() {
        textComments.setContentType("text/html");
        StringBuilder html = new StringBuilder("<html>");
        EntityManager em = Application.getEnitityManager();
        TypedQuery<Messages> query = (TypedQuery<Messages>) em.createNamedQuery("Messages.findByTaskId");
        TypedQuery<Users> queryUser = (TypedQuery<Users>) em.createNamedQuery("Users.findById");
        List<Messages> messages = query.setParameter("taskId",task.getId()).getResultList();
        for (Messages m : messages) {
            Users users = queryUser.setParameter("id", m.getSenderId()).getSingleResult();
            html.append("<span color='gray'>(").append(m.getCreatedAt().toString()).append(") </span>");
            html.append("<span color='green'><b>").append(users.getFirstName()).append("</b></span>");
            html.append(": ").append(m.getContent()).append("<br />");
        }
        html.append("</ul></html>");
        textComments.setText(html.toString());
        textComments.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textTitle = new java.awt.TextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        textComment = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textComments = new javax.swing.JTextPane();
        buttonComment = new javax.swing.JButton();
        textOwner = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        textDescription = new javax.swing.JTextArea();

        jScrollPane1.setViewportView(jTextPane1);

        setPreferredSize(new java.awt.Dimension(900, 426));

        jLabel1.setText("Title:");

        jLabel2.setText("Description:");

        jLabel3.setText("Owner:");

        textComment.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setViewportView(textComment);

        jLabel4.setText("History:");

        textComments.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane3.setViewportView(textComments);

        buttonComment.setText("Comment");

        textDescription.setColumns(20);
        textDescription.setRows(5);
        jScrollPane4.setViewportView(textDescription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonComment, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textOwner)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4)))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(textTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(233, 233, 233)
                        .addComponent(buttonComment)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(178, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(48, 48, 48)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonComment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane textComment;
    private javax.swing.JTextPane textComments;
    private javax.swing.JTextArea textDescription;
    private javax.swing.JTextField textOwner;
    private java.awt.TextField textTitle;
    // End of variables declaration//GEN-END:variables
}
