
package StudentPagecomponent;

import StudentPages.ScholarshipDescription;
import StudentModels.ModelScholarshipDescription;

public class SCHdescription extends javax.swing.JPanel {

    /**
     * Creates new form SCHdescription
     */
    public SCHdescription(String Scholarship, String PublishDate, String Description, String Host, String Nr_OF_Scholarsips, String TargetGroup, String ScholarshipInclusion, String Eligibility, String ApplicationInstuctions, String University, String Country, String Degree, String Deadline, String CourseStart, String WebsiteLink) {
        
        initComponents();
        scholarship.setText(Scholarship);
        publishDate.setText(PublishDate);
        briefDescription.setText(Description);
        host.setText(Host);
        numOFsch.setText(Nr_OF_Scholarsips);
        targetGroup.setText(TargetGroup);
        schValueORinclusions.setText(ScholarshipInclusion);
        eligibility.setText(Eligibility);
        applicationInstructions.setText(ApplicationInstuctions);
        university.setText(University);
        country.setText(Country);
        degree.setText(Degree);
        deadline.setText(Deadline);
        coursestart.setText(CourseStart);
        SCHwebsite.setText(WebsiteLink);
        briefDescription.setLineWrap(true);
        briefDescription.setWrapStyleWord(true);
        briefDescription.setEditable(false);
        SCHwebsite.setLineWrap(true);
        SCHwebsite.setWrapStyleWord(true);
        SCHwebsite.setEditable(false);
        applicationInstructions.setLineWrap(true);
        applicationInstructions.setWrapStyleWord(true);
        applicationInstructions.setEditable(false);
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
        briefDescription.setText("The University of Amsterdam aims to attract the world’s brightest students to its international classrooms. Outstanding students from outside the European Economic Area can apply for an Amsterdam Merit Scholarship"
                + "The University of Amsterdam aims to attract the world’s brightest students to its international classrooms. Outstanding students from outside the European Economic Area can apply for an Amsterdam Merit Scholarship"
                + "The University of Amsterdam aims to attract the world’s brightest students to its international classrooms. Outstanding students from outside the European Economic Area can apply for an Amsterdam Merit Scholarship"
                + "The University of Amsterdam aims to attract the world’s brightest students to its international classrooms. Outstanding students from outside the European Economic Area can apply for an Amsterdam Merit Scholarship"
                + "The University of Amsterdam aims to attract the world’s brightest students to its international classrooms. Outstanding students from outside the European Economic Area can apply for an Amsterdam Merit Scholarship");
        
//        ScholarshipDescription description = new ScholarshipDescription();
//        ModelScholarshipDescription desc = new ModelScholarshipDescription();
//        desc.setScholarship(Scholarship);
//        desc.setPublishDate(PublishDate);
//        desc.setDescription(Description);
//        desc.setHost(Host);
//        desc.setNr_OF_Scholarsips(Nr_OF_Scholarsips);
//        desc.setTargetGroup(TargetGroup);
//        desc.setScholarshipInclusion(ScholarshipInclusion);
//        desc.setEligibility(Eligibility);
//        desc.setApplicationInstuctions(ApplicationInstuctions);
//        desc.setUniversity(University);
//        desc.setCountry(Country);
//        desc.setDegree(Degree);
//        desc.setDeadline(Deadline);
//        desc.setCourseStart(CourseStart);
//        desc.setWebsiteLink(WebsiteLink);
//        description.setVisible(true);
//        System.out.println(university);
//        System.out.println(sch);
//        System.out.println(PublishDate);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scholarship = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        university = new javax.swing.JLabel();
        degree = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        country = new javax.swing.JLabel();
        coursestart = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        briefDescription = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        host = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jList1 = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        numOFsch = new javax.swing.JTextArea();
        targetGroup = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        schValueORinclusions = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        eligibility = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        applicationInstructions = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        SCHwebsite = new javax.swing.JTextArea();
        deadline = new javax.swing.JLabel();
        publishDate = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(44, 126, 197));
        jLabel5.setText("Host Institution:");

        host.setBackground(new java.awt.Color(51, 51, 51));
        host.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        host.setForeground(new java.awt.Color(51, 51, 51));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(44, 126, 197));
        jLabel10.setText("Level/Field(s) of study:");

        jList1.setBackground(new java.awt.Color(255, 255, 255));
        jList1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jList1.setForeground(new java.awt.Color(51, 51, 51));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "•  Child Development and Education huhhhhhhhhhhhhhhhhhhhhhhhhhhh", " ", "•  Communication (Up to 10 scholarships)", "       ", "•  Economics and Business", " ", "•  Humanities", " ", "•  Law", " ", "•  Medicine", " ", "•  Psychology", " ", "•  Science", " ", "•  Social Sciences" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Eligible Masters Degree programme offered by the following Faculties:");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(44, 126, 197));
        jLabel13.setText("Number of Scholarships");

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(44, 126, 197));
        jLabel15.setText("Target Group:");

        numOFsch.setBackground(new java.awt.Color(255, 255, 255));
        numOFsch.setColumns(20);
        numOFsch.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        numOFsch.setForeground(new java.awt.Color(51, 51, 51));
        numOFsch.setRows(5);
        numOFsch.setBorder(null);
        numOFsch.setOpaque(false);

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
        jLabel17.setText("Application instructions:");

        applicationInstructions.setBackground(new java.awt.Color(255, 255, 255));
        applicationInstructions.setColumns(20);
        applicationInstructions.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        applicationInstructions.setForeground(new java.awt.Color(51, 51, 51));
        applicationInstructions.setRows(5);
        applicationInstructions.setBorder(null);
        applicationInstructions.setOpaque(false);

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(44, 126, 197));
        jLabel18.setText("Website");

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Official Scholarship Website:");

        SCHwebsite.setBackground(new java.awt.Color(255, 255, 255));
        SCHwebsite.setColumns(20);
        SCHwebsite.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        SCHwebsite.setForeground(new java.awt.Color(44, 126, 197));
        SCHwebsite.setRows(5);
        SCHwebsite.setBorder(null);
        SCHwebsite.setOpaque(false);

        deadline.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        deadline.setForeground(new java.awt.Color(51, 51, 51));
        deadline.setText("01 Nov 2022");

        publishDate.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        publishDate.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel13)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(numOFsch, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(targetGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel17))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel12)
                                            .addComponent(briefDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                                            .addComponent(host, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(SCHwebsite, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(applicationInstructions, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(schValueORinclusions, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel14)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(eligibility, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel16)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jList1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scholarship, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(publishDate, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(degree, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(university, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(coursestart, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(deadline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scholarship, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(publishDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(university, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deadline, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(degree, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(coursestart, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(briefDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(host, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jList1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numOFsch, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(targetGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(schValueORinclusions, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eligibility, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(applicationInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SCHwebsite, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addGap(39, 39, 39))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea SCHwebsite;
    private javax.swing.JTextArea applicationInstructions;
    private javax.swing.JTextArea briefDescription;
    private javax.swing.JLabel country;
    private javax.swing.JLabel coursestart;
    private javax.swing.JLabel deadline;
    private javax.swing.JLabel degree;
    private javax.swing.JTextArea eligibility;
    private javax.swing.JLabel host;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JTextArea numOFsch;
    private javax.swing.JLabel publishDate;
    private javax.swing.JTextArea schValueORinclusions;
    private javax.swing.JLabel scholarship;
    private javax.swing.JTextArea targetGroup;
    private javax.swing.JLabel university;
    // End of variables declaration//GEN-END:variables
}
