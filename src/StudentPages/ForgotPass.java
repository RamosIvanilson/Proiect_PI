
package StudentPages;

import StudentModels.ModelMessage;
import StudentModels.ModelUser;
import StudentPagecomponent.Message;
import StudentPagecomponent.PanelCover;
import StudentPagecomponent.PanelLoading;
import StudentPagecomponent.PanelVerifyCode;
import StudentServices.ServiceMail;
import StudentServices.ServiceUser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class ForgotPass extends javax.swing.JFrame {
    
    private MigLayout Layout;
    private PanelLoading loading;
    private PanelVerifyCode verifyCode;
    private String code;
    
    public ForgotPass() {
        initComponents();
        getContentPane().setBackground(new Color(230,234,237));
        
        newpass.setVisible(false);
        confrimpass.setVisible(false);
        okButton.setVisible(false);
        
        Layout = new MigLayout("fill, insets 0");
        loading = new PanelLoading();
        verifyCode = new PanelVerifyCode();
        
        bg.setLayout(new MigLayout("fill"));
        bg.setLayer(loading, JLayeredPane.POPUP_LAYER);
        bg.setLayer(verifyCode, JLayeredPane.POPUP_LAYER);
        bg.add(loading, "pos 0 0 100% 100%");
        bg.add(verifyCode, "pos 0 0 100% 100%");
        
        verifyCode.addEventButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                  
                if(code.equals(verifyCode.getInputCode())) {
                    
                    verifyCode.setVisible(false);
                    sendcodeButton.setVisible(false);
                    cancelButton.setVisible(false);
                    newpass.setVisible(true);
                    confrimpass.setVisible(true);
                    okButton.setVisible(true);
                    
                } else {
                    JOptionPane.showMessageDialog(null,"Code incorrect!");
                }
                
            }
            
        });
    }
    
    private void showmessage(Message.messageType mtype, String mesage) {
        Message ms = new Message();
        ms.ShowMessage(mtype, mesage);
        TimingTarget target = new TimingTargetAdapter() {
            
            @Override
            public void begin() {
                if (!ms.isShow()) {
                    bg.add(ms, "pos 0.5al 0", 0); // insert to bg first index 0
                    ms.setVisible(true);
                    bg.repaint();
                }

            }
            
            @Override
            public void timingEvent(float fraction) {
                float f;
                if (ms.isShow()) {
                    f = 40 * (1f - fraction);
                } else {
                    f = 40 * fraction;
                }
                Layout.setComponentConstraints(ms, "pos 0.5al " + (int) (f - 30));
                bg.repaint();
                bg.revalidate();
            }
            
            @Override
            public void end() {
                if (ms.isShow()) {
                    bg.remove(ms);
                    bg.repaint();
                    bg.revalidate();
                } else {
                    ms.setShow(true);
                }
                
            }
            
        };
        
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    animator.start();
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
                
            }
            
        }).start();
        
    }
    
    private String generateVerifyCode(){
        DecimalFormat df = new DecimalFormat("000000");
        Random random = new Random();
        String code = df.format(random.nextInt(1000000)); //Random from 0 to 999999
        return code;
    }
    
    private void sendMain(String email) {
        this.code = generateVerifyCode();
        new Thread(new Runnable() {
            @Override
            public void run() {
                loading.setVisible(true);
                ModelMessage ms = new ServiceMail().sendMain(email, code);
                if (ms.isSuccess()) {
                    loading.setVisible(false);
                    verifyCode.setVisible(true);
                } else {
                    loading.setVisible(false);
                    JOptionPane.showMessageDialog(null," Email error!");
                }
            }
        }).start();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();
        panelRound1 = new swing2.PanelRound();
        entermail = new javax.swing.JLabel();
        newpass = new swing2.MyTextField();
        sendcodeButton = new swing2.ButtonOutLine();
        emailField = new swing2.MyTextField();
        okButton = new swing2.ButtonOutLine();
        cancelButton = new swing2.ButtonOutLine();
        confrimpass = new swing2.MyTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(230, 234, 237));

        entermail.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        entermail.setForeground(new java.awt.Color(51, 51, 51));
        entermail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        entermail.setText("Enter Email");

        newpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newpass.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        sendcodeButton.setBackground(new java.awt.Color(51, 51, 51));
        sendcodeButton.setBorder(null);
        sendcodeButton.setForeground(new java.awt.Color(51, 51, 51));
        sendcodeButton.setText("SEND VERIFICATION CODE");
        sendcodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendcodeButtonActionPerformed(evt);
            }
        });

        emailField.setBorder(null);
        emailField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailField.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        okButton.setBackground(new java.awt.Color(51, 255, 51));
        okButton.setBorder(null);
        okButton.setForeground(new java.awt.Color(51, 255, 51));
        okButton.setText("OK");

        cancelButton.setBackground(new java.awt.Color(255, 0, 0));
        cancelButton.setBorder(null);
        cancelButton.setForeground(new java.awt.Color(255, 0, 0));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        confrimpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        confrimpass.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(entermail)
                .addGap(252, 252, 252))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(newpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(sendcodeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confrimpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(113, 113, 113))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(227, 227, 227))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(entermail)
                .addGap(18, 18, 18)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendcodeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(newpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(confrimpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bg.setLayer(panelRound1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sendcodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendcodeButtonActionPerformed
        String email = emailField.getText();
        sendMain(email);
    }//GEN-LAST:event_sendcodeButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ForgotPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private swing.RoundPanel body;
    private swing.RoundPanel body1;
    private swing.RoundPanel body2;
    private swing2.ButtonOutLine buttonOutLine1;
    private swing2.ButtonOutLine buttonOutLine2;
    private swing2.ButtonOutLine buttonOutLine3;
    private swing2.ButtonOutLine buttonOutLine4;
    private swing2.ButtonOutLine buttonOutLine5;
    private swing2.ButtonOutLine buttonOutLine6;
    private swing2.ButtonOutLine cancelButton;
    private swing2.MyTextField confrimpass;
    private swing2.MyTextField emailField;
    private javax.swing.JLabel entermail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private swing2.MyTextField myTextField1;
    private swing2.MyTextField myTextField2;
    private swing2.MyTextField myTextField3;
    private swing2.MyTextField myTextField4;
    private swing2.MyTextField myTextField5;
    private swing2.MyTextField myTextField6;
    private swing2.MyTextField newpass;
    private swing2.ButtonOutLine okButton;
    private swing2.PanelRound panelRound1;
    private swing2.ButtonOutLine sendcodeButton;
    // End of variables declaration//GEN-END:variables
}
