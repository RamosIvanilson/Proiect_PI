
package StudentPagecomponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import StudentModels.Model_CardApplication;

public class CardPanelApplication extends javax.swing.JPanel {

    private final Model_CardApplication data;
    private final Timer timer;
    private final Timer timerstop;
    private final CardDescriptionApplication cardDescription;
    private int y = 240;
    private int speed = 2;
    private boolean showing = false;
    
    public CardPanelApplication(Model_CardApplication data) {
        this.data = data;
        initComponents();
        setOpaque(false);
        cardDescription = new CardDescriptionApplication(data.getTitle(), data.getDescription(), data.getEmail());
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

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
