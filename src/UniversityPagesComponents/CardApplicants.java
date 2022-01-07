
package UniversityPagesComponents;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.event.AncestorListener;

public class CardApplicants extends javax.swing.JPanel {
    
    private int ID;
    
    public CardApplicants(int id, Icon icon, String denomination, String university, String faculty, String field, String fullname, String firstname, String lastname,String birthdate, String birthplace, String adress, String nationality, String gender, String passport, String phonenumber, String email, String mothername, String mothernumber, String fathername, String fathernumber, String studycycle, String status) {
        initComponents();
        this.ID = id;
        init(icon, fullname, status);
    }
    
    private void init(Icon icon, String fullname, String Status) {
        imageAvatar.setImage(icon);
        NameSurname.setText(fullname);
        status.setText(Status);
        imageAvatar.addAncestorListener((AncestorListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
            
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar = new swing.ImageAvatar();
        NameSurname = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        imageAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                imageAvatarMouseEntered(evt);
            }
        });

        NameSurname.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        NameSurname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameSurname.setText("TEST");

        status.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status.setText("TEST");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imageAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NameSurname, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NameSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void imageAvatarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageAvatarMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_imageAvatarMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NameSurname;
    private swing.ImageAvatar imageAvatar;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
