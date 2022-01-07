
package UniversityModels;

public class ModelUniversity {
    
    int userID;
    String country;
    String university;
    String email;
    String password;
    String verifyCode;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
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

    public ModelUniversity(int userID, String country, String university, String email, String password, String verifyCode) {
        this.userID = userID;
        this.country = country;
        this.university = university;
        this.email = email;
        this.password = password;
        this.verifyCode = verifyCode;
    }
    
    public ModelUniversity(int userID, String country, String university, String email, String password) {
        this.userID = userID;
        this.country = country;
        this.university = university;
        this.email = email;
        this.password = password;
    }
    
    public ModelUniversity(int userID, String email, String password) {
        this.userID = userID;
        this.email = email;
        this.password = password;
    }
    
    public ModelUniversity() {
    }
    
}
