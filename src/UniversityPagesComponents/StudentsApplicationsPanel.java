
package Application;

import StudentModels.Model_CardApplication;
import StudentPagecomponent.CardPanelApplication;
import StudentPages.StudentProfile;
import connection.DatabaseConnection;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import scroll.ScrollBarCustom;

public class ApplicationPanel extends javax.swing.JPanel {
    
    byte[] image;
    private String ImagePath;
    private ImageIcon MyImage;
    private final Connection con;
    private String Email;
    private ArrayList filePath = new ArrayList();
    private String sch;
    private String uni;
    private int nr_documents;
    
    public ApplicationPanel(String ScholarshipString, String university, String fname, String surname, String eml) {
        initComponents();
        this.Email = eml;
        this.sch = ScholarshipString;
        this.uni = university;
//        setFields(ScholarshipString, university);
        firstname.setText(fname);
        lastname.setText(surname);
        scholarship.setText(ScholarshipString);
        email.setText(eml);
        con = DatabaseConnection.getInstance().getConnection();
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        DocTable.setForeground(new Color(51, 51, 51));
        DocTable.setFont(new Font("Dialog", 1, 14));
        DocTable.FixTable(scrll);
        Border border = new Border();
        FullName.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                FullName.setBorder(border);
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setColor(new Color(153,153,153));
                FullName.setBorder(border);
            }
            
        });
        
        firstname.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                firstname.setBorder(border);
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setColor(new Color(153,153,153));
                firstname.setBorder(border);
            }
            
        });
        
        lastname.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                lastname.setBorder(border);
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setColor(new Color(153,153,153));
                lastname.setBorder(border);
            }
            
        });
        
        birth.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                birth.setBorder(border);
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setColor(new Color(153,153,153));
                birth.setBorder(border);
            }
            
        });
        
        placeOFbirth.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                placeOFbirth.setBorder(border);
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setColor(new Color(153,153,153));
                placeOFbirth.setBorder(border);
            }
            
        });
        
        nationality.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                nationality.setBorder(border);
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setColor(new Color(153,153,153));
                nationality.setBorder(border);
            }
            
        });
        
        gender.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                gender.setBorder(border);
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setColor(new Color(153,153,153));
                gender.setBorder(border);
            }
            
        });
        
        passport.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                passport.setBorder(border);
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setColor(new Color(153,153,153));
                passport.setBorder(border);
            }
            
        });
        
        phoneNumber.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                phoneNumber.setBorder(border);
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setColor(new Color(153,153,153));
                phoneNumber.setBorder(border);
            }
            
        });
        
        email.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                email.setBorder(border);
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setColor(new Color(153,153,153));
                email.setBorder(border);
            }
            
        });
        
        motherName.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                motherName.setBorder(border);
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setColor(new Color(153,153,153));
                motherName.setBorder(border);
            }
            
        });
        
        motherNumber.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                motherNumber.setBorder(border);
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setColor(new Color(153,153,153));
                motherNumber.setBorder(border);
            }
            
        });
        
        fatherName.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                fatherName.setBorder(border);
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setColor(new Color(153,153,153));
                fatherName.setBorder(border);
            }
            
        });
        
        fatherNumber.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                fatherNumber.setBorder(border);
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setColor(new Color(153,153,153));
                fatherNumber.setBorder(border);
            }
            
        });
        
        degree.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                degree.setBorder(border);
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setColor(new Color(153,153,153));
                degree.setBorder(border);
            }
            
        });
        
        adress.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                adress.setBorder(border);
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setColor(new Color(153,153,153));
                adress.setBorder(border);
            }
            
        });
        
    }
    
//    private void setFields(String Denomination, String university) {
//        
//        try {
//            
//            String sql = "SELECT field FROM fields WHERE denomination='"+Denomination+"' and university='"+university+"'";
//            PreparedStatement stm = con.prepareStatement(sql);
//            ResultSet rs = stm.executeQuery(sql);
//            
//            while(rs.next()) {
//                
//                String field = rs.getString("field");
//                fields.addItem(field);
//                
//            }
//            rs.close();
//            stm.close();
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e);
//        }
//        
////        try {
////            System.out.println(ScholarshipString + " " + university);
////            PreparedStatement ps = con.prepareStatement("SELECT FIELD FROM `fields` WHERE denomination=?");
////            ps.setString(1, ScholarshipString);
//////            ps.setString(2, university);
////            ResultSet rs = ps.executeQuery();
////            while(rs.next()) {
////                String field = rs.getString("field");
////                fields.addItem(field);
////            }
////            rs.close();
////            ps.close();
////            
////        } catch (SQLException ex) {
////            Logger.getLogger(StudentProfile.class.getName()).log(Level.SEVERE, null, ex);
////        }
//    }
    
    private int NrDocs() {
        int nrDocs = 0;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT nr_of_documents FROM `scholarships` WHERE denomination=? limit 1");
            ps.setString(1, this.sch);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                nrDocs = rs.getInt(1);
            }
            rs.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nrDocs;
    }
    
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        pathlist = new javax.swing.JComboBox<>();
        scroll = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        FullName = new swing2.MyTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        firstname = new swing2.MyTextField();
        jLabel3 = new javax.swing.JLabel();
        lastname = new swing2.MyTextField();
        jLabel4 = new javax.swing.JLabel();
        birth = new swing2.MyTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        passport = new swing2.MyTextField();
        phoneNumber = new swing2.MyTextField();
        email = new swing2.MyTextField();
        motherName = new swing2.MyTextField();
        motherNumber = new swing2.MyTextField();
        fatherName = new swing2.MyTextField();
        fatherNumber = new swing2.MyTextField();
        nationality = new ComboBox.ComboBoxSuggestion();
        gender = new ComboBox.ComboBoxSuggestion();
        degree = new ComboBox.ComboBoxSuggestion();
        placeOFbirth = new swing2.MyTextField();
        jLabel16 = new javax.swing.JLabel();
        scholarship = new javax.swing.JLabel();
        chooseImage = new swing.Button();
        imagePhoto = new swing.ImageAvatar();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        adress = new swing2.MyTextField();
        jLabel19 = new javax.swing.JLabel();
        UploadDocument = new swing.Button();
        scrll = new javax.swing.JScrollPane();
        DocTable = new swing.Table();
        submit = new swing.Button();

        dateChooser1.setForeground(new java.awt.Color(102, 153, 255));
        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(birth);

        pathlist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        scroll.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        FullName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        FullName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        FullName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FullNameKeyPressed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Full Name");

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("First Name");

        firstname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        firstname.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        firstname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstnameKeyPressed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Last Name");

        lastname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        lastname.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lastname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lastnameKeyPressed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Date of Birth");

        birth.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        birth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        birth.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Nacionality");

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Gender");

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Passport");

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Phone Number");

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Email");

        jLabel11.setBackground(new java.awt.Color(51, 51, 51));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Mother's Name");

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Mother's Number");

        jLabel13.setBackground(new java.awt.Color(51, 51, 51));
        jLabel13.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Father's Name");

        jLabel14.setBackground(new java.awt.Color(51, 51, 51));
        jLabel14.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Father's Number");

        jLabel15.setBackground(new java.awt.Color(51, 51, 51));
        jLabel15.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Study Cycle");

        passport.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        passport.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        phoneNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        phoneNumber.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        phoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneNumberKeyPressed(evt);
            }
        });

        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        email.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        motherName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        motherName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        motherName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                motherNameKeyPressed(evt);
            }
        });

        motherNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        motherNumber.setToolTipText("");
        motherNumber.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        fatherName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        fatherName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        fatherName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fatherNameKeyPressed(evt);
            }
        });

        fatherNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        fatherNumber.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        nationality.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "The Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo, Republic of the", "Congo, Democratic Republic of the", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor (Timor-Leste)", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "The Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, North", "Korea, South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Federated States of Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar (Burma)", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States of America", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City (Holy See)", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe" }));
        nationality.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        gender.setEditable(false);
        gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        gender.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        degree.setEditable(false);
        degree.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bachelor Degree", "Master Degree", "Doctorate Degree" }));
        degree.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        degree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degreeActionPerformed(evt);
            }
        });

        placeOFbirth.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        placeOFbirth.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel16.setBackground(new java.awt.Color(51, 51, 51));
        jLabel16.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Place of Birth");

        scholarship.setBackground(new java.awt.Color(255, 255, 255));
        scholarship.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        scholarship.setForeground(new java.awt.Color(44, 126, 197));
        scholarship.setText("Amsterdam Merit Scholarships for Excellent International Students");
        scholarship.setOpaque(true);

        chooseImage.setBackground(new java.awt.Color(44, 126, 197));
        chooseImage.setForeground(new java.awt.Color(255, 255, 255));
        chooseImage.setText("Choose Photo");
        chooseImage.setOpaque(true);
        chooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseImageActionPerformed(evt);
            }
        });

        imagePhoto.setBorderSize(2);
        imagePhoto.setBorderSpace(1);
        imagePhoto.setGradientColor1(new java.awt.Color(204, 204, 204));
        imagePhoto.setGradientColor2(new java.awt.Color(204, 204, 204));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Photo must have max 201px width and max 201px height");

        jLabel18.setBackground(new java.awt.Color(51, 51, 51));
        jLabel18.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Permanent Adress");

        adress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        adress.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Documents:");

        UploadDocument.setBackground(new java.awt.Color(51, 51, 51));
        UploadDocument.setBorder(null);
        UploadDocument.setForeground(new java.awt.Color(255, 255, 255));
        UploadDocument.setText("Upload");
        UploadDocument.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        UploadDocument.setOpaque(true);
        UploadDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadDocumentActionPerformed(evt);
            }
        });

        DocTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Document", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrll.setViewportView(DocTable);
        if (DocTable.getColumnModel().getColumnCount() > 0) {
            DocTable.getColumnModel().getColumn(0).setResizable(false);
            DocTable.getColumnModel().getColumn(0).setPreferredWidth(400);
            DocTable.getColumnModel().getColumn(1).setResizable(false);
        }

        submit.setBackground(new java.awt.Color(51, 153, 255));
        submit.setBorder(null);
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("SUBMIT");
        submit.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        submit.setOpaque(true);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(scholarship))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(imagePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel19))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fatherName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(motherName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(birth, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FullName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(degree, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(UploadDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(scrll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(submit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(motherNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passport, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(placeOFbirth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(adress, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fatherNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(83, 83, 83))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scholarship, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imagePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FullName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birth, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(placeOFbirth, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adress, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(passport, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(73, 73, 73)))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(motherName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(motherNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(fatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(fatherNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(degree, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(UploadDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrll, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );

        scroll.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1692, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void chooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImageActionPerformed
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
                return ".png | .jpg | .jepg";
            }
        });
        
        int X = fileChooser.showSaveDialog(null);
        if(X == JFileChooser.APPROVE_OPTION) {
        
            File file = fileChooser.getSelectedFile();
            String filename = file.getAbsolutePath();
            imagePhoto.setImage(new ImageIcon(filename));
            if(imagePhoto.getImage().getIconWidth() > 201) {
                JOptionPane.showMessageDialog(null, "Width Error: " + imagePhoto.getImage().getIconWidth() + "px > " + 201 + "px");
                imagePhoto.setImage(new ImageIcon(getClass().getResource("/icon/profileIcon.png")));
            } else if(imagePhoto.getImage().getIconHeight() > 201) {
                JOptionPane.showMessageDialog(null, "Height Error: " + imagePhoto.getImage().getIconHeight()+ "px > " + 201 + "px");
                imagePhoto.setImage(new ImageIcon(getClass().getResource("/icon/profileIcon.png")));
            } else {
                this.ImagePath = filename;
            }
        }
        
    }//GEN-LAST:event_chooseImageActionPerformed

    private void UploadDocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadDocumentActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\THINKPAD\\Documents"));
        
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                String n = file.getName().toLowerCase();
                if(file.isDirectory() | n.endsWith(".pdf")) {
                    return true;
                }
                return false;
            }

            @Override
            public String getDescription() {
                return ".pdf";
            }
        });
        
        int X = fileChooser.showSaveDialog(null);
        if(X == JFileChooser.APPROVE_OPTION) {
            
            File file = fileChooser.getSelectedFile();
            String filename = file.getAbsolutePath();
            pathlist.addItem(filename);
            DocTable.addRow(new ModelTableData(file.getName()), true);
            DocTable.addTableCell(new CellAction(), 1);
        }
        
    }//GEN-LAST:event_UploadDocumentActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        if(CheckInput()) {
            if(AlreadyApplied() == false) {
                SubmitApplication();
                UploadDocuments();
            } else {
                JOptionPane.showMessageDialog(null, "Already Applied!");
            }
        }
    }//GEN-LAST:event_submitActionPerformed

    private void FullNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FullNameKeyPressed
        
        char c = evt.getKeyChar();
        
        if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
            FullName.setEditable(true);
        } else {
            FullName.setEditable(false);
        }
        
    }//GEN-LAST:event_FullNameKeyPressed

    private void firstnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstnameKeyPressed
        char c = evt.getKeyChar();
        
        if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
            firstname.setEditable(true);
        } else {
            firstname.setEditable(false);
        }
    }//GEN-LAST:event_firstnameKeyPressed

    private void lastnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastnameKeyPressed
        char c = evt.getKeyChar();
        
        if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
            lastname.setEditable(true);
        } else {
            lastname.setEditable(false);
        }
    }//GEN-LAST:event_lastnameKeyPressed

    private void phoneNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberKeyPressed
       
    }//GEN-LAST:event_phoneNumberKeyPressed

    private void motherNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_motherNameKeyPressed
       char c = evt.getKeyChar();
        
        if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
            motherName.setEditable(true);
        } else {
            motherName.setEditable(false);
        }
    }//GEN-LAST:event_motherNameKeyPressed

    private void fatherNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fatherNameKeyPressed
        char c = evt.getKeyChar();
        
        if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
            fatherName.setEditable(true);
        } else {
            fatherName.setEditable(false);
        }
    }//GEN-LAST:event_fatherNameKeyPressed

    private void degreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_degreeActionPerformed
    
    private boolean CheckInput() {
        boolean inputOk = false;
        
        Icon imageName = imagePhoto.getImage();
        String Fname = FullName.getText().trim();
        String fname = firstname.getText().trim();
        String lname = lastname.getText().trim();
        String placeB = placeOFbirth.getText().trim();
        String Adress = adress.getText().trim();
        String Psst = passport.getText().trim();
        String phn = phoneNumber.getText().trim();
        String eml = email.getText().trim();
        String Mname = motherName.getText().trim();
        String Mnumber = motherNumber.getText().trim();
        String Faname = fatherName.getText().trim();
        String Fanumber = fatherNumber.getText().trim();
        int nrDocs = NrDocs();
        
        if(!Fname.equals("")) {
            if(!fname.equals("")) {
                if(!lname.equals("")) {
                    if(!placeB.equals("")) {
                        if(!Adress.equals("")) {
                            if(!Psst.equals("")) {
                                if(!phn.equals("")) {
                                    if(!eml.equals("")) {
                                        if(!Mname.equals("")) {
                                            if(!Mnumber.equals("")) {
                                                if(!Faname.equals("")) {
                                                    if(!Fanumber.equals("")) {
                                                        if(DocTable.getRowCount() == nrDocs) {
                                                            if(imageName != null) {
                                                                if(isEmail(eml)) {
                                                                    inputOk = true;
                                                                } else {
                                                                    Border border = new Border();
                                                                    border.setColor(Color.RED);
                                                                    fatherNumber.setBorder(border);
                                                                }
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "Missing Photo!");
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Missing document!");
                                                        }
                                                    } else {
                                                        Border border = new Border();
                                                        border.setColor(Color.RED);
                                                        fatherNumber.setBorder(border);
                                                    }
                                                } else {
                                                    Border border = new Border();
                                                    border.setColor(Color.RED);
                                                    fatherName.setBorder(border);
                                                }
                                            } else {
                                                Border border = new Border();
                                                border.setColor(Color.RED);
                                                motherNumber.setBorder(border);
                                            }
                                        } else {
                                            Border border = new Border();
                                            border.setColor(Color.RED);
                                            motherName.setBorder(border);
                                        }
                                    } else {
                                        Border border = new Border();
                                        border.setColor(Color.RED);
                                        email.setBorder(border);
                                    }
                                } else {
                                    Border border = new Border();
                                    border.setColor(Color.RED);
                                    phoneNumber.setBorder(border);
                                }
                            } else {
                                Border border = new Border();
                                border.setColor(Color.RED);
                                passport.setBorder(border);
                            }
                        } else {
                            Border border = new Border();
                            border.setColor(Color.RED);
                            adress.setBorder(border);
                        }
                    } else {
                        Border border = new Border();
                        border.setColor(Color.RED);
                        placeOFbirth.setBorder(border);
                    }
                } else {
                    Border border = new Border();
                    border.setColor(Color.RED);
                    lastname.setBorder(border);
                }
            } else {
                Border border = new Border();
                border.setColor(Color.RED);
                firstname.setBorder(border);
            }
        } else {
            Border border = new Border();
            border.setColor(Color.RED);
            FullName.setBorder(border);
        }
        
        return inputOk;
    }
    
    private boolean isEmail(String input) {
            Pattern emailValidation = Pattern.compile("^(.+)@(.+)$");
            return emailValidation.matcher(input).matches();
    }
    
    private boolean AlreadyApplied() {
        
        boolean applied = false;
        try {
            
            PreparedStatement pS = con.prepareStatement("SELECT denomination FROM `applications` WHERE denomination='"+this.sch+"' and applicantemail='"+this.Email+"' limit 1");
            ResultSet rs = pS.executeQuery();
            if(rs.next()) {
                applied = true;
            }
            pS.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return applied;
    }
    
    private void SubmitApplication() {
        
        String Fname = FullName.getText().trim();
        String fname = firstname.getText().trim();
        String lname = lastname.getText().trim();
        String dateB = birth.getText().trim();
        String placeB = placeOFbirth.getText().trim();
        String Adress = adress.getText().trim();
        String nty = nationality.getSelectedItem().toString();
        String gen = gender.getSelectedItem().toString();
        String Psst = passport.getText().trim();
        String phn = phoneNumber.getText().trim();
        String eml = email.getText().trim();
        String Mname = motherName.getText().trim();
        String Mnumber = motherNumber.getText().trim();
        String Faname = fatherName.getText().trim();
        String Fanumber = fatherNumber.getText().trim();
        String cycle = degree.getSelectedItem().toString();
        
        try {
            
            PreparedStatement pS = con.prepareStatement("INSERT INTO applicationform(photo, denomination, university, fullname, firstname, lastname, birthdate, birthplace, adress, nationality, gender, passport, phonenumber, email, mothername, mothernumber, fathername, fathernumber, studycycle) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            
            pS.setBinaryStream(1, new FileInputStream(this.ImagePath));
            pS.setString(2, this.sch);
            pS.setString(3, this.uni);
            pS.setString(4, Fname);
            pS.setString(5, fname);
            pS.setString(6, lname);
            pS.setString(7, dateB);
            pS.setString(8, placeB);
            pS.setString(9, Adress);
            pS.setString(10, nty);
            pS.setString(11, gen);
            pS.setString(12, Psst);
            pS.setString(13, phn);
            pS.setString(14, eml);
            pS.setString(15, Mname);
            pS.setString(16, Mnumber);
            pS.setString(17, Faname);
            pS.setString(18, Fanumber);
            pS.setString(19, cycle);
            pS.execute();
            
            ResultSet rs = pS.getGeneratedKeys();
            rs.next();
            
            rs.close();
            pS.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentProfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ApplicationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void UploadDocuments() {
        String path = "";
        String eml = email.getText().trim();
        int row = DocTable.getRowCount();
        int i,j;
        for(i=0;i<row;i++) {
            String filename = (DocTable.getModel().getValueAt(i, 0).toString());
            for(j=0;j<pathlist.getItemCount();j++) {
                if(pathlist.getItemAt(j).contains(filename)) {
                    path = pathlist.getItemAt(j);
                    break;
                }
            }
            try {

                PreparedStatement pS = con.prepareStatement("INSERT INTO applicationdocuments(denomination, university, applicantemail, document) VALUES(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

                pS.setString(1, this.sch);
                pS.setString(2, this.uni);
                pS.setString(3, eml);
                pS.setBinaryStream(4, new FileInputStream(path));
                pS.execute();

                ResultSet rs = pS.getGeneratedKeys();
                rs.next();

                rs.close();
                pS.close();
                JOptionPane.showMessageDialog(null, "Application successfully submited!");

            } catch (SQLException ex) {
                Logger.getLogger(StudentProfile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ApplicationPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    private int Userid() {
        
        int userID = 0;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT userid FROM `studentsprofile` WHERE email=? limit 1");
            ps.setString(1, this.Email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                userID = rs.getInt(1);
            }
            rs.close();
            ps.close();
            
            return userID;
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    private void UploadImage(String path) {
        
        int userID = Userid();
        try {
            
            PreparedStatement pS = con.prepareStatement("UPDATE `studentsprofile` SET profileimage=? WHERE userid='"+userID+"' limit 1");
            pS.setBinaryStream(1, new FileInputStream(path));
            pS.execute();
            pS.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentProfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private ImageIcon setIcon(String myImage, byte[] image) {

        if(myImage != null) {
            MyImage = new ImageIcon(myImage);
        } else {
            MyImage = new ImageIcon(image);
        }

        Image img1 = MyImage.getImage();
        Image img2 = img1.getScaledInstance(imagePhoto.getWidth(), imagePhoto.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(img2);

        return i;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Table DocTable;
    private swing2.MyTextField FullName;
    private swing.Button UploadDocument;
    private swing2.MyTextField adress;
    private swing2.MyTextField birth;
    private swing.Button chooseImage;
    private com.raven.datechooser.DateChooser dateChooser1;
    private ComboBox.ComboBoxSuggestion degree;
    private swing2.MyTextField email;
    private swing2.MyTextField fatherName;
    private swing2.MyTextField fatherNumber;
    private swing2.MyTextField firstname;
    private ComboBox.ComboBoxSuggestion gender;
    private swing.ImageAvatar imagePhoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private swing2.MyTextField lastname;
    private swing2.MyTextField motherName;
    private swing2.MyTextField motherNumber;
    private ComboBox.ComboBoxSuggestion nationality;
    private swing2.MyTextField passport;
    private javax.swing.JComboBox<String> pathlist;
    private swing2.MyTextField phoneNumber;
    private swing2.MyTextField placeOFbirth;
    private javax.swing.JLabel scholarship;
    private javax.swing.JScrollPane scrll;
    private javax.swing.JScrollPane scroll;
    private swing.Button submit;
    // End of variables declaration//GEN-END:variables
}
