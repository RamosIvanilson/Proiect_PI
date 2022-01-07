
package swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MenuButton extends JButton{
    
    private float animate;
    private int index;
    
    public float getAnimate() {
        return animate;
    }

    public void setAnimate(float animate) {
        this.animate = animate;
        repaint();
    }

    public int getIndex() {
        return index;
    }
    
    public MenuButton(int index) {
        this.index = index;
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setHorizontalAlignment(SwingConstants.LEFT);
        setForeground(new Color(102,102,102));
        setBackground(new Color(65,65,65));
        setBorder(new EmptyBorder(8, 20, 8, 15));
        addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
//                setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                setForeground(new Color(107,23,230));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                setForeground(new Color(107,23,230));
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                setForeground(new Color(255, 255, 255));
            }
        });
    }
    
    @Override
    public void paint(Graphics g) {
        
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double width = getWidth();
        double height = getHeight();
        double x = animate * width - width;
        Area area = new Area(new RoundRectangle2D.Double(x, 0, width, height, height, height));
        area.add(new Area(new Rectangle2D.Double(x, 0, height, height)));
        g2.setColor(new Color(238,242,245));
        g2.fill(area);
        g2.dispose();
        super.paint(g);
        
    }
    
    
}
