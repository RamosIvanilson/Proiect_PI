
package table;

import StudentModels.ModelName;

public class ModelAction {
    private ModelName model;
    private EventAction event;

    public ModelName getModel() {
        return model;
    }

    public void setModel(ModelName model) {
        this.model = model;
    }

    public EventAction getEvent() {
        return event;
    }

    public void setEvent(EventAction event) {
        this.event = event;
    }

    public ModelAction(ModelName model, EventAction event) {
        this.model = model;
        this.event = event;
    }

    public ModelAction() {
    }
    
    
}
