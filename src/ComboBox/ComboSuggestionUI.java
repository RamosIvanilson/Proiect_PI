
package ComboBox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class ComboSuggestionUI extends BasicComboBoxUI{

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        Border border = new Border();
        JTextField txt = (JTextField)comboBox.getEditor().getEditorComponent();
        txt.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                border.setColor(new Color(128, 189, 255));
            }

            @Override
            public void focusLost(FocusEvent e) {
                border.setColor(new Color(206, 212, 218));
            }
            
        });
        comboBox.addPopupMenuListener(new PopupMenuListener(){
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                arrowButton.setBackground(new Color(180, 180, 180));
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                arrowButton.setBackground(new Color(150, 150, 150));
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                arrowButton.setBackground(new Color(150, 150, 150));
            }
            
        });
        AutoCompleteDecorator.decorate(comboBox);
        txt.setSelectionColor(new Color(54, 189, 248));
        txt.setBorder(new EmptyBorder(0, 4, 0, 4));
        comboBox.setBackground(Color.WHITE);
        comboBox.setBorder(border);
        
    }

    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
       
    }

    @Override
    protected ComboPopup createPopup() {
        return new ComboSuggestionPopup(comboBox);
    }
    
    @Override
    protected ListCellRenderer createRenderer() {
        return new ListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList jlist, Object e, int i, boolean bln, boolean bln1) {
                String text = e == null ? "" : e.toString();
                JLabel label = new JLabel(text);
                label.setFont(comboBox.getFont());
                if(i >= 0) {
                    label.setBorder(new EmptyBorder(5, 8, 5, 8));
                } else {
                    label.setBorder(null);
                }
                
                if(bln) {
                    label.setOpaque(true);
                    label.setBackground(new Color(240, 240, 240));
                    label.setForeground(new Color(17, 155, 215));
                }
                return label;
            }
            
        };
    }
    
    private class ComboSuggestionPopup extends BasicComboPopup{

        public ComboSuggestionPopup(JComboBox combo) {
            super(combo);
            setBorder(new Border());
        }

        @Override
        protected JScrollPane createScroller() {
            JScrollPane scroll = super.createScroller();
            list.setBackground(Color.WHITE);
            ScrollBarCustomCMBbox sb = new ScrollBarCustomCMBbox();
            sb.setPreferredSize(new Dimension(9, 20));
            scroll.setVerticalScrollBar(sb);
            scroll.getVerticalScrollBar().setUnitIncrement(16);
            return scroll;
        }
        
        
    }
    
    @Override
    protected JButton createArrowButton() {
        return new ArrowButton();
    }
    
    private class ArrowButton extends JButton {

        public ArrowButton() {
            setContentAreaFilled(false);
            setBorder(new EmptyBorder(5, 5, 5, 5));
            setBackground(new Color(150, 150, 150));
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2 = (Graphics2D)g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int width = getWidth();
            int height = getHeight();
            int sizeX = 12;
            int sizeY = 8;
            int x = (width - sizeX)/2;
            int y = (height - sizeY)/2;
            int px[] = {x, x + sizeX, x + sizeX / 2};
            int py[] = {y, y, y + sizeY};
            g2.setColor(getBackground());
            g2.fillPolygon(px, py,px.length);
            
            g2.dispose();
        }
        
    }
    
    private class Border extends EmptyBorder {
        
        private Color focuscolor = new Color(128, 189, 255);
        private Color color = new Color(206, 212, 218);

        public Color getFocuscolor() {
            return focuscolor;
        }

        public void setFocuscolor(Color focuscolor) {
            this.focuscolor = focuscolor;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
        
        public Border(int border) {
            super(border, border, border, border);
        }

        public Border() {
            this(5);
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D)g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if(c.isFocusOwner()) {
                g2.setColor(focuscolor);
            } else {
                g2.setColor(color);
            }
            g2.drawRect(x, y, width - 1, height - 1);
            g2.dispose();
        }
        
    }
    
}
