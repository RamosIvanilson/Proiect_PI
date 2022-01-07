
package StudentServices;

import connection.DatabaseConnection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Random;
import StudentModels.ModelLogin;
import StudentModels.ModelUser;

public class ServiceUser {
    
    private final Connection con;
    private int userid;
    public ServiceUser() {
        con = DatabaseConnection.getInstance().getConnection();
        
    }
    
    public ModelUser login(ModelLogin login) throws SQLException {
        
        ModelUser data = null;
        PreparedStatement ps = con.prepareStatement("SELECT userid, email FROM `students` WHERE BINARY(email)=? and BINARY(`password`)=? and `status`='verified' limit 1");
        ps.setString(1, login.getEmail());
        ps.setString(2, login.getPassword());
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            int userID = rs.getInt(1);
            this.userid = userID;
            String email = rs.getString(2);
            data = new ModelUser(userID, email, "");
        }
        rs.close();
        ps.close();
        
        return data;
    }
    
    public int getUserID() {
        return this.userid;
    }
    
    public void insertuser(ModelUser user) throws SQLException{
        
        PreparedStatement pS = con.prepareStatement("INSERT INTO `students` (firstname, lastname, email, password, verifycode) VALUES(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
        String code = generateVerifyCode();        
        pS.setString(1, user.getFirstname());
        pS.setString(2, user.getLastname());
        pS.setString(3, user.getEmail());
        pS.setString(4, user.getPassword());
        pS.setString(5, code);
        pS.execute();
        ResultSet rs = pS.getGeneratedKeys();
        rs.next();
        int userId = rs.getInt(1);
        rs.close();
        pS.close();
        user.setUserID(userId);
        user.setVerifyCode(code);
    }
    
    private String generateVerifyCode() throws SQLException {
        DecimalFormat df = new DecimalFormat("000000");
        Random random = new Random();
        String code = df.format(random.nextInt(1000000)); //Random from 0 to 999999
        while(CheckDuplicateCode(code)) {
            code = df.format(random.nextInt(1000000));
            
        }
        return code;
    }
    private boolean CheckDuplicateCode(String code) throws SQLException{
        boolean duplicate = false;
        PreparedStatement ps = con.prepareStatement("SELECT `userid` FROM `students` WHERE verifycode=? limit 1");
        ps.setString(1, code);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            duplicate = true;
        }
        rs.close();
        ps.close();
        
        return duplicate;
    }
    
    
    public boolean checkDuplicateEmail(String user) throws SQLException{
        boolean duplicate = false;
        PreparedStatement ps = con.prepareStatement("SELECT `userid` FROM `students` WHERE email=? and `status`='verified' limit 1");
        ps.setString(1, user);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            duplicate = true;
        }
        rs.close();
        ps.close();
        
        return duplicate;
    }
    
    public void doneVerify(int userID) throws SQLException{
        PreparedStatement ps = con.prepareStatement("UPDATE `students` SET `verifycode`='', `status`='verified' WHERE userid=? limit 1");
        ps.setInt(1, userID);
        ps.execute();
        ps.close();
    }
    
    public boolean VerifyCodeWithUser(int userID, String code) throws SQLException{
        boolean verify = false;
        PreparedStatement ps = con.prepareStatement("SELECT userid FROM `students` WHERE userid=? and verifycode=? limit 1");
        ps.setInt(1, userID);
        ps.setString(2, code);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            verify = true;
        }
        rs.close();
        ps.close();
        
        return verify;
    }
    
    public void editPerfil(int userID, String firstname, String lastname, String email, String birthdate, String birthplace, String phone, String gender, String nationality, String adress) throws SQLException{
        PreparedStatement ps = con.prepareStatement("UPDATE `studentsprofile` SET firstname='"+firstname+"', lastname='"+lastname+"', birthdate='"+birthdate+"', birthplace='"+birthplace+"', email='"+email+"', phone='"+phone+"', gender='"+gender+"', nationality='"+nationality+"', adress='"+adress+"' WHERE userid='"+userID+"' limit 1");
        ps.execute();
        ps.close();
        
    }
    
    public void insertUserSP(int userID, String fname, String lname, String email) throws SQLException, FileNotFoundException{
        
        PreparedStatement pS = con.prepareStatement("INSERT INTO `studentsprofile` (userid, profileimage, firstname, lastname, email) VALUES(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
        pS.setInt(1, userID);
        pS.setBinaryStream(2, new FileInputStream("C:\\Users\\THINKPAD\\Documents\\NetBeansProjects\\PI\\src\\icon\\profileIcon.png"));
        pS.setString(3, fname);
        pS.setString(4, lname);
        pS.setString(5, email);
        pS.execute();
        ResultSet rS = pS.getGeneratedKeys();
        rS.next();
        rS.close();
        pS.close();
        
    }
    
}
