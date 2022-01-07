
package Application;

import com.raven.table.model.TableRowData;

public class ModelTableData extends TableRowData{
    String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public ModelTableData(String filename) {
        this.filename = filename;
    }
    
    public ModelTableData() {
    }

    @Override
    public Object[] toTableRow() {
        return new Object[]{filename};
    }
    
}
