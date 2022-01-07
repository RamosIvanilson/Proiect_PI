
package StudentModels;

public class ModelUser {
    
    int userID;
    String firstname;
    String lastname;
    String email;
    String password;
    String verifyCode;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
    
    public ModelUser(int userID, String firstname, String lastname, String email) {
        this.userID = userID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
    
    public ModelUser(int userID, String firstname, String lastname, String email, String password) {
        this.userID = userID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
    
    public ModelUser(int userID, String firstname, String lastname, String username, String email, String password, String verifyCode) {
        this.userID = userID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.verifyCode = verifyCode;
    }
    
    public ModelUser(int userID, String email, String password) {
        this.userID = userID;
        this.email = email;
        this.password = password;
    }
    
    public ModelUser() {
    }
    
}
