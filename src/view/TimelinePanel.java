/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import de.jaret.util.date.IntervalImpl;
import de.jaret.util.date.JaretDate;
import de.jaret.util.ui.timebars.model.DefaultRowHeader;
import de.jaret.util.ui.timebars.model.DefaultTimeBarModel;
import de.jaret.util.ui.timebars.model.DefaultTimeBarRowModel;
import de.jaret.util.ui.timebars.model.TimeBarModel;
import de.jaret.util.ui.timebars.swing.TimeBarViewer;
import entity.Projects;
import entity.Tasks;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import services.ApplicationController;

/**
 *
 * @author Cherry
 */
public class TimelinePanel extends javax.swing.JPanel {

    /**
     * Creates new form TimelinePanel
     */
    public TimelinePanel() {
        initComponents();

        TimeBarModel model = createModel(10, 120, 50);
        TimeBarViewer tbv = new TimeBarViewer(model);
        setLayout(new BorderLayout());
        add(tbv, BorderLayout.CENTER);
    }

    public TimeBarModel createModel(int rows, int averageLengthInMinutes, int countPerRow) {
        int numDays = 30;
        DefaultTimeBarModel model = new DefaultTimeBarModel();
        EntityManager em = ApplicationController.getEnitityManager();
        TypedQuery<Projects> queryProById = (TypedQuery<Projects>) em.createNamedQuery("Projects.findById");
        Integer proId = 24;
        Projects pro = queryProById.setParameter("id", proId).getSingleResult();
        List<Tasks> tasks = pro.getTasks();

        for (int row = 0; row < tasks.size(); row++) {
            Tasks task = tasks.get(row);
            if (task.getStartTime() == null || task.getEndTime() == null) {
                continue;
            }
            DefaultRowHeader header = new DefaultRowHeader("r" + row);
            List _headerList = new ArrayList();
            _headerList.add(header);
            DefaultTimeBarRowModel tbr = new DefaultTimeBarRowModel(header);
            JaretDate date = new JaretDate();

            IntervalImpl interval = new IntervalImpl();
            interval.setBegin(new JaretDate(task.getStartTime()));
            interval.setEnd(new JaretDate(task.getEndTime()));
            tbr.addInterval(interval);
            
//            for (int i = 0; i < countPerRow; i++) {
//                IntervalImpl interval = new IntervalImpl();
//                int length = averageLengthInMinutes / 2 + (int) (Math.random() * (double) averageLengthInMinutes);
//                interval.setBegin(date.copy());
//                date.advanceMinutes(length);
//                interval.setEnd(date.copy());
//
//                tbr.addInterval(interval);
//
//                int pause = (int) (Math.random() * (double) averageLengthInMinutes / 5);
//                date.advanceMinutes(pause);
//            }
            model.addRow(tbr);
        }

        System.out.println("Created " + (rows * countPerRow) + " Intervals");

        return model;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 769, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}