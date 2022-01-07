package LoginAndRegister;

import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;

public class book_icon extends javax.swing.JPanel {

    public String title;
    public String autor;
    public String sinopse;
    public String category;
    public String info;
    public int code;
    public File book;
    public String fpath;
    
    public book_icon() {
        initComponents();
    }
    
    public void setData(String title, String author, String sinopse, String category, String info, int code, File book){
        this.title = title;
        this.autor = author;
        this.sinopse = sinopse;
        this.category = category;
        this.info = info;
        this.code = code;
        this.book = book;
        lb_Title.setText(this.title);
        lb_Code.setText("Code:"+Integer.toString(this.code));
    }
    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lb_Code = new javax.swing.JLabel();
        lb_Title = new javax.swing.JLabel();

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swing/moana.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lb_Code.setBackground(new java.awt.Color(255, 255, 255));
        lb_Code.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_Code.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Code.setOpaque(true);

        lb_Title.setBackground(new java.awt.Color(0, 0, 0));
        lb_Title.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        lb_Title.setForeground(new java.awt.Color(255, 255, 255));
        lb_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Title.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, Short.MAX_VALUE)
            .addComponent(lb_Code, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lb_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lb_Code, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
           
            if(this.book.exists()){
                if(Desktop.isDesktopSupported()){
                    Desktop.getDesktop().open(this.book);
                }else{
                    JOptionPane.showMessageDialog(this,"Desktop is not suported");
                }
            }else{
                JOptionPane.showMessageDialog(this,"File dosent exist!");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lb_Code;
    private javax.swing.JLabel lb_Title;
    // End of variables declaration//GEN-END:variables
}
