
package StudentModels;

public class ModelLogin {
    
    String Email;
    String password;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ModelLogin(String usernameORemail, String password) {
        this.Email = usernameORemail;
        this.password = password;
    }

    public ModelLogin() {
    }
    
}
