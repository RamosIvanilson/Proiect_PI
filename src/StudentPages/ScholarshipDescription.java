
package StudentPages;
import Application.ApplicationPage;
import connection.DatabaseConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import scroll.ScrollBarCustom;

public class ScholarshipDescription extends javax.swing.JFrame {
    
    private String Email;
    private final Connection con;
    private String firstname;
    private String lastname;
    private String Denomination;
    private String University;
    
    public ScholarshipDescription(String Scholarship, String PublishDate, String Description, String field, String Nr_OF_Scholarsips, String TargetGroup, String ScholarshipInclusion, String Eligibility, String NecessaryDocuments, String University, String Country, String Degree, String Deadline, String CourseStart, String email) {
        initComponents();
        con = DatabaseConnection.getInstance().getConnection();
        this.Denomination = Scholarship;
        this.University = University;
        this.Email = email;
        getFirstLastName(email);
        getContentPane().setBackground(new Color(255, 255, 255));
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        init(Scholarship, PublishDate, Description, field, Nr_OF_Scholarsips, TargetGroup, ScholarshipInclusion, Eligibility, NecessaryDocuments, University, Country, Degree, Deadline, CourseStart);
    }

    private ScholarshipDescription() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void init(String Scholarship, String PublishDate, String Description, String Fields, String Nr_OF_Scholarsips, String TargetGroup, String ScholarshipInclusion, String Eligibility, String NecessaryDocuments, String University, String Country, String Degree, String Deadline, String CourseStart) {
        scholarship.setText(Scholarship);
        publishDate.setText(PublishDate);
        briefDescription.setText(Description);
        fieldsOfStudy.setText(Fields);
        numOFsch.setText(Nr_OF_Scholarsips);
        targetGroup.setText(TargetGroup);
        schValueORinclusions.setText(ScholarshipInclusion);
        eligibility.setText(Eligibility);
        necessarydocuments.setText(NecessaryDocuments);
        degree.setText(Degree);
        country.setText("Study in " + Country);
        university.setText(University);
        deadline.setText(Deadline);
        coursestart.setText("Course starts at " + CourseStart);
        briefDescription.setLineWrap(true);
        briefDescription.setWrapStyleWord(true);
        briefDescription.setEditable(false);
        necessarydocuments.setLineWrap(true);
        necessarydocuments.setWrapStyleWord(true);
        necessarydocuments.setEditable(false);
        eligibility.setLineWrap(true);
        eligibility.setWrapStyleWord(true);
        eligibility.setEditable(false);
        numOFsch.setLineWrap(true);
        numOFsch.setWrapStyleWord(true);
        numOFsch.setEditable(false);
        schValueORinclusions.setLineWrap(true);
        schValueORinclusions.setWrapStyleWord(true);
        schValueORinclusions.setEditable(false);
        targetGroup.setLineWrap(true);
        targetGroup.setWrapStyleWord(true);
        targetGroup.setEditable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        scholarship = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        university = new javax.swing.JLabel();
        degree = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        deadline = new javax.swing.JLabel();
        country = new javax.swing.JLabel();
        coursestart = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        briefDescription = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        numOFsch = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        targetGroup = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        schValueORinclusions = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        eligibility = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        necessarydocuments = new javax.swing.JTextArea();
        publishDate = new javax.swing.JLabel();
        applyButton = new swing.Button();
        fieldsOfStudy = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        scholarship.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        scholarship.setForeground(new java.awt.Color(44, 126, 197));
        scholarship.setText("Scholarship");

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Published at");

        university.setFont(new java.awt.Font("SansSerif", 2, 16)); // NOI18N
        university.setForeground(new java.awt.Color(51, 51, 51));

        degree.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        degree.setForeground(new java.awt.Color(51, 51, 51));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Deadline:");

        deadline.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        deadline.setForeground(new java.awt.Color(51, 51, 51));

        country.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        country.setForeground(new java.awt.Color(51, 51, 51));

        coursestart.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        coursestart.setForeground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(44, 126, 197));
        jLabel4.setText("Brief Description");

        briefDescription.setBackground(new java.awt.Color(255, 255, 255));
        briefDescription.setColumns(20);
        briefDescription.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        briefDescription.setForeground(new java.awt.Color(51, 51, 51));
        briefDescription.setRows(5);
        briefDescription.setBorder(null);
        briefDescription.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(44, 126, 197));
        jLabel10.setText("Level/Field(s) of study:");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(44, 126, 197));
        jLabel13.setText("Number of Scholarships");

        numOFsch.setBackground(new java.awt.Color(255, 255, 255));
        numOFsch.setColumns(20);
        numOFsch.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        numOFsch.setForeground(new java.awt.Color(51, 51, 51));
        numOFsch.setRows(5);
        numOFsch.setBorder(null);
        numOFsch.setOpaque(false);

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(44, 126, 197));
        jLabel15.setText("Target Group:");

        targetGroup.setBackground(new java.awt.Color(255, 255, 255));
        targetGroup.setColumns(20);
        targetGroup.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        targetGroup.setForeground(new java.awt.Color(51, 51, 51));
        targetGroup.setRows(5);
        targetGroup.setBorder(null);
        targetGroup.setOpaque(false);

        jLabel14.setBackground(new java.awt.Color(51, 51, 51));
        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(44, 126, 197));
        jLabel14.setText("Scholarship value/inclusions:");

        schValueORinclusions.setBackground(new java.awt.Color(255, 255, 255));
        schValueORinclusions.setColumns(20);
        schValueORinclusions.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        schValueORinclusions.setForeground(new java.awt.Color(51, 51, 51));
        schValueORinclusions.setRows(5);
        schValueORinclusions.setBorder(null);
        schValueORinclusions.setOpaque(false);

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(44, 126, 197));
        jLabel16.setText("Eligibility:");

        eligibility.setBackground(new java.awt.Color(255, 255, 255));
        eligibility.setColumns(20);
        eligibility.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        eligibility.setForeground(new java.awt.Color(51, 51, 51));
        eligibility.setRows(5);
        eligibility.setBorder(null);
        eligibility.setOpaque(false);

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(44, 126, 197));
        jLabel17.setText("Necessary Documents:");

        necessarydocuments.setBackground(new java.awt.Color(255, 255, 255));
        necessarydocuments.setColumns(20);
        necessarydocuments.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        necessarydocuments.setForeground(new java.awt.Color(51, 51, 51));
        necessarydocuments.setRows(5);
        necessarydocuments.setBorder(null);
        necessarydocuments.setOpaque(false);

        publishDate.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        publishDate.setForeground(new java.awt.Color(51, 51, 51));

        applyButton.setBackground(new java.awt.Color(0, 102, 255));
        applyButton.setBorder(null);
        applyButton.setForeground(new java.awt.Color(255, 255, 255));
        applyButton.setText("APPLY");
        applyButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        applyButton.setOpaque(true);
        applyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                applyButtonMouseClicked(evt);
            }
        });
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        fieldsOfStudy.setEditable(false);
        fieldsOfStudy.setBackground(new java.awt.Color(255, 255, 255));
        fieldsOfStudy.setColumns(20);
        fieldsOfStudy.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        fieldsOfStudy.setForeground(new java.awt.Color(51, 51, 51));
        fieldsOfStudy.setRows(5);
        fieldsOfStudy.setBorder(null);
        fieldsOfStudy.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(publishDate, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(degree, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(university, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(335, 335, 335)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(coursestart, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deadline, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(scholarship, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(briefDescription))
                    .addComponent(jLabel17)
                    .addComponent(jLabel10)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numOFsch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
                                    .addComponent(eligibility, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(fieldsOfStudy, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(targetGroup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(schValueORinclusions, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(necessarydocuments)))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(scholarship, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(publishDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(university, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(degree, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deadline, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(coursestart, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(briefDescription)
                .addGap(29, 29, 29)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldsOfStudy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numOFsch, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(targetGroup)
                .addGap(40, 40, 40)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(schValueORinclusions)
                .addGap(42, 42, 42)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eligibility)
                .addGap(46, 46, 46)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(necessarydocuments)
                .addGap(48, 48, 48)
                .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        scroll.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void applyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applyButtonMouseClicked
        
        
        
    }//GEN-LAST:event_applyButtonMouseClicked

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed

        ApplicationPage apply = new ApplicationPage(this.Denomination, this.University, this.firstname, this.lastname, this.Email);
        apply.setVisible(true);
    }//GEN-LAST:event_applyButtonActionPerformed
    
    private void getFirstLastName(String email) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT firstname, lastname FROM `students` WHERE email=? and status='verified' limit 1");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                this.firstname = rs.getString("firstname");
                this.lastname = rs.getString("lastname");
            }
            rs.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScholarshipDescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScholarshipDescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScholarshipDescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScholarshipDescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScholarshipDescription().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button applyButton;
    private javax.swing.JTextArea briefDescription;
    private javax.swing.JLabel country;
    private javax.swing.JLabel coursestart;
    private javax.swing.JLabel deadline;
    private javax.swing.JLabel degree;
    private javax.swing.JTextArea eligibility;
    private javax.swing.JTextArea fieldsOfStudy;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextArea necessarydocuments;
    private javax.swing.JTextArea numOFsch;
    private javax.swing.JLabel publishDate;
    private javax.swing.JTextArea schValueORinclusions;
    private javax.swing.JLabel scholarship;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextArea targetGroup;
    private javax.swing.JLabel university;
    // End of variables declaration//GEN-END:variables
}
