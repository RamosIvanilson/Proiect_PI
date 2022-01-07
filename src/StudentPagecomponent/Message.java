
package StudentPagecomponent;

import com.sun.net.httpserver.Authenticator;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Message extends javax.swing.JPanel {
    
    private messageType Mtype = messageType.Success;
    private boolean show;

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
    
    public Message() {
        initComponents();
        setOpaque(false);
        setVisible(false);
    }
    
    public void ShowMessage(messageType Mtype, String message) {
        this.Mtype = Mtype;
        lbmessage.setText(message);
        if(Mtype == messageType.Success) {
            lbmessage.setIcon(new ImageIcon(getClass().getResource("/icon/success.png")));
        } else {
            lbmessage.setIcon(new ImageIcon(getClass().getResource("/icon/error.png")));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbmessage = new javax.swing.JLabel();

        lbmessage.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbmessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbmessage.setText("TEST");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbmessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbmessage, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        if(Mtype == messageType.Success) {
            g2.setColor(new Color(15, 174, 37));
        } else {
            g2.setColor(new Color(240, 52, 23));
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setComposite(AlphaComposite.SrcOver);
        g2.setColor(new Color(245, 245, 245));
        g2.drawRect(0, 0, getWidth()-1, getHeight()-1);
        super.paintComponent(g);
    }
    
    public static enum messageType {
        Success, ERROR;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbmessage;
    // End of variables declaration//GEN-END:variables
}
