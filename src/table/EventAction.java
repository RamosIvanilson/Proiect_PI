
package table;

import StudentModels.ModelName;

public interface EventAction {
    public void delete(ModelName model);
    
    public void addCell(ModelName model);
    
    public void showCell(ModelName model);
}
