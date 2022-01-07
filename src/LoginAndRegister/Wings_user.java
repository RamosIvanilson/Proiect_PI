package LoginAndRegister;

import java.awt.Color;
import swing.WrapLayout;




public class Wings_user extends javax.swing.JFrame {
    

  
    public Wings_user(){
        initComponents();
        
    }

    
    public void set_books_to_Panel(){
        
    }
    
     
     public void set_to_panel(){
         //panelD.setBackground(Color.BLUE);
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroud_panel1 = new Backgroud_panel();
        jPanel1 = new javax.swing.JPanel();
        panelD = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        romance = new javax.swing.JLabel();
        action = new javax.swing.JLabel();
        fiction = new javax.swing.JLabel();
        mystery = new javax.swing.JLabel();
        historical = new javax.swing.JLabel();
        classic = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel_central = new javax.swing.JPanel();
        search_butoon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(37, 41, 88));

        panelD.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout panelDLayout = new javax.swing.GroupLayout(panelD);
        panelD.setLayout(panelDLayout);
        panelDLayout.setHorizontalGroup(
            panelDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );
        panelDLayout.setVerticalGroup(
            panelDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(37, 41, 88));

        jLabel2.setBackground(new java.awt.Color(52, 45, 113));
        jLabel2.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Category");
        jLabel2.setOpaque(true);

        romance.setBackground(new java.awt.Color(37, 41, 88));
        romance.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        romance.setForeground(new java.awt.Color(44, 130, 201));
        romance.setText("Romance");
        romance.setOpaque(true);
        romance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                romanceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                romanceMouseExited(evt);
            }
        });

        action.setBackground(new java.awt.Color(37, 41, 88));
        action.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        action.setForeground(new java.awt.Color(44, 130, 201));
        action.setText("Action and Adventure");
        action.setOpaque(true);
        action.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                actionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                actionMouseExited(evt);
            }
        });

        fiction.setBackground(new java.awt.Color(37, 41, 88));
        fiction.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        fiction.setForeground(new java.awt.Color(44, 130, 201));
        fiction.setText("Literary Fiction");
        fiction.setOpaque(true);
        fiction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fictionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fictionMouseExited(evt);
            }
        });

        mystery.setBackground(new java.awt.Color(37, 41, 88));
        mystery.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        mystery.setForeground(new java.awt.Color(44, 130, 201));
        mystery.setText("Detective and Mystery");
        mystery.setOpaque(true);
        mystery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mysteryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mysteryMouseExited(evt);
            }
        });

        historical.setBackground(new java.awt.Color(37, 41, 88));
        historical.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        historical.setForeground(new java.awt.Color(44, 130, 201));
        historical.setText("Historical Fiction");
        historical.setOpaque(true);
        historical.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                historicalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                historicalMouseExited(evt);
            }
        });

        classic.setBackground(new java.awt.Color(37, 41, 88));
        classic.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        classic.setForeground(new java.awt.Color(44, 130, 201));
        classic.setText("Classics");
        classic.setOpaque(true);
        classic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                classicMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                classicMouseExited(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(52, 45, 113));
        jLabel3.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Favoritos");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(52, 45, 113));
        jLabel4.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("My Library");
        jLabel4.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(romance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(action, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiction, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mystery, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historical, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(romance, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(action, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fiction, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mystery, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(historical, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classic, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(291, Short.MAX_VALUE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel_central.setBackground(new java.awt.Color(37, 41, 88));

        javax.swing.GroupLayout panel_centralLayout = new javax.swing.GroupLayout(panel_central);
        panel_central.setLayout(panel_centralLayout);
        panel_centralLayout.setHorizontalGroup(
            panel_centralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );
        panel_centralLayout.setVerticalGroup(
            panel_centralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 778, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel_central);

        search_butoon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-search-48 (1).png"))); // NOI18N
        search_butoon.setBorder(null);
        search_butoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_butoonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(search_butoon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search_butoon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(panelD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout backgroud_panel1Layout = new javax.swing.GroupLayout(backgroud_panel1);
        backgroud_panel1.setLayout(backgroud_panel1Layout);
        backgroud_panel1Layout.setHorizontalGroup(
            backgroud_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backgroud_panel1Layout.setVerticalGroup(
            backgroud_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroud_panel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroud_panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroud_panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void romanceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_romanceMouseEntered
        romance.setBackground(new Color(8, 14, 44));
    }//GEN-LAST:event_romanceMouseEntered

    private void romanceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_romanceMouseExited
        romance.setBackground(new Color(37,41,88));
    }//GEN-LAST:event_romanceMouseExited

    private void actionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actionMouseEntered
        action.setBackground(new Color(8, 14, 44));
    }//GEN-LAST:event_actionMouseEntered

    private void actionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actionMouseExited
        action.setBackground(new Color(37,41,88));
    }//GEN-LAST:event_actionMouseExited

    private void fictionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fictionMouseEntered
        fiction.setBackground(new Color(8, 14, 44));
    }//GEN-LAST:event_fictionMouseEntered

    private void fictionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fictionMouseExited
        fiction.setBackground(new Color(37,41,88));
    }//GEN-LAST:event_fictionMouseExited

    private void mysteryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mysteryMouseEntered
        mystery.setBackground(new Color(8, 14, 44));
    }//GEN-LAST:event_mysteryMouseEntered

    private void mysteryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mysteryMouseExited
        mystery.setBackground(new Color(37,41,88));
    }//GEN-LAST:event_mysteryMouseExited

    private void historicalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historicalMouseEntered
        historical.setBackground(new Color(8, 14, 44));
    }//GEN-LAST:event_historicalMouseEntered

    private void historicalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historicalMouseExited
        historical.setBackground(new Color(37,41,88));
    }//GEN-LAST:event_historicalMouseExited

    private void classicMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classicMouseEntered
        classic.setBackground(new Color(8, 14, 44));
    }//GEN-LAST:event_classicMouseEntered

    private void classicMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classicMouseExited
        classic.setBackground(new Color(37,41,88));
    }//GEN-LAST:event_classicMouseExited

    private void search_butoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_butoonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_butoonActionPerformed

    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wings_user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel action;
    private Backgroud_panel backgroud_panel1;
    private javax.swing.JLabel classic;
    private javax.swing.JLabel fiction;
    private javax.swing.JLabel historical;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel mystery;
    private javax.swing.JPanel panelD;
    private javax.swing.JPanel panel_central;
    private javax.swing.JLabel romance;
    private javax.swing.JButton search_butoon;
    // End of variables declaration//GEN-END:variables
}
