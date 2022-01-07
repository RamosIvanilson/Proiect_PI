
package StudentModels;

import com.raven.table.model.TableRowData;

public class ModelStaff extends TableRowData{
    
    ModelName scholarship;

    public ModelName getScholarship() {
        return scholarship;
    }

    public void setScholarship(ModelName scholarship) {
        this.scholarship = scholarship;
    }

    public ModelStaff() {
    }

    public ModelStaff(ModelName name) {
        this.scholarship = name;
    }
    
    @Override
    public Object[] toTableRow() {
        return new Object[]{scholarship};
    }
    
}
