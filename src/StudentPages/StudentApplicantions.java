
package StudentPages;

import StudentPagecomponent.CardPanel;
import com.raven.swing.scroll.ScrollBarCustom;
import StudentPagecomponent.CardPanelApplication;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import StudentModels.Model_Card;
import StudentModels.Model_CardApplication;
import swing.WrapLayout;

public class StudentApplicantions extends javax.swing.JPanel {
    
    private String Email;
    
    public StudentApplicantions(String email) {
        initComponents();
        this.Email = email;
        setOpaque(false);
        init(email);
        reload.setVisible(false);
    }
    
    private void init(String email) {
        
        panel.setLayout(new WrapLayout(WrapLayout.CENTER));
        scroll.setViewportBorder(null);
        scroll.setBorder(null);
        scroll.getViewport().setOpaque(false);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/piproject?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            String sql = "SELECT `denomination`, `university`, `applicantemail` FROM `applications` WHERE `applicantemail` LIKE '"+email+"'";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()) {
                String sch = rs.getString("denomination");
                String uni = rs.getString("university");
                String Email = rs.getString("applicantemail");
                panel.add(new CardPanelApplication(new Model_CardApplication(new ImageIcon(getClass().getResource("/UniversityImages/"+uni+".jpg")), uni, sch, Email)));
            }
            
            con.close();
            panel.revalidate();
            panel.repaint();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        roundPanel1 = new swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        reload = new swing.Button();
        search = new ComboBox.ComboBoxSuggestion();
        searchButton = new swing.Button();
        country = new javax.swing.JRadioButton();
        university = new javax.swing.JRadioButton();
        roundPanel2 = new swing.RoundPanel();
        scroll = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(41, 41, 41));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Search by:");

        reload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reload.png"))); // NOI18N
        reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadActionPerformed(evt);
            }
        });

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        country.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(country);
        country.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        country.setForeground(new java.awt.Color(51, 51, 51));
        country.setText("Country");
        country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryActionPerformed(evt);
            }
        });

        university.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(university);
        university.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        university.setForeground(new java.awt.Color(51, 51, 51));
        university.setText("University");
        university.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                universityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(country)
                .addGap(44, 44, 44)
                .addComponent(university)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reload, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(country, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(university, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        scroll.setBorder(null);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(930, 655));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 657, Short.MAX_VALUE)
        );

        scroll.setViewportView(panel);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadActionPerformed
        panel.removeAll();
        init(this.Email);
        reload.setVisible(false);
    }//GEN-LAST:event_reloadActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased

    }//GEN-LAST:event_searchKeyReleased

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        if(country.isSelected()) {
            SearchCountry();
        } else if(university.isSelected()) {
            SearchUniversity();
        }
        reload.setVisible(true);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void countryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryActionPerformed
        addSearchCountry();
    }//GEN-LAST:event_countryActionPerformed

    private void universityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_universityActionPerformed
        addSearchUniversity();
    }//GEN-LAST:event_universityActionPerformed

    private void addSearchUniversity() {
        
        search.removeAllItems();
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/piproject?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            String sql = "SELECT university FROM scholarships";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()) {
                String cou = rs.getString("university");
                search.addItem(cou);
            }
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void addSearchCountry() {
        
        search.removeAllItems();
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/piproject?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            String sql = "SELECT country FROM scholarships";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()) {
                String cou = rs.getString("country");
                search.addItem(cou);
            }
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
        
    private void SearchCountry() {
        
        panel.setLayout(new WrapLayout(WrapLayout.CENTER));
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        panel.removeAll();
        String Stext = search.getSelectedItem().toString();
        if(!Stext.equals("")) {
            String string = "%"+Stext+"%";
            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/piproject?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
                String sql = "SELECT denomination, university FROM scholarships WHERE country LIKE '"+string+"'";
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet rs = stm.executeQuery(sql);

                while(rs.next()) {
                    String sch = rs.getString("denomination");
                    String uni = rs.getString("university");
                    panel.add(new CardPanel(new Model_Card(new ImageIcon(getClass().getResource("/UniversityImages/"+uni+".jpg")), uni, sch, this.Email)));
                }

                con.close();
                panel.revalidate();
                panel.repaint();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
        
    }
    
    private void SearchUniversity() {
        
        panel.setLayout(new WrapLayout(WrapLayout.CENTER));
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        panel.removeAll();
        String Stext = search.getSelectedItem().toString();
        if(!Stext.equals("")) {
            String string = "%"+Stext+"%";
            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/piproject?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
                String sql = "SELECT `denomination`, `university` FROM `scholarships` WHERE university LIKE '"+string+"'";
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet rs = stm.executeQuery(sql);

                while(rs.next()) {
                    String sch = rs.getString("denomination");
                    String uni = rs.getString("university");
                    panel.add(new CardPanel(new Model_Card(new ImageIcon(getClass().getResource("/UniversityImages/"+uni+".jpg")), uni, sch, this.Email)));
                }

                con.close();
                panel.revalidate();
                panel.repaint();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton country;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel;
    private swing.Button reload;
    private swing.RoundPanel roundPanel1;
    private swing.RoundPanel roundPanel2;
    private javax.swing.JScrollPane scroll;
    private ComboBox.ComboBoxSuggestion search;
    private swing.Button searchButton;
    private javax.swing.JRadioButton university;
    // End of variables declaration//GEN-END:variables
}
