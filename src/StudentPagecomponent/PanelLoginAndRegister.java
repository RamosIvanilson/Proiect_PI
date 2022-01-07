
package StudentPagecomponent;

import StudentModels.ModelUser;
import StudentModels.ModelLogin;
import StudentPages.ForgotPass;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import swing2.Button;
import swing2.MyPasswordField;
import swing2.MyTextField;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {
    
    private ModelUser user;
    private ModelLogin dataLogin;
    
    public ModelLogin getDataLogin() {
        return dataLogin;
    }
    
    public ModelUser getUser() {
        return user;
    }
    
    
    public PanelLoginAndRegister(ActionListener eventRegister, ActionListener eventLogin) {
        initComponents();
        initRegister(eventRegister);
        initLogin(eventLogin);
    }
    
    private void initRegister(ActionListener eventRegister) {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]20[]15[]15[]25[]push"));
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(41, 41, 49));
        register.add(label);
        MyTextField txtUserName = new MyTextField();
        txtUserName.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        txtUserName.setHint("First Name");
        register.add(txtUserName, "w 50%");
        
        MyTextField txtUserSurname = new MyTextField();
        txtUserSurname.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        txtUserSurname.setHint("Last Name");
        register.add(txtUserSurname, "w 50%");
        
//        MyTextField txtUserUsername = new MyTextField();
//        txtUserUsername.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
//        txtUserUsername.setHint("Username");
//        register.add(txtUserUsername, "w 50%");
        
        MyTextField txtUserEmail = new MyTextField();
        txtUserEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/mail.png")));
        txtUserEmail.setHint("Email");
        register.add(txtUserEmail, "w 50%");
        
        MyPasswordField passUser = new MyPasswordField();
        passUser.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        passUser.setHint("Password");
        register.add(passUser, "w 50%");
        
        Button createAccountButton = new Button();
        createAccountButton.setBackground(new Color(41, 41, 49));
        createAccountButton.setForeground(new Color(250, 250, 250));
        createAccountButton.addActionListener(eventRegister);
        createAccountButton.setText("SIGN UP");
        register.add(createAccountButton, "w 40%, h 40");
        
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstname = txtUserName.getText().trim();
                String lastname = txtUserSurname.getText().trim();
                String email = txtUserEmail.getText().trim();
                String password = String.valueOf(passUser.getPassword()).trim();
                if(!firstname.equals("")) {
                    if(!lastname.equals("")) {
                        if(!email.equals("")) {
                            if(!password.equals("")) {
                                user = new ModelUser(0, firstname, lastname, email, password);
                            }
                        }
                    }
                }
            }
        });
    }
    
    private void initLogin(ActionListener eventLogin) {
        
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]20[]15[]15[]15[]25[]push"));
        JLabel label = new JLabel("SIGN IN");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(41, 41, 49));
        login.add(label);
        
        MyTextField txtUsername_Email = new MyTextField();
        txtUsername_Email.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        txtUsername_Email.setHint("Email");
        login.add(txtUsername_Email, "w 50%");
        
        MyPasswordField passUser = new MyPasswordField();
        passUser.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        passUser.setHint("Password");
        login.add(passUser, "w 50%");
        
        JButton cmdForget = new JButton("Forgot Password?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 13));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
        
        Button LoginButton = new Button();
        LoginButton.setBackground(new Color(41, 41, 49));
        LoginButton.setForeground(new Color(250, 250, 250));
        LoginButton.addActionListener(eventLogin);
        LoginButton.setText("SIGN IN");
        login.add(LoginButton, "w 40%, h 40");
        
//        cmdForget.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                ForgotPass forgot = new ForgotPass();
//                forgot.setVisible(true);
//            }
//        });
        
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username_email = txtUsername_Email.getText().trim();
                String password = String.valueOf(passUser.getPassword()).trim();
                dataLogin = new ModelLogin(username_email, password);
            }
        });
    }
    
    public void showRegister(boolean show) {
        if(show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register = new javax.swing.JPanel();
        login = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card3");

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
