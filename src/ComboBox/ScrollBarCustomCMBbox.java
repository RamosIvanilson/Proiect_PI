package ComboBox;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;
import scroll.ModernScrollBarUI;

public class ScrollBarCustomCMBbox extends JScrollBar {

    public ScrollBarCustomCMBbox() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setForeground(new Color(150, 150, 150));
        setOpaque(false);
    }
}
