
package UniversityPagesComponents;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;
import StudentModels.Model_CardSaves;

public class CardPanelEditSch extends javax.swing.JPanel {

    private final Model_CardSaves data;
    private final Timer timer;
    private final Timer timerstop;
    private final CardDescriptionEditscholarship cardDescription;
    private int y = 240;
    private int speed = 2;
    private boolean showing = false;
    
    public CardPanelEditSch(Model_CardSaves data) {
        this.data = data;
        initComponents();
        delete.setLocation(800, 12);
        setOpaque(false);
        cardDescription = new CardDescriptionEditscholarship(data.getTitle(), data.getDescription(), data.getEmail());
        cardDescription.setLocation(0, y);
        setPreferredSize(new Dimension(850, 323));
        cardDescription.setSize(new Dimension(850, 150));
        add(cardDescription);
        timer = new Timer(0, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(showing) {
                    y -= speed;
                    if(y <= 200) {
                        y = 200;
                        cardDescription.setLocation(0, y);
                        timer.stop();
                    } else {
                        cardDescription.setLocation(0, y);
                    }
                } else {
                    y += speed;
                    if(y >= 240) {
                        y = 240;
                        cardDescription.setLocation(0, y);
                        timer.stop();
                    } else {
                        cardDescription.setLocation(0, y);
                    }
                }
            }
            
        });
        timerstop = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                showing = false;
                timerstop.stop();
                timer.start();
            }
            
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                showing = true;
                timerstop.stop();
                timer.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                timerstop.start();
            }
            
        });
        
    }
    
    public void visible() {
        setVisible(false);
    }
    
    //TO draw the image
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        Rectangle size = getAutosize(data.getIcon());
        g2.drawImage(toImage(data.getIcon()), size.x, size.y, size.width, size.height, null);
        super.paintComponent(g);
    }
    
    //For the Style color
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, getHeight(), new Color(255, 255, 255, 200), 0, getHeight()-50, new Color(0,0,0,0));
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
    
    private Rectangle getAutosize(Icon image) {
        int w = 864;
        int h = 323;
        int imageW = image.getIconWidth();
        int imageH = image.getIconHeight();
        double xscale = (double) w / imageW;
        double yscale = (double) h / imageH;
        double scale = Math.max(xscale, yscale);
        int width = (int)(scale*imageW);
        int heigth = (int)(scale*imageH);
        int x = (w-width)/2;
        int y = (h-heigth)/2;
        
        return new Rectangle(new Point(x, y), new Dimension(width, heigth));
    }
    
    private Image toImage( Icon icon) {
        return ((ImageIcon)icon).getImage();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        delete = new swing.Button();

        setLayout(null);

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete2.png"))); // NOI18N
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        add(delete);
        delete.setBounds(360, 0, 40, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        
        int response = JOptionPane.showConfirmDialog(this, "Delete?", "", JOptionPane.YES_NO_OPTION);
        if(response == JOptionPane.YES_OPTION) {
            Delete(this.data.getTitle(), this.data.getDescription());
            setVisible(false);
        } else if(response == JOptionPane.NO_OPTION) {
            
        }
    }//GEN-LAST:event_deleteActionPerformed
    
    private void Delete(String university, String denomination) {
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/piproject?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            String sql = "DELETE FROM scholarships WHERE denomination='"+denomination+"' and university='"+university+"'";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            stm.close();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button delete;
    // End of variables declaration//GEN-END:variables
}
