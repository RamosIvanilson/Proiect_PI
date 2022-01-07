
package UniversityPages;

import com.raven.swing.scroll.ScrollBarCustom;
import StudentPagecomponent.CardPanel;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import StudentModels.Model_Card;
import StudentModels.Model_CardSaves;
import StudentPages.StudentProfile;
import UniversityPagesComponents.CardPanelEditSch;
import connection.DatabaseConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import swing.WrapLayout;

public class UniversityEditScholarships extends javax.swing.JPanel {
    
    private String  Email;
    private final Connection con;
    
    public UniversityEditScholarships(String email) {
        initComponents();
        con = DatabaseConnection.getInstance().getConnection();
        this.Email = email;
        setOpaque(false);
        init();
    }
    
    private String SetUniversity() {
        String uni = "";
        
        try {
            PreparedStatement ps = con.prepareStatement("SELECT university FROM universities WHERE email=? limit 1");
            ps.setString(1, this.Email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                uni = rs.getString("university");
            }
            rs.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return uni;
    }
    
    private void init() {
        
        panel.setLayout(new WrapLayout(WrapLayout.CENTER));
        scroll.setViewportBorder(null);
        scroll.setBorder(null);
        scroll.getViewport().setOpaque(false);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        
        String university = SetUniversity();
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/piproject?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            String sql = "SELECT image, `denomination`, `university` FROM `scholarships` WHERE university='"+university+"'";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()) {
                ImageIcon icon = new ImageIcon(rs.getBytes("image"));
                String sch = rs.getString("denomination");
                String uni = rs.getString("university");
                panel.add(new CardPanelEditSch(new Model_CardSaves(icon, uni, sch, this.Email)));
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
        roundPanel2 = new swing.RoundPanel();
        scroll = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(41, 41, 41));

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        scroll.setBorder(null);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(930, 655));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 951, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 744, Short.MAX_VALUE)
        );

        scroll.setViewportView(panel);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel panel;
    private swing.RoundPanel roundPanel2;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
