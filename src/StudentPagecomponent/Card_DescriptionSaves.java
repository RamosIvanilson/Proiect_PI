
package StudentPagecomponent;

import StudentPages.ScholarshipDescription;
import java.sql.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;
import java.util.logging.*;
import javax.swing.*;

public class Card_DescriptionSaves extends javax.swing.JPanel{
    
    private String Email;
    public String denumire;

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
    
    public Card_DescriptionSaves(String university, String description, String email) {
        initComponents();
        this.Email = email;
        setOpaque(false);
        scholarship.setBackground(new Color(0, 0, 0, 0));
        universityName.setText(university);
        scholarship.setText(description);
        isAvailable(university, description);
    }
    
    private void isAvailable(String uni, String sch){
        long days = 0;
        
        try {
            
            LocalDate n = LocalDate.now();
            String now = String.valueOf(n);
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/piproject?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            
            String sql = "SELECT `deadline` FROM `scholarships` WHERE denomination LIKE '"+sch+"' AND university LIKE '"+uni+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            
            if(rs.next()) {
                
                String deadline = rs.getString("deadline");
                final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                final LocalDate firstDate = LocalDate.parse(now, formatter);
                final LocalDate secondDate = LocalDate.parse(deadline, formatter);
                days = ChronoUnit.DAYS.between(firstDate, secondDate);
                
            }
        } catch (Exception ex) {
            Logger.getLogger(Card_DescriptionSaves.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
        long a = 60, b = 0;
        if(days > a) {
            availableness.setIcon(new ImageIcon(getClass().getResource("/icon/available.png")));
        } else if(days < b) {
            availableness.setIcon(new ImageIcon(getClass().getResource("/icon/not available.png")));
        } else {
            availableness.setIcon(new ImageIcon(getClass().getResource("/icon/deadline soon.png")));
        }
    }
    
    private String FixDate(String date) {
        String Date = "";
        String day = "";
        String month = "";
        String year = "";
        StringTokenizer token = new StringTokenizer(date, "-");
        
        year += token.nextToken();
        month += token.nextToken();
        day += token.nextToken();
        
        Date += year + "-" + month + "-" + day;
        
        return Date;
    }
    
    private void Scholarshipdescription() {
        String uni = universityName.getText();
        String sch = scholarship.getText();
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/piproject?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            String sql = "SELECT denomination, publishdate, description, fields, nr_of_scholarships, targetgroup, scholarshipinclusion, eligibility, necessarydocuments, university, country, degree, deadline, coursestart FROM `scholarships` WHERE denomination LIKE '"+sch+"' and university LIKE '"+uni+"'";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                
                String Scholarship = rs.getString("denomination").trim();
                String PublishDate = rs.getString("publishdate").trim();
                String Description = rs.getString("description").trim();
                String Fields = rs.getString("fields").trim();
                String Nr_OF_Scholarsips = rs.getString("nr_of_scholarships").trim();
                String TargetGroup = rs.getString("targetgroup").trim();
                String ScholarshipInclusion = rs.getString("scholarshipinclusion").trim();
                String Eligibility = rs.getString("eligibility").trim();
                String NecessaryDocuments = rs.getString("necessarydocuments").trim();
                String University = rs.getString("university").trim();
                String Country = rs.getString("country").trim();
                String Degree = rs.getString("degree").trim();
                String Deadline = rs.getString("deadline").trim();
                String CourseStart = rs.getString("coursestart").trim();
                
                String Dline = FixDate(Deadline);
                String Cstart = FixDate(CourseStart);
                String Pdate = FixDate(PublishDate);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");
                LocalDate date1 = LocalDate.parse(Dline);
                LocalDate date2 = LocalDate.parse(Cstart);
                LocalDate date3 = LocalDate.parse(Pdate);
                String d1 = String.valueOf(dtf.format(date1));
                String d2 = String.valueOf(dtf.format(date2));
                String d3 = String.valueOf(dtf.format(date3));
                
                ScholarshipDescription description = new ScholarshipDescription(Scholarship, d3, Description, Fields, Nr_OF_Scholarsips, TargetGroup, ScholarshipInclusion, Eligibility, NecessaryDocuments, University, Country, Degree, d1, d2, this.Email);
                description.setVisible(true);
            }
            
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        universityName = new javax.swing.JLabel();
        scholarship = new swing.TextArea();
        availableness = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        universityName.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        universityName.setText("TITLE");
        universityName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        universityName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                universityNameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                universityNameMouseEntered(evt);
            }
        });

        scholarship.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        scholarship.setColumns(20);
        scholarship.setRows(5);

        availableness.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/available.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(universityName, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(availableness)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scholarship, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(universityName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(availableness, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(scholarship, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void universityNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_universityNameMouseEntered
        universityName.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_universityNameMouseEntered

    private void universityNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_universityNameMouseClicked
        Scholarshipdescription();
    }//GEN-LAST:event_universityNameMouseClicked

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        this.setDenumire(scholarship.getText());
    }//GEN-LAST:event_formMouseEntered
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255, 255, 255, 200));
        Path2D.Float f = new Path2D.Float();
        f.moveTo(0, 30);
        f.curveTo(50, 0, 100, 40, 850, 0);
        f.lineTo(850, getHeight());
        f.lineTo(0, getHeight());
        
        g2.fill(f);
        super.paintComponent(g);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel availableness;
    private swing.TextArea scholarship;
    private javax.swing.JLabel universityName;
    // End of variables declaration//GEN-END:variables
}
