
package cell;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import StudentModels.ModelName;
import StudentModels.ModelStaff;

public class SecondDescription extends TableCustomCell{
    
    public SecondDescription() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        coursestart = new javax.swing.JLabel();
        phonenumber = new javax.swing.JLabel();
        email = new javax.swing.JLabel();

        coursestart.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        coursestart.setForeground(new java.awt.Color(200, 200, 200));

        phonenumber.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        phonenumber.setForeground(new java.awt.Color(200, 200, 200));

        email.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        email.setForeground(new java.awt.Color(200, 200, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coursestart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phonenumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(coursestart, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void setdata(String sch) {

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/piproject?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            
            //Get emails from table
            Statement stm = con.createStatement();
            String sql = "SELECT `coursestart`, `email`, `phonenumber` FROM `scholarships` WHERE `scholarship` LIKE '"+sch+"'";
            stm.execute(sql);
            ResultSet rs = stm.executeQuery(sql);
            
            //check for each email if its equal with the user inputed email
            if(rs.next()) {
                //the emails from the database
                String CourseStart = rs.getString("coursestart");
                String Email = rs.getString("email");
                String Phonenumber = rs.getString("phonenumber");
                coursestart.setText("   Course starts at: " + CourseStart);
                email.setText("   Email: " + Email);
                phonenumber.setText("   Phone: " + Phonenumber);
            }
            
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }    
    }
    
    @Override
    public void setData(Object o) {
        if(o != null) {
            if(o instanceof ModelName) {
                ModelName sch = (ModelName)o;
                setdata(sch.getScholarship());
            }
        }
    }
    
    @Override
    public Object getData() {
        return true;
    }
    
    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        SecondDescription cell = new SecondDescription();
        cell.setData(o);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel coursestart;
    private javax.swing.JLabel email;
    private javax.swing.JLabel phonenumber;
    // End of variables declaration//GEN-END:variables

}
