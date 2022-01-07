
package UniversityPages;

import Application.ApplicationPanel;
import Application.CellAction;
import Application.ModelTableData;
import StudentPages.ScholarshipDescriptionNoApplyButton;
import StudentPages.StudentProfile;
import UniversityPagesComponents.PreviewSchGrid;
import connection.DatabaseConnection;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import scroll.ScrollBarCustom;

public class UniversityAddScholarship extends javax.swing.JPanel {
    
    private String uni;
    private String cou;
    private String email;
    private String imagePath;
    private final Connection con;
    
    public UniversityAddScholarship(String Email) {
        initComponents();
        con = DatabaseConnection.getInstance().getConnection();
        this.email = Email;
        SetUniCou(Email);
        FixTables();
        ImageError.setVisible(false);
        alreadyadded1.setVisible(false);
        alreadyadded.setVisible(false);
    }
    
    private void SetUniCou(String email) {
        try {
            
            PreparedStatement ps = con.prepareStatement("SELECT university, country FROM `universities` WHERE email=? limit 1");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                this.uni = rs.getString("university");
                this.cou = rs.getString("country");
            }
            ps.close();
            rs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void FixTables() {
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scrollDescription.setVerticalScrollBar(new ScrollBarCustom());
        scrollDescription.getVerticalScrollBar().setUnitIncrement(16);
        scrollEligibility.setVerticalScrollBar(new ScrollBarCustom());
        scrollEligibility.getVerticalScrollBar().setUnitIncrement(16);
        scrollInclusion.setVerticalScrollBar(new ScrollBarCustom());
        scrollInclusion.getVerticalScrollBar().setUnitIncrement(16);
        scrollTableDocuments.setVerticalScrollBar(new ScrollBarCustom());
        scrollTableDocuments.getVerticalScrollBar().setUnitIncrement(16);
        scrolltarget.setVerticalScrollBar(new ScrollBarCustom());
        scrolltarget.getVerticalScrollBar().setUnitIncrement(16);
        scrollTableField.setVerticalScrollBar(new ScrollBarCustom());
        scrollTableField.getVerticalScrollBar().setUnitIncrement(16);
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
    
    private void Preview() {
        String Dline = FixDate(deadlineField.getText());
        String Cstart = FixDate(courseStartField.getText());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        LocalDate localDate = LocalDate.now();
        LocalDate date1 = LocalDate.parse(Dline);
        LocalDate date2 = LocalDate.parse(Cstart);
        
        String Denomination = schDenomination.getText().trim();
        String publishdate = String.valueOf(dtf.format(localDate));
        String Degree = degree.getText().trim();
        String Deadline = String.valueOf(dtf.format(date1));
        String CourseStart = String.valueOf(dtf.format(date2));
        String Description = briefDesciption.getText().trim();
        String Fields = "";
        for(int i = 0; i < fieldOFstudy.getRowCount(); i++) {
            String field = (fieldOFstudy.getValueAt(i, 0).toString());
            Fields += "• " + field + "\n";
        }
        String NrSch = NrOfSchFiled.getText().trim();
        String TargetGropu = targetGroup.getText().trim();
        String SchInclusion = scholarshipInclusion.getText().trim();
        String Eligibility = eligibility.getText().trim();
        String Documents = "";
        for(int i = 0; i < documentsTable.getRowCount(); i++) {
            String doc = (documentsTable.getValueAt(i, 0).toString());
            Documents += "• " + doc + "\n";
        }
        new ScholarshipDescriptionNoApplyButton(Denomination, publishdate, Description, NrSch, TargetGropu, SchInclusion, Eligibility, Documents, this.uni, this.cou, Degree, Deadline, CourseStart, this.email, Fields).setVisible(true);
    }
    
    private void UploadFields() {
        for(int i = 0; i < fieldOFstudy.getRowCount(); i++) {
            String Denomination = schDenomination.getText();
            String field = (fieldOFstudy.getValueAt(i, 0).toString());
            try {
                
                PreparedStatement ps = con.prepareStatement("INSERT INTO fields(denomination, university, field) VALUES(?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

                ps.setString(1, Denomination);
                ps.setString(2, this.uni);
                ps.setString(3, field);
                ps.execute();
                
                ps.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }
    
    private void PublishSch() {
        DateTimeFormatter dtft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        
        String Denomination = schDenomination.getText().trim();
        String publishdate = String.valueOf(dtf.format(localDate));
        String Degree = degree.getText().trim();
        String Deadline = deadlineField.getText();
        String CourseStart = courseStartField.getText();
        String Description = briefDesciption.getText().trim();
        String Fields = "";
        for(int i = 0; i < fieldOFstudy.getRowCount(); i++) {
            String field = (fieldOFstudy.getValueAt(i, 0).toString());
            Fields += "• " + field + "\n";
        }
        String NrSch = NrOfSchFiled.getText().trim();
        String TargetGropu = targetGroup.getText().trim();
        String SchInclusion = scholarshipInclusion.getText().trim();
        String Eligibility = eligibility.getText().trim();
        String Documents = "";
        for(int i = 0; i < documentsTable.getRowCount(); i++) {
            String doc = (documentsTable.getValueAt(i, 0).toString());
            Documents += "• " + doc + "\n";
        }
        int rowFields = fieldOFstudy.getRowCount();
        String published = String.valueOf(dtft.format(now));
        if(!Denomination.equals("")) {
            if(!Degree.equals("")) {
                if(!Deadline.equals("")) {
                    if(!CourseStart.equals("")) {
                        if(!Description.equals("")) {
                            if(!Fields.equals("")) {
                                if(!NrSch.equals("")) {
                                    if(!TargetGropu.equals("")) {
                                        if(!SchInclusion.equals("")) {
                                            if(!Eligibility.equals("")) {
                                                if(!Documents.equals("")) {
                                                    try {

                                                        PreparedStatement ps = con.prepareStatement("INSERT INTO scholarships(image, denomination, publishdate, description, fields, nr_of_scholarships, targetgroup, scholarshipinclusion, eligibility, necessarydocuments, nr_of_documents, university, country, degree, deadline, coursestart, published) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                                                        ps.setBinaryStream(1, new FileInputStream(this.imagePath));
                                                        ps.setString(2, Denomination);
                                                        ps.setString(3, publishdate);
                                                        ps.setString(4, Description);
                                                        ps.setString(5, Fields);
                                                        ps.setString(6, NrSch);
                                                        ps.setString(7, TargetGropu);
                                                        ps.setString(8, SchInclusion);
                                                        ps.setString(9, Eligibility);
                                                        ps.setString(10, Documents);
                                                        ps.setInt(11, documentsTable.getRowCount());
                                                        ps.setString(12, this.uni);
                                                        ps.setString(13, this.cou);
                                                        ps.setString(14, Degree);
                                                        ps.setString(15, Deadline);
                                                        ps.setString(16, CourseStart);
                                                        ps.setString(17, published);
                                                        ps.execute();
                                                        
                                                        if(rowFields >= 1) {
                                                            UploadFields();
                                                        }
                                                        
                                                        JOptionPane.showMessageDialog(null, "Scholarship successfully plublished!");
                                                        ps.close();

                                                    } catch (Exception e) {
                                                        JOptionPane.showMessageDialog(this, e);
                                                    }
                                                } else {
                                                    Border border = new Border();
                                                    border.setColor(Color.RED);
                                                    documntsField.setBorder(border);
                                                }
                                            } else {
                                                Border border = new Border();
                                                border.setColor(Color.RED);
                                                eligibility.setBorder(border);
                                            }
                                        } else {
                                            Border border = new Border();
                                            border.setColor(Color.RED);
                                            scholarshipInclusion.setBorder(border);
                                        }
                                    } else {
                                        Border border = new Border();
                                        border.setColor(Color.RED);
                                        targetGroup.setBorder(border);
                                    }
                                } else {
                                    Border border = new Border();
                                    border.setColor(Color.RED);
                                    NrOfSchFiled.setBorder(border);
                                }
                            } else {
                                Border border = new Border();
                                border.setColor(Color.RED);
                                FieldOfStudyField.setBorder(border);
                            }
                        } else {
                            Border border = new Border();
                            border.setColor(Color.RED);
                            briefDesciption.setBorder(border);
                        }
                    } else {
                        Border border = new Border();
                        border.setColor(Color.RED);
                        courseStartField.setBorder(border);
                    }
                } else {
                    Border border = new Border();
                    border.setColor(Color.RED);
                    deadlineField.setBorder(border);
                }
            } else {
                Border border = new Border();
                border.setColor(Color.RED);
                degree.setBorder(border);
            }
        } else {
            Border border = new Border();
            border.setColor(Color.RED);
            schDenomination.setBorder(border);
        }
    }
    
    private boolean alreadyAddedField(String field) {
        boolean added = false;
        for(int i = 0; i < fieldOFstudy.getRowCount(); i++) {
            String Field = (fieldOFstudy.getValueAt(i, 0).toString());
            if(Field.equals(field)) {
                added = true;
            }
        }
        return added;
    }
    
    private boolean alreadyAddedNecessaryDocs(String doc) {
        boolean added = false;
        for(int i = 0; i < documentsTable.getRowCount(); i++) {
            String Doc = (documentsTable.getValueAt(i, 0).toString());
            if(Doc.equals(doc)) {
                added = true;
            }
        }
        return added;
    }
    
    private void addField() {
        String field = FieldOfStudyField.getText().trim();
        if(alreadyAddedField(field) == false) {
            alreadyadded.setVisible(false);
            if(!field.equals("")) {
                fieldOFstudy.addTableCell(new CellAction(), 1);
                fieldOFstudy.addRow(new ModelTableData(field), true);
            } else {
                Border border = new Border();
                border.setColor(Color.RED);
                FieldOfStudyField.setBorder(border);
            } 
        } else {
            alreadyadded.setVisible(true);
        }
    }
    
    private void addDocs() {
        String docs = documntsField.getText().trim();
        if(alreadyAddedNecessaryDocs(docs) == false) {
            alreadyadded1.setVisible(false);
            if(!docs.equals("")) {
                documentsTable.addRow(new ModelTableData(docs), true);
                documentsTable.addTableCell(new CellAction(), 1);
            } else {
                Border border = new Border();
                border.setColor(Color.RED);
                documntsField.setBorder(border);
            }
        } else {
            alreadyadded1.setVisible(true);
        }
    }
    
    private void addImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\THINKPAD\\Pictures"));
        
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                String n = file.getName().toLowerCase();
                if(file.isDirectory() | n.endsWith(".png") | n.endsWith(".jpg") | n.endsWith(".jpeg")) {
                    return true;
                }
                return false;
            }

            @Override
            public String getDescription() {
                return ".pdf | .jpg | .jpeg";
            }
        });
        
        int X = fileChooser.showSaveDialog(null);
        if(X == JFileChooser.APPROVE_OPTION) {
            
            File file = fileChooser.getSelectedFile();
            String filename = file.getAbsolutePath();
            ImageIcon image = new ImageIcon((filename));
            Imagee.setIcon(image);
            if(Imagee.getIcon().getIconHeight() > 800) {
                ImageError.setVisible(true);
                ImageError.setText("Error! Height " + Imagee.getIcon().getIconHeight() + " > 800");
                Imagee.setIcon(null);
            } else if(Imagee.getIcon().getIconWidth() > 800) {
                ImageError.setVisible(true);
                ImageError.setText("Error! Width " + Imagee.getIcon().getIconWidth() + " > 800");
                Imagee.setIcon(null);
            } else {
                this.imagePath = filename;
            }
        }
    }
    
    private void previewSchGrid() {
        String Denomination = schDenomination.getText().trim();
        new PreviewSchGrid(Denomination, this.uni, this.imagePath).setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deadlineChooser = new com.raven.datechooser.DateChooser();
        coursestartChooser = new com.raven.datechooser.DateChooser();
        pathlist = new javax.swing.JComboBox<>();
        roundPanel1 = new swing.RoundPanel();
        scroll = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        schDenomination = new swing2.MyTextField();
        jLabel6 = new javax.swing.JLabel();
        degree = new swing2.MyTextField();
        jLabel7 = new javax.swing.JLabel();
        deadlineField = new swing2.MyTextField();
        jLabel8 = new javax.swing.JLabel();
        courseStartField = new swing2.MyTextField();
        jLabel9 = new javax.swing.JLabel();
        scrollDescription = new javax.swing.JScrollPane();
        briefDesciption = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        scrollTableField = new javax.swing.JScrollPane();
        fieldOFstudy = new swing.Table();
        FieldOfStudyField = new swing2.MyTextField();
        addFieldOfStudy = new swing2.Button();
        jLabel11 = new javax.swing.JLabel();
        NrOfSchFiled = new swing2.MyTextField();
        jLabel12 = new javax.swing.JLabel();
        scrolltarget = new javax.swing.JScrollPane();
        targetGroup = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        scrollInclusion = new javax.swing.JScrollPane();
        scholarshipInclusion = new javax.swing.JTextArea();
        scrollEligibility = new javax.swing.JScrollPane();
        eligibility = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        documntsField = new swing2.MyTextField();
        addDocuments = new swing2.Button();
        scrollTableDocuments = new javax.swing.JScrollPane();
        documentsTable = new swing.Table();
        publishButton = new swing2.Button();
        previewButton = new swing2.Button();
        alreadyadded = new javax.swing.JLabel();
        alreadyadded1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Imagee = new javax.swing.JLabel();
        uploadImage = new swing2.Button();
        previewShcolarshipGrid = new swing2.Button();
        ImageError = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        deadlineChooser.setForeground(new java.awt.Color(51, 153, 255));
        deadlineChooser.setDateFormat("yyyy-MM-dd");
        deadlineChooser.setTextRefernce(deadlineField);

        coursestartChooser.setForeground(new java.awt.Color(51, 153, 255));
        coursestartChooser.setDateFormat("yyyy-MM-dd");
        coursestartChooser.setTextRefernce(courseStartField);

        pathlist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        scroll.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Scholarship denomination:");

        schDenomination.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        schDenomination.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        schDenomination.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        schDenomination.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                schDenominationKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Degree:");

        degree.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        degree.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        degree.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Deadline:");

        deadlineField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        deadlineField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deadlineField.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Course starts:");

        courseStartField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        courseStartField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        courseStartField.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Brief Desciption:");

        briefDesciption.setColumns(20);
        briefDesciption.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        briefDesciption.setLineWrap(true);
        briefDesciption.setRows(5);
        briefDesciption.setWrapStyleWord(true);
        scrollDescription.setViewportView(briefDesciption);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Fields of Study:");

        fieldOFstudy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        fieldOFstudy.getTableHeader().setReorderingAllowed(false);
        scrollTableField.setViewportView(fieldOFstudy);
        if (fieldOFstudy.getColumnModel().getColumnCount() > 0) {
            fieldOFstudy.getColumnModel().getColumn(0).setResizable(false);
            fieldOFstudy.getColumnModel().getColumn(0).setPreferredWidth(600);
            fieldOFstudy.getColumnModel().getColumn(1).setResizable(false);
        }

        FieldOfStudyField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        FieldOfStudyField.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        FieldOfStudyField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FieldOfStudyFieldKeyPressed(evt);
            }
        });

        addFieldOfStudy.setBackground(new java.awt.Color(0, 153, 255));
        addFieldOfStudy.setBorder(null);
        addFieldOfStudy.setForeground(new java.awt.Color(255, 255, 255));
        addFieldOfStudy.setText("ADD");
        addFieldOfStudy.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        addFieldOfStudy.setOpaque(true);
        addFieldOfStudy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFieldOfStudyActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Number of scholarships:");

        NrOfSchFiled.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        NrOfSchFiled.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NrOfSchFiled.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Target Group:");

        targetGroup.setColumns(20);
        targetGroup.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        targetGroup.setLineWrap(true);
        targetGroup.setRows(5);
        targetGroup.setWrapStyleWord(true);
        scrolltarget.setViewportView(targetGroup);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Scholarship value/inclusions/duration:");

        scholarshipInclusion.setColumns(20);
        scholarshipInclusion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        scholarshipInclusion.setLineWrap(true);
        scholarshipInclusion.setRows(5);
        scholarshipInclusion.setWrapStyleWord(true);
        scrollInclusion.setViewportView(scholarshipInclusion);

        eligibility.setColumns(20);
        eligibility.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        eligibility.setLineWrap(true);
        eligibility.setRows(5);
        eligibility.setWrapStyleWord(true);
        scrollEligibility.setViewportView(eligibility);

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Eligibility Requirements:");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Necessary Documents:");

        documntsField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        documntsField.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        addDocuments.setBackground(new java.awt.Color(0, 153, 255));
        addDocuments.setBorder(null);
        addDocuments.setForeground(new java.awt.Color(255, 255, 255));
        addDocuments.setText("ADD");
        addDocuments.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        addDocuments.setOpaque(true);
        addDocuments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDocumentsActionPerformed(evt);
            }
        });

        documentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTableDocuments.setViewportView(documentsTable);
        if (documentsTable.getColumnModel().getColumnCount() > 0) {
            documentsTable.getColumnModel().getColumn(0).setResizable(false);
            documentsTable.getColumnModel().getColumn(0).setPreferredWidth(600);
            documentsTable.getColumnModel().getColumn(1).setResizable(false);
        }

        publishButton.setBackground(new java.awt.Color(0, 153, 255));
        publishButton.setBorder(null);
        publishButton.setForeground(new java.awt.Color(255, 255, 255));
        publishButton.setText("Publish");
        publishButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        publishButton.setOpaque(true);
        publishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publishButtonActionPerformed(evt);
            }
        });

        previewButton.setBackground(new java.awt.Color(0, 153, 255));
        previewButton.setBorder(null);
        previewButton.setForeground(new java.awt.Color(255, 255, 255));
        previewButton.setText("Preview");
        previewButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        previewButton.setOpaque(true);
        previewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewButtonActionPerformed(evt);
            }
        });

        alreadyadded.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        alreadyadded.setForeground(new java.awt.Color(255, 0, 51));
        alreadyadded.setText("Already added!");

        alreadyadded1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        alreadyadded1.setForeground(new java.awt.Color(255, 0, 51));
        alreadyadded1.setText("Already added!");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Image");

        Imagee.setBackground(new java.awt.Color(204, 204, 204));
        Imagee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        uploadImage.setBackground(new java.awt.Color(0, 153, 255));
        uploadImage.setBorder(null);
        uploadImage.setForeground(new java.awt.Color(255, 255, 255));
        uploadImage.setText("Upload");
        uploadImage.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        uploadImage.setOpaque(true);
        uploadImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadImageActionPerformed(evt);
            }
        });

        previewShcolarshipGrid.setBackground(new java.awt.Color(0, 153, 255));
        previewShcolarshipGrid.setBorder(null);
        previewShcolarshipGrid.setForeground(new java.awt.Color(255, 255, 255));
        previewShcolarshipGrid.setText("Preview");
        previewShcolarshipGrid.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        previewShcolarshipGrid.setOpaque(true);
        previewShcolarshipGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewShcolarshipGridActionPerformed(evt);
            }
        });

        ImageError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ImageError.setForeground(new java.awt.Color(255, 0, 0));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Image must have max 800px width and max 800px height");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel17))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollTableDocuments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(documntsField, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addDocuments, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alreadyadded1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(117, 117, 117)
                                        .addComponent(ImageError, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Imagee, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(previewShcolarshipGrid, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                    .addComponent(uploadImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollInclusion, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NrOfSchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scrollTableField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(FieldOfStudyField, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(addFieldOfStudy, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(alreadyadded, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(deadlineField, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(degree, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(schDenomination, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(courseStartField, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scrollDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                                    .addComponent(scrolltarget, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(217, 217, 217)
                                .addComponent(scrollEligibility, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(525, 525, 525)
                            .addComponent(previewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(publishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(schDenomination, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(degree, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deadlineField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseStartField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FieldOfStudyField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addFieldOfStudy, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alreadyadded, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollTableField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NrOfSchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrolltarget, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollInclusion, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(scrollEligibility, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(documntsField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addDocuments, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alreadyadded1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(scrollTableDocuments, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(uploadImage, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(previewShcolarshipGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Imagee, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ImageError, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(publishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        scroll.setViewportView(jPanel1);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void previewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewButtonActionPerformed
        Preview();
    }//GEN-LAST:event_previewButtonActionPerformed
    
    private void addFieldOfStudyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFieldOfStudyActionPerformed
        addField();
        FieldOfStudyField.setText("");
    }//GEN-LAST:event_addFieldOfStudyActionPerformed

    private void addDocumentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDocumentsActionPerformed
        addDocs();
        documntsField.setText("");
    }//GEN-LAST:event_addDocumentsActionPerformed
    
    private void publishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishButtonActionPerformed
        PublishSch();
    }//GEN-LAST:event_publishButtonActionPerformed

    private void schDenominationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_schDenominationKeyPressed
        
    }//GEN-LAST:event_schDenominationKeyPressed

    private void FieldOfStudyFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FieldOfStudyFieldKeyPressed
        
    }//GEN-LAST:event_FieldOfStudyFieldKeyPressed

    private void uploadImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadImageActionPerformed
        addImage();
    }//GEN-LAST:event_uploadImageActionPerformed

    private void previewShcolarshipGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewShcolarshipGridActionPerformed
        previewSchGrid();
    }//GEN-LAST:event_previewShcolarshipGridActionPerformed
    
    private class Border extends EmptyBorder {
        
        private Color focuscolor = new Color(128, 189, 255);
        private Color color = new Color(206, 212, 218);

        public Color getFocuscolor() {
            return focuscolor;
        }

        public void setFocuscolor(Color focuscolor) {
            this.focuscolor = focuscolor;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
        
        public Border(int border) {
            super(border, border, border, border);
        }

        public Border() {
            this(5);
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D)g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if(c.isFocusOwner()) {
                g2.setColor(focuscolor);
            } else {
                g2.setColor(color);
            }
            g2.drawRect(x, y, width - 1, height - 1);
            g2.dispose();
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing2.MyTextField FieldOfStudyField;
    private javax.swing.JLabel ImageError;
    private javax.swing.JLabel Imagee;
    private swing2.MyTextField NrOfSchFiled;
    private swing2.Button addDocuments;
    private swing2.Button addFieldOfStudy;
    private javax.swing.JLabel alreadyadded;
    private javax.swing.JLabel alreadyadded1;
    private javax.swing.JTextArea briefDesciption;
    private swing2.MyTextField courseStartField;
    private com.raven.datechooser.DateChooser coursestartChooser;
    private com.raven.datechooser.DateChooser deadlineChooser;
    private swing2.MyTextField deadlineField;
    private swing2.MyTextField degree;
    private swing.Table documentsTable;
    private swing2.MyTextField documntsField;
    private javax.swing.JTextArea eligibility;
    private swing.Table fieldOFstudy;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> pathlist;
    private swing2.Button previewButton;
    private swing2.Button previewShcolarshipGrid;
    private swing2.Button publishButton;
    private swing.RoundPanel roundPanel1;
    private swing2.MyTextField schDenomination;
    private javax.swing.JTextArea scholarshipInclusion;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JScrollPane scrollDescription;
    private javax.swing.JScrollPane scrollEligibility;
    private javax.swing.JScrollPane scrollInclusion;
    private javax.swing.JScrollPane scrollTableDocuments;
    private javax.swing.JScrollPane scrollTableField;
    private javax.swing.JScrollPane scrolltarget;
    private javax.swing.JTextArea targetGroup;
    private swing2.Button uploadImage;
    // End of variables declaration//GEN-END:variables

}
