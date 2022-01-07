
package StudentModels;

import javax.swing.*;

public class Model_CardApplication {
    Icon icon;
    String title;
    String description;
    String email;

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Model_CardApplication(Icon icon, String title, String description, String email) {
        this.icon = icon;
        this.title = title;
        this.description = description;
        this.email = email;
    }
    
    public Model_CardApplication() {
    }
    
}
