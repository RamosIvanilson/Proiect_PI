package UniversityPages;

import StudentServices.ServiceMail;
import StudentModels.ModelMessage;
import StudentModels.ModelLogin;
import Home.UniversityPage;
import StudentPagecomponent.*;
import UniversityModels.ModelUniversity;
import UniversityPagesComponents.*;
import UniversityServices.ServiceUniversity;
import connection.DatabaseConnection;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.*;

public class UniversityLogin extends javax.swing.JFrame {

    private MigLayout Layout;
    private PanelCover cover;
    private PanelLoading loading;
    private PanelVerifyCode verifyCode;
    private PanelLoginAndRegisterUniversity loginAndRegister;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginsize = 60;
    private final DecimalFormat df = new DecimalFormat("##0.###");
    private ServiceUniversity service;
    
    public UniversityLogin() {
        initComponents();
        init();
    }
    // ivanilsonbs321@gmail.com
    // 9956173iva
    private void init() {
        
        service = new ServiceUniversity();
        Layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        loading = new PanelLoading();
        verifyCode = new PanelVerifyCode();

        ActionListener eventRegister = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
            
        };

        ActionListener eventLogin = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
            
        };
        
        loginAndRegister = new PanelLoginAndRegisterUniversity(eventRegister, eventLogin);
        TimingTarget target = new TimingTargetAdapter() {
            
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double size = coverSize;
                double fractionlogin;
                
                if (fraction <= 0.5f) {
                    size += fraction * addSize;
                } else {
                    size += addSize - fraction * addSize;
                }
                
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionlogin = fraction;
                    if (fraction >= 0.5f) {
                        cover.registerRight(fractionCover * 100);
                    } else {
                        cover.LoginRight(fractionlogin * 100);
                    }
                } else {
                    fractionCover = fraction;
                    fractionlogin = 1f - fraction;
                    if (fraction <= 0.5f) {
                        cover.registerLeft(fraction * 100);
                    } else {
                        cover.LoginLeft((1f - fraction) * 100);
                    }
                    
                }
                
                if (fraction >= 0.5f) {
                    loginAndRegister.showRegister(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionlogin = Double.valueOf(df.format(fractionlogin));
                Layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                Layout.setComponentConstraints(loginAndRegister, "width " + loginsize + "%, pos " + fractionlogin + "al 0 n 100%");
                bg.revalidate();
            }
            
            @Override
            public void end() {
                isLogin = !isLogin;
            }
            
        };
        
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0); // for smooth animation
        bg.setLayout(Layout);
        bg.setLayer(loading, JLayeredPane.POPUP_LAYER);
        bg.setLayer(verifyCode, JLayeredPane.POPUP_LAYER);
        bg.add(loading, "pos 0 0 100% 100%");
        bg.add(verifyCode, "pos 0 0 100% 100%");
        bg.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        bg.add(loginAndRegister, "width " + loginsize + "%, pos 1al 0 n 100%"); // 1al as 100%
        cover.addEvent(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                
            }
            
        });
        
        verifyCode.addEventButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                try {
                    ModelUniversity user = loginAndRegister.getUser();
                    if (service.VerifyCodeWithUser(user.getUserID(), verifyCode.getInputCode())) {
                        service.doneVerify(user.getUserID());
                        showmessage(Message.messageType.Success, "Account Created!");
                        verifyCode.setVisible(false);
                    } else {
                        showmessage(Message.messageType.ERROR, "Code Incorrect!");
                    }
                } catch (SQLException e) {
                    showmessage(Message.messageType.ERROR, "Error");
                    System.err.println(e);
                }
                
            }
            
        });

    }
    
    private void register() {
        ModelUniversity user = loginAndRegister.getUser();
        
        try {
            if (service.checkDuplicateEmail(user.getEmail())) {
                showmessage(Message.messageType.ERROR, "Email already exists!");
            } else {
                service.insertuser(user);
//                service.insertUserSP(user.getUserID(), user.getCountry(), user.getUniversity(), user.getEmail());
                sendMain(user);
            }
        } catch (Exception e) {
            showmessage(Message.messageType.ERROR, "Error Register");
            System.out.println(e);
        }
        
    }
    
    private void login() {
        ModelLogin data = loginAndRegister.getDataLogin();
        try {
            
            ModelUniversity user = service.login(data);
            if (user != null) {
                this.dispose();
                UniversityPage page = new UniversityPage(data.getEmail());
                page.show();
            } else {
                showmessage(Message.messageType.ERROR, "Email or Password incorrect");
            }

        } catch (SQLException e) {
            showmessage(Message.messageType.ERROR, "Error Login");
            System.out.println(e);
        }
    }
    
    private void sendMain(ModelUniversity user) {
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                loading.setVisible(true);
                ModelMessage ms = new ServiceMail().sendMain(user.getEmail(), user.getVerifyCode());
                if (ms.isSuccess()) {
                    loading.setVisible(false);
                    verifyCode.setVisible(true);
                } else {
                    loading.setVisible(false);
                    showmessage(Message.messageType.ERROR, ms.getMessage());
                }
            }
            
        }).start();
        
    }

    private void showmessage(Message.messageType mtype, String mesage) {
        Message ms = new Message();
        ms.ShowMessage(mtype, mesage);
        TimingTarget target = new TimingTargetAdapter() {
            
            @Override
            public void begin() {
                if (!ms.isShow()) {
                    bg.add(ms, "pos 0.5al -30", 0); // insert to bg first index 0
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();
        drag = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1123, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        drag.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                dragMouseDragged(evt);
            }
        });
        drag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dragMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(drag, javax.swing.GroupLayout.DEFAULT_SIZE, 1123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(drag, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 521, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void dragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragMousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_dragMousePressed
    
    private void dragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragMouseDragged
        this.setLocation(this.getX() + evt.getX() - mouseX, this.getY() + evt.getY() - mouseY);
    }//GEN-LAST:event_dragMouseDragged
    
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
            java.util.logging.Logger.getLogger(UniversityLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UniversityLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UniversityLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UniversityLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        try {
            DatabaseConnection.getInstance().connectToDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UniversityLogin().setVisible(true);
            }
            
        });
        
    }
    
    private int mouseX, mouseY;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private javax.swing.JLabel drag;
    // End of variables declaration//GEN-END:variables
}
