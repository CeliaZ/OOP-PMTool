/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Projects;
import entity.Tasks;
import entity.Users;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.io.FileWriter;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import services.ApplicationController;

/**
 *
 * @author Cherry
 */
public class TimelinePanel extends javax.swing.JPanel {

    private JFXPanel fxPanel;

    private static String TEMPLATE = "<!DOCTYPE html> <html lang=\"en\"> <head>"
            + " <title></title> <meta charset=\"utf-8\">"
            + " <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">"
            + " <meta name=\"apple-touch-fullscreen\" content=\"yes\">"
            + " <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\">"
            + "<style> html, body { height:100%; padding: 0px; margin: 0px; } </style> "
            + "</head>"
            + " <body> <div id=\"timeline-embed\"></div>"
            + " <script type=\"text/javascript\"> "
            + "var data = %%%; "
            + "var timeline_config = { "
            + "width: \"100%\", "
            + "height: \"90%\", "
            + "source: data, "
            + "start_zoom_adjust: \"-1\", "
            + "lang: \"en\", "
            + "font: \"Verdana\" } </script>"
            + " <script type=\"text/javascript\" src=\"build/js/storyjs-embed.js\"></script>"
            + "</body> </html>";
    /**
     * Creates new form TimelinePanel
     */
    public TimelinePanel() {
        initComponents();

        fxPanel = new JFXPanel();
        final Dimension size = new Dimension(960, 750);
        fxPanel.setSize(size);
        setLayout(new BorderLayout(0, 0));
        add(fxPanel);

        String filepath = System.getProperty("user.dir") + "/timeline/index.html";
        final String url = "file://" + filepath;
        try {
            FileWriter writer = new FileWriter(filepath);
            writer.write(TEMPLATE.replace("%%%", getJsonConfig()));
            writer.close();
        } catch (Exception e) {
            System.err.println("Error writing html " + e.getMessage());
        }
        
        Platform.runLater(new Runnable() { // this will run initFX as JavaFX-Thread
            @Override
            public void run() {
                Group group = new Group();
                Scene scene = new Scene(group);
                fxPanel.setScene(scene);

                WebView webView = new WebView();

                group.getChildren().add(webView);
                webView.setMinSize(size.getWidth(), size.getHeight());
                webView.setMaxSize(size.getWidth(), size.getHeight());

                WebEngine webEngine = webView.getEngine();
                webEngine.load(url);
            }
        });
    }
    
    private String getJsonConfig() {
        EntityManager em = ApplicationController.getEnitityManager();
        TypedQuery<Tasks> queryTasks = (TypedQuery<Tasks>) em.createNamedQuery("Tasks.findByProjectId");
        Integer proId = ApplicationController.getCurrentProject().getId();
        List<Tasks> tasks = queryTasks.setParameter("projectId", proId).getResultList();
        JSONArray dates = new JSONArray();
        SimpleDateFormat format = new SimpleDateFormat("YYYY,MM,dd");
        for (Tasks t : tasks) {
            if (t.getStartTime() == null || t.getEndTime() == null) {
                continue;
            }
            TypedQuery<Users> queryOwner = (TypedQuery<Users>) em.createNamedQuery("Users.findById");
            Users u = queryOwner.setParameter("id", t.getOwnerId()).getSingleResult();
            if (u == null) {
                continue;
            }
            JSONObject entry = new JSONObject();
            entry.put("startDate", format.format(t.getStartTime()).toString());
            entry.put("endDate", format.format(t.getEndTime()).toString());
            entry.put("headline", t.getTaskName());
            entry.put("text", t.getDescription());
            dates.add(entry);
        }
        JSONObject timeline = new JSONObject();
        timeline.put("headline", "Project Timeline");
        timeline.put("type", "default");
        timeline.put("date", dates);
        JSONObject result = new JSONObject();
        result.put("timeline", timeline);
        return result.toJSONString();
    }

    /* Creates a WebView and fires up google.com */
    private static void initFX(final JFXPanel fxPanel) {
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
