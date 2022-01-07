
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

public class FirstDescription extends TableCustomCell{
    
    public FirstDescription() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        university = new javax.swing.JLabel();
        degree = new javax.swing.JLabel();
        deadline = new javax.swing.JLabel();
        country = new javax.swing.JLabel();
        coursestart = new javax.swing.JLabel();

        university.setFont(new java.awt.Font("Tahoma", 2, 15)); // NOI18N
        university.setForeground(new java.awt.Color(51, 51, 51));

        degree.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        degree.setForeground(new java.awt.Color(51, 51, 51));

        deadline.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        deadline.setForeground(new java.awt.Color(51, 51, 51));

        country.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        country.setForeground(new java.awt.Color(51, 51, 51));

        coursestart.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        coursestart.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(degree, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(university, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(coursestart, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(deadline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(country, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deadline, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(university, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(degree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(country, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(coursestart, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void setdata(String sch) {

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/piproject?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            
            //Get emails from table
            Statement stm = con.createStatement();
            String sql = "SELECT `country`, `university`, `degree`, `deadline`, `coursestart` FROM `scholarships` WHERE scholarship LIKE '"+sch+"'";
            stm.execute(sql);
            ResultSet rs = stm.executeQuery(sql);
            
            //check for each email if its equal with the user inputed email
            while(rs.next()) {
                //the data from database
                String cou = rs.getString("country");
                String uni = rs.getString("university");
                String deg = rs.getString("degree");
                String dea = rs.getString("deadline");
                String course = rs.getString("coursestart");
                country.setText("Country: " + cou);
                university.setText(" " + uni);
                degree.setText(" " + deg);
                deadline.setText("Deadline: " + dea);
                coursestart.setText("Course starts: " + course);
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
        return null;
    }

    @Override
    public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
        ModelStaff university = (ModelStaff)data;
        return new CellNameRender(university.getScholarship());
    }
    
    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        FirstDescription cell = new FirstDescription();
        cell.setData(o);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel country;
    private javax.swing.JLabel coursestart;
    private javax.swing.JLabel deadline;
    private javax.swing.JLabel degree;
    private javax.swing.JLabel university;
    // End of variables declaration//GEN-END:variables

}
