
package StudentPagecomponent;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import swing2.ButtonOutLine;

public class PanelCover extends javax.swing.JPanel {
    
    private final DecimalFormat df = new DecimalFormat("##0.###");
    private ActionListener event;
    private MigLayout layout;
    private JLabel logo;
    private JLabel title;
    private JLabel description;
    private JLabel description1;
    private ButtonOutLine button;
    private boolean islogin;
    
    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]15[]10[]15[]25[]push");
        setLayout(layout);
        init();
    }
    
    private void init() {
        logo = new JLabel();
        logo.setIcon(new ImageIcon(getClass().getResource("/icon/LRlogo.png")));
        add(logo);
        title = new JLabel("Welcome Back!");
        title.setFont(new Font("sansserif", 1, 30));
        title.setForeground(new Color(245, 245, 245));
        add(title);
        description = new JLabel("To keep connected with us please");
        description.setForeground(new Color(245, 245, 245));
        add(description);
        description1 = new JLabel("login with your personal information");
        description1.setForeground(new Color(245, 245, 245));
        add(description1);
        button = new ButtonOutLine();
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(new Color(255, 255, 255));
        button.setText("SIGN IN");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.actionPerformed(e);
            }
            
        });
        add(button, "w 50%, h 40");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        GradientPaint gradientPaint = new GradientPaint(0, 0, new Color(41, 41, 41), 0, getHeight(), new Color(41, 41, 41));
        g2.setPaint(gradientPaint);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
    
    public void addEvent(ActionListener event) {
        this.event = event;
    }
    
    public void registerLeft(double v) {
        v = Double.valueOf(df.format(v));
        Login(false);
        layout.setComponentConstraints(title, "pad 0 -" +v+ "% 0 0");
        layout.setComponentConstraints(description, "pad 0 -" +v+ "% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -" +v+ "% 0 0");
    }
    
    public void registerRight(double v) {
        v = Double.valueOf(df.format(v));
        Login(false);
        layout.setComponentConstraints(title, "pad 0 -" +v+ "% 0 0");
        layout.setComponentConstraints(description, "pad 0 -" +v+ "% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -" +v+ "% 0 0");
    }
    
    public void LoginLeft(double v) {
        v = Double.valueOf(df.format(v));
        Login(true);
        layout.setComponentConstraints(title, "pad 0 " +v+ "% 0 " +v+ "%");
        layout.setComponentConstraints(description, "pad 0 -" +v+ "% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -" +v+ "% 0 0");
    }
    
    public void LoginRight(double v) {
        v = Double.valueOf(df.format(v));
        Login(true);
        layout.setComponentConstraints(title, "pad 0 " +v+ "% 0 " +v+ "%");
        layout.setComponentConstraints(description, "pad 0 -" +v+ "% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -" +v+ "% 0 0");
    }
    
    private void Login(boolean login) {
        if(this.islogin != login) {
            if(login) {
                title.setText("Hello Friend!");
                description.setText("Enter your personal information");
                description1.setText("and start a journey with us");
                button.setText("SIGN UP");
            } else {
                title.setText("Welcome Back!");
                description.setText("To keep connected with us please");
                description1.setText("login with your personal information");
                button.setText("SIGN IN");
            }
            this.islogin = login;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
