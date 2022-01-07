
package StudentPages;

import connection.DatabaseConnection;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import scroll.ScrollBarCustom;

public class StudentProfile extends javax.swing.JPanel {
    
    private final Connection con;
    private String UserEmail;
    
    public StudentProfile(String email) {
        initComponents();
        setOpaque(false);
        this.UserEmail = email;
        con = DatabaseConnection.getInstance().getConnection();
        scroll.setViewportBorder(null);
        scroll.setBorder(null);
        scroll.getViewport().setOpaque(false);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        saveChanges.setVisible(false);
        UserDetails();
        CancelEdit();
        
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
        body = new swing.RoundPanel();
        scroll = new javax.swing.JScrollPane();
        roundPanel2 = new swing.RoundPanel();
        editperfil = new swing.Button();
        imagePhoto = new swing.ImageAvatar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lastName = new javax.swing.JTextField();
        adress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nationality = new ComboBox.ComboBoxSuggestion();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        birthDate = new javax.swing.JTextField();
        birthPlace = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        gender = new ComboBox.ComboBoxSuggestion();
        jLabel13 = new javax.swing.JLabel();
        saveChanges = new swing.Button();
        uploadPhoto = new swing.Button();

        dateChooser1.setForeground(new java.awt.Color(102, 153, 255));
        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(birthDate);

        setBackground(new java.awt.Color(230, 234, 237));
        setOpaque(false);

        body.setBackground(new java.awt.Color(255, 255, 255));

        scroll.setBackground(new java.awt.Color(255, 255, 255));
        scroll.setBorder(null);
        scroll.setOpaque(false);

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        editperfil.setBorder(null);
        editperfil.setForeground(new java.awt.Color(255, 255, 255));
        editperfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        editperfil.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        editperfil.setOpaque(true);
        editperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editperfilActionPerformed(evt);
            }
        });

        imagePhoto.setForeground(new java.awt.Color(0, 0, 0));
        imagePhoto.setBorderSize(3);
        imagePhoto.setBorderSpace(-2);
        imagePhoto.setGradientColor1(new java.awt.Color(153, 153, 153));
        imagePhoto.setGradientColor2(new java.awt.Color(153, 153, 153));
        imagePhoto.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/4a74ef96-f7a8-4009-a476-2876074932a2.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Profile Photo");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Photo should be at least 200px X 200px");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Additional Information");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("First Name");

        firstName.setEditable(false);
        firstName.setBackground(new java.awt.Color(230, 234, 237));
        firstName.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        firstName.setForeground(new java.awt.Color(51, 51, 51));
        firstName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        firstName.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Last Name");

        lastName.setEditable(false);
        lastName.setBackground(new java.awt.Color(230, 234, 237));
        lastName.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        lastName.setForeground(new java.awt.Color(51, 51, 51));
        lastName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lastName.setBorder(null);

        adress.setEditable(false);
        adress.setBackground(new java.awt.Color(230, 234, 237));
        adress.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        adress.setForeground(new java.awt.Color(51, 51, 51));
        adress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        adress.setBorder(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Birth Date");

        nationality.setBackground(new java.awt.Color(230, 234, 237));
        nationality.setEditable(false);
        nationality.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "The Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo, Republic of the", "Congo, Democratic Republic of the", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor (Timor-Leste)", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "The Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, North", "Korea, South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia, Federated States of", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar (Burma)", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States of America", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City (Holy See)", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe" }));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Adress");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Gender");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Birth Place");

        birthDate.setBackground(new java.awt.Color(230, 234, 237));
        birthDate.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        birthDate.setForeground(new java.awt.Color(51, 51, 51));
        birthDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        birthDate.setBorder(null);

        birthPlace.setEditable(false);
        birthPlace.setBackground(new java.awt.Color(230, 234, 237));
        birthPlace.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        birthPlace.setForeground(new java.awt.Color(51, 51, 51));
        birthPlace.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        birthPlace.setBorder(null);

        phone.setEditable(false);
        phone.setBackground(new java.awt.Color(230, 234, 237));
        phone.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        phone.setForeground(new java.awt.Color(51, 51, 51));
        phone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phone.setBorder(null);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Phone");

        gender.setBackground(new java.awt.Color(230, 234, 237));
        gender.setEditable(false);
        gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Female", "Male" }));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Nationality");

        saveChanges.setBackground(new java.awt.Color(51, 51, 51));
        saveChanges.setBorder(null);
        saveChanges.setForeground(new java.awt.Color(255, 255, 255));
        saveChanges.setText("Save Changes");
        saveChanges.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveChanges.setOpaque(true);
        saveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesActionPerformed(evt);
            }
        });

        uploadPhoto.setBackground(new java.awt.Color(41, 41, 41));
        uploadPhoto.setBorder(null);
        uploadPhoto.setForeground(new java.awt.Color(255, 255, 255));
        uploadPhoto.setText("Upload Photo");
        uploadPhoto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        uploadPhoto.setOpaque(true);
        uploadPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadPhotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(imagePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(uploadPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(277, 277, 277))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(firstName)
                                    .addComponent(birthDate)
                                    .addComponent(nationality, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(phone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addComponent(jLabel12)
                                        .addComponent(birthPlace, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(lastName, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel9))
                                    .addComponent(adress, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(45, 45, 45))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(uploadPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imagePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 45, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(birthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(birthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adress, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(saveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        scroll.setViewportView(roundPanel2);

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll)
                .addContainerGap())
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
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
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private int Userid() {
        
        int userID = 0;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT userid FROM `studentsprofile` WHERE email=? limit 1");
            ps.setString(1, this.UserEmail);
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
    
    private void UserDetails(){
        
        int userID = Userid();
        try {
            
            PreparedStatement ps = con.prepareStatement("SELECT profileimage, firstname, lastname FROM `studentsprofile` WHERE userid=? limit 1");
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                ImageIcon profilePhoto = new ImageIcon(rs.getBytes("profileimage"));
                String fname = rs.getString("firstname");
                String lname = rs.getString("lastname");
                imagePhoto.setImage(profilePhoto);
                firstName.setText(fname);
                lastName.setText(lname);
            }
            rs.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void saveChanges() {
        
        int userID = Userid();
        String fname = firstName.getText();
        String lname = lastName.getText();
        String bdate = birthDate.getText();
        String bplace = birthPlace.getText();
        String phn = phone.getText();
        String nty = nationality.getSelectedItem().toString();
        String adr = adress.getText();
        String gndr = gender.getSelectedItem().toString();
        if(!fname.equals("")) {
            
            if(!lname.equals("")) {
                
                if(!bdate.equals("")) {
                    
                    if(!bplace.equals("")) {
                        
                        if(!phn.equals("")) {
                                
                            if(!adr.equals("")) {

                                try {

                                    PreparedStatement pS = con.prepareStatement("UPDATE `studentsprofile` SET firstname='"+fname+"', lastname='"+lname+"', birthdate='"+bdate+"', birthplace='"+bplace+"', phone='"+phn+"', gender='"+gndr+"', nationality='"+nty+"', adress='"+adr+"' WHERE userid='"+userID+"' limit 1");
                                    pS.execute();
                                    pS.close();

                                } catch (SQLException ex) {
                                    Logger.getLogger(StudentProfile.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            } else {
                                Border border = new Border();
                                border.setColor(Color.RED);
                                adress.setBorder(border);
                            }
                            
                        } else {
                            Border border = new Border();
                            border.setColor(Color.RED);
                            phone.setBorder(border);
                        }
                        
                    } else {
                        Border border = new Border();
                        border.setColor(Color.RED);
                        birthPlace.setBorder(border);
                    }
                    
                } else {
                    Border border = new Border();
                    border.setColor(Color.RED);
                    birthDate.setBorder(border);
                }
                
            } else {
                Border border = new Border();
                border.setColor(Color.RED);
                lastName.setBorder(border);
            }
        
        } else {
            Border border = new Border();
            border.setColor(Color.RED);
            firstName.setBorder(border);
        }
        
    }
    
    private void CancelEdit() {
        
        try {
            
            int userID = Userid();
            PreparedStatement pS = con.prepareStatement("SELECT firstname, lastname, birthdate, birthplace, phone, gender, nationality, adress FROM `studentsprofile` WHERE userid='"+userID+"' limit 1");
            ResultSet rs = pS.executeQuery();
            if(rs.next()) {
                
                String fname = rs.getString("firstname");
                String lname = rs.getString("lastname");
                String bdate = rs.getString("birthdate");
                String bplace = rs.getString("birthplace");
                String phn = rs.getString("phone");
                String nty = rs.getString("nationality");
                String adr = rs.getString("adress");
                String gndr = rs.getString("gender");
                
                firstName.setText(fname);
                lastName.setText(lname);
                birthDate.setText(bdate);
                birthPlace.setText(bplace);
                phone.setText(phn);
                adress.setText(adr);
                if(nty != null) {
                    nationality.setSelectedItem(nty);
                }
                if(gndr != null) {
                    gender.setSelectedItem(gndr);
                }
                
                firstName.setEditable(false);
                lastName.setEditable(false);
                birthPlace.setEditable(false);
                phone.setEditable(false);
                adress.setEditable(false);
                saveChanges.setVisible(false);
                
            }
            pS.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void editperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editperfilActionPerformed
        
        firstName.setEditable(true);
        lastName.setEditable(true);
        birthPlace.setEditable(true);
        phone.setEditable(true);
        adress.setEditable(true);
        saveChanges.setVisible(true);
        
    }//GEN-LAST:event_editperfilActionPerformed

    private void saveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesActionPerformed
        saveChanges();
        CancelEdit();
    }//GEN-LAST:event_saveChangesActionPerformed

    private void uploadPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadPhotoActionPerformed
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
            UploadImage(filename);
        }
    }//GEN-LAST:event_uploadPhotoActionPerformed
    
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adress;
    private javax.swing.JTextField birthDate;
    private javax.swing.JTextField birthPlace;
    private swing.RoundPanel body;
    private com.raven.datechooser.DateChooser dateChooser1;
    private swing.Button editperfil;
    private javax.swing.JTextField firstName;
    private ComboBox.ComboBoxSuggestion gender;
    private swing.ImageAvatar imagePhoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lastName;
    private ComboBox.ComboBoxSuggestion nationality;
    private javax.swing.JTextField phone;
    private swing.RoundPanel roundPanel2;
    private swing.Button saveChanges;
    private javax.swing.JScrollPane scroll;
    private swing.Button uploadPhoto;
    // End of variables declaration//GEN-END:variables
}
