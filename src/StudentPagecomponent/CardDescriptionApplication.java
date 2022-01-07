
package StudentPagecomponent;

import StudentPages.ScholarshipDescriptionNoApplyButton;
import java.sql.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class CardDescriptionApplication extends javax.swing.JPanel{
    
    private String Email;
    
    public CardDescriptionApplication(String university, String description, String email) {
        initComponents();
        this.Email = email;
        setOpaque(false);
        scholarship.setBackground(new Color(0, 0, 0, 0));
        universityName.setText(university);
        scholarship.setText(description);
        Status(university, description, email);
    }
    
    private void Status(String uni, String sch, String email){
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/piproject?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            
            String sql = "SELECT status FROM applications WHERE denomination LIKE '"+sch+"' AND university LIKE '"+uni+"' AND applicantemail LIKE '"+email+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            
            if(rs.next()) {
                
                String statuS = rs.getString("status");
                switch (statuS) {
                    case "Pending":
                        status.setText("Pending");
                        status.setBackground(new Color(255,255,0));
                        break;
                    case "Approved":
                        status.setText("Approved");
                        status.setBackground(new Color(0,204,0));
                        break;
                    case "Declined":
                        status.setText("Declined");
                        status.setBackground(new Color(255,0,0));
                        break;
                    default:
                        status.setText("No Status");
                        status.setBackground(new Color(0,0,0));
                        break;
                }
                
            }
        } catch (Exception ex) {
            Logger.getLogger(CardDescriptionApplication.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        universityName = new javax.swing.JLabel();
        scholarship = new swing.TextArea();
        status = new javax.swing.JLabel();

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

        status.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        status.setForeground(new java.awt.Color(255, 255, 255));
        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status.setText("Pending");
        status.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scholarship, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(universityName, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(universityName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(scholarship, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void universityNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_universityNameMouseEntered
        universityName.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_universityNameMouseEntered

    private void universityNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_universityNameMouseClicked
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
                
                new ScholarshipDescriptionNoApplyButton(Scholarship, d3, Description, Fields, Nr_OF_Scholarsips, TargetGroup, ScholarshipInclusion, Eligibility, NecessaryDocuments, University, Country, Degree, d1, d2, this.Email).setVisible(true);
            }
            
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        
    }//GEN-LAST:event_universityNameMouseClicked
    
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
    private swing.TextArea scholarship;
    private javax.swing.JLabel status;
    private javax.swing.JLabel universityName;
    // End of variables declaration//GEN-END:variables
}
