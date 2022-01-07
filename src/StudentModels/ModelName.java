
package StudentModels;

public class ModelName {
    String scholarship;

    public ModelName(String scholarship) {
  
        this.scholarship = scholarship;

    }

    public ModelName() {
    }
    

    public String getScholarship() {
        return scholarship;
    }

    public void setScholarship(String scholarship) {
        this.scholarship = scholarship;
    }

    @Override
    public String toString() {
        return scholarship;
    }
    
}
