
package StudentPagecomponent;

import event.MenuEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import scroll.ScrollBarCustom;
import swing.MenuButton;
import swing.Split;

public class MenuStudent extends javax.swing.JPanel {

    private Animator animator;
    private MenuButton unselectedMenu;
    private MenuButton selectedMenu;
    private MenuEvent event;
    
    public MenuStudent() {
        initComponents();
        setOpaque(false);
        scroll.setViewportBorder(null);
        scroll.setBorder(null);
        scroll.getViewport().setOpaque(false);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        paneMenu.setLayout(new MigLayout("wrap, fillx, inset 0", "[fill]"));
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                
                selectedMenu.setAnimate(fraction);
                if(unselectedMenu != null) {
                    unselectedMenu.setAnimate(1f - fraction);
                }
            }
        };
        animator = new Animator(300, target);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        animator.setResolution(0);
        
    }
    
    public void initMenu(MenuEvent evt) {
        this.event = evt;
        addMenu("1", "My Profile", 1);
        addMenu("2", "My Applications", 2);
        addMenu("3", "Interested", 3);
        addMenu("4", "Scholarships", 0);
        space();
        addMenu("keey", "Logout", 6);
    }
    
    private void addMenu(String icon, String text, int index) {
        MenuButton menu = new MenuButton(index);
        menu.setFont(new Font("sansserif", 0, 14));
        menu.setIcon(new ImageIcon(getClass().getResource("/icon/"+icon+".png")));
        menu.setText("  " + text);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!animator.isRunning()) {
                    if(menu != selectedMenu) {
                        unselectedMenu = selectedMenu;
                        selectedMenu = menu;
                        animator.start();
                        event.SelectedMenu(index);
                    }
                }
            }
            
        });
        paneMenu.add(menu);
    }
    
    private void split(String name) {
        paneMenu.add(new Split(name), "h 30");
    }
    
    private void space(){
        paneMenu.add(new JLabel(), "push");
    }
    public void setSelected(int index) {
        for(Component com: paneMenu.getComponents()) {
            if(com instanceof MenuButton) {
                
                MenuButton menu = (MenuButton) com;
            
                if(menu.getIndex() == index) {
                    if(menu != selectedMenu) {
                        unselectedMenu = selectedMenu;
                        selectedMenu = menu;
                        animator.start();
                        event.SelectedMenu(index);
                    }
                    
                    break;
                }
            }
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new swing.ImageAvatar();
        scroll = new javax.swing.JScrollPane();
        paneMenu = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        imageAvatar1.setBackground(new java.awt.Color(51, 51, 51));
        imageAvatar1.setBorderSize(3);
        imageAvatar1.setBorderSpace(2);
        imageAvatar1.setGradientColor1(new java.awt.Color(255, 255, 255));
        imageAvatar1.setGradientColor2(new java.awt.Color(255, 255, 255));
        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/LRlogo(1).png"))); // NOI18N

        scroll.setBackground(new java.awt.Color(41, 41, 41));
        scroll.setBorder(null);
        scroll.setForeground(new java.awt.Color(255, 255, 255));

        paneMenu.setBackground(new java.awt.Color(255, 255, 255));
        paneMenu.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout paneMenuLayout = new javax.swing.GroupLayout(paneMenu);
        paneMenu.setLayout(paneMenuLayout);
        paneMenuLayout.setHorizontalGroup(
            paneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        paneMenuLayout.setVerticalGroup(
            paneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        scroll.setViewportView(paneMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scroll)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(scroll))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ImageAvatar imageAvatar1;
    private javax.swing.JPanel paneMenu;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
