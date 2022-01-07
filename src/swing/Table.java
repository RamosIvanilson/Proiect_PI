
package swing;

import com.raven.table.TableCustom;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import scroll.ScrollBarCustom;

public class Table extends TableCustom {

    public Table() {
        
        setShowHorizontalLines(true);
        setGridColor(new Color(230,230,230));
        setRowHeight(50);
        getTableHeader().setReorderingAllowed(false);
        setBorder(null);
        setSelectionBackground(new Color(255, 255, 255));
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        table.TableHeader header = new table.TableHeader(value + "");
                        if(column == 1) {
                            header.setHorizontalAlignment(JLabel.CENTER);
                        }
                        return header;
                    }
        });
    }
    
    public void FixTable(JScrollPane scroll) {
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
    }
    
    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        
        Component com = super.prepareRenderer(renderer, row, column);
        if(!isCellSelected(row, column)) {
            com.setBackground(new Color(255, 255, 255));
        } else{
            com.setBackground(new Color(255, 255, 255));
        }
        
        return com;
    }
    
}
