
package UniversityPagesComponents;

import StudentPages.ScholarshipDescriptionNoApplyButton;
import connection.DatabaseConnection;
import java.sql.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public final class CardDescriptionEditscholarship extends javax.swing.JPanel{
    
    private String Email;
    private final Connection con;
    private String Denomination;
    private String uni;
    
    public CardDescriptionEditscholarship(String university, String description, String email) {
        initComponents();
        con = DatabaseConnection.getInstance().getConnection();
        this.Email = email;
        this.uni = university;
        this.Denomination = description;
        setOpaque(false);
        scholarship.setBackground(new Color(0, 0, 0, 0));
        universityName.setText(university);
        scholarship.setText(description);
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
    
    private void EditSch() {
        
        try {
            
            String sql = "SELECT publishdate, description, nr_of_scholarships, targetgroup, scholarshipinclusion, eligibility, degree, deadline, coursestart FROM `scholarships` WHERE denomination LIKE '"+this.Denomination+"' and university LIKE '"+this.uni+"'";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                
                String PublishDate = rs.getString("publishdate");
                String Description = rs.getString("description");
                String Nr_OF_Scholarsips = rs.getString("nr_of_scholarships");
                String TargetGroup = rs.getString("targetgroup");
                String ScholarshipInclusion = rs.getString("scholarshipinclusion");
                String Eligibility = rs.getString("eligibility");
                String Degree = rs.getString("degree");
                String Deadline = rs.getString("deadline");
                String CourseStart = rs.getString("coursestart");
                
                EditSch edit = new EditSch(this.uni, this.Email, this.Denomination, PublishDate, Description, Nr_OF_Scholarsips, TargetGroup, ScholarshipInclusion, Eligibility, Degree, Deadline, CourseStart);
                edit.setVisible(true);
            }
            stm.close();
            rs.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        
    }
    
    private void ShowDescription() {
        String uni = universityName.getText();
        String sch = scholarship.getText();
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/piproject?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            String sql = "SELECT denomination, publishdate, description, fields, nr_of_scholarships, targetgroup, scholarshipinclusion, eligibility, necessarydocuments, university, country, degree, deadline, coursestart FROM `scholarships` WHERE denomination LIKE '"+sch+"' and university LIKE '"+uni+"'";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                
                String Scholarship = rs.getString("denomination");
                String PublishDate = rs.getString("publishdate");
                String Description = rs.getString("description");
                String Fields = rs.getString("fields");
                String Nr_OF_Scholarsips = rs.getString("nr_of_scholarships");
                String TargetGroup = rs.getString("targetgroup");
                String ScholarshipInclusion = rs.getString("scholarshipinclusion");
                String Eligibility = rs.getString("eligibility");
                String NecessaryDocuments = rs.getString("necessarydocuments");
                String University = rs.getString("university");
                String Country = rs.getString("country");
                String Degree = rs.getString("degree");
                String Deadline = rs.getString("deadline");
                String CourseStart = rs.getString("coursestart");
                
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
                
                new ScholarshipDescriptionNoApplyButton(Scholarship, d3, Description, Nr_OF_Scholarsips, TargetGroup, ScholarshipInclusion, Eligibility, NecessaryDocuments, University, Country, Degree, d1, d2, this.Email, Fields).setVisible(true);
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
        bookmarkButton = new swing.Button();

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

        bookmarkButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        bookmarkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookmarkButtonActionPerformed(evt);
            }
        });

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
                        .addComponent(universityName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bookmarkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(universityName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookmarkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(scholarship, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void universityNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_universityNameMouseEntered
        universityName.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_universityNameMouseEntered

    private void universityNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_universityNameMouseClicked
        ShowDescription();
    }//GEN-LAST:event_universityNameMouseClicked

    private void bookmarkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookmarkButtonActionPerformed
        EditSch();
    }//GEN-LAST:event_bookmarkButtonActionPerformed
    
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
    private swing.Button bookmarkButton;
    private swing.TextArea scholarship;
    private javax.swing.JLabel universityName;
    // End of variables declaration//GEN-END:variables
}
