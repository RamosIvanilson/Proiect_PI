
package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// To disable mouse event

public class TextArea extends JTextArea{

    public TextArea() {
        setEditable(true);
        setFocusable(true);
        setWrapStyleWord(true);
        setLineWrap(true);
        setFont(new Font("sansserif", 1, 16));
    }
    
}
