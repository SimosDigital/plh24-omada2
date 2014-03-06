package webmarket;

/**
 * @author Petter Sellers ( User_Checks )
 */

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import model.Customer;

public class UserChecks extends javax.swing.JFrame {

    /**
     * Creates new form UserChecks
     */
    
    private static EntityManager em;

    Customer logedUser;
    
    public UserChecks() {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebMarketPU");
         em = emf.createEntityManager();        
         initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        logedUserText2 = new javax.swing.JTextField();
        WebMarketPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("WebMarketPU").createEntityManager();
        customerQuery = java.beans.Beans.isDesignTime() ? null : WebMarketPUEntityManager.createQuery("SELECT c FROM Customer c");
        customerList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : customerQuery.getResultList();
        bonusCheckQuery = java.beans.Beans.isDesignTime() ? null : WebMarketPUEntityManager.createQuery("SELECT b FROM BonusCheck b");
        bonusCheckList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : bonusCheckQuery.getResultList();
        customerQuery1 = java.beans.Beans.isDesignTime() ? null : WebMarketPUEntityManager.createQuery("SELECT c FROM Customer c");
        customerList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : customerQuery1.getResultList();
        bonusCheckQuery1 = java.beans.Beans.isDesignTime() ? null : WebMarketPUEntityManager.createQuery("SELECT b FROM BonusCheck b");
        bonusCheckList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : bonusCheckQuery1.getResultList();
        bonusCheckQuery2 = java.beans.Beans.isDesignTime() ? null : WebMarketPUEntityManager.createQuery("SELECT b FROM BonusCheck b");
        bonusCheckList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : bonusCheckQuery2.getResultList();
        bonusCheckQuery3 = java.beans.Beans.isDesignTime() ? null : WebMarketPUEntityManager.createQuery("SELECT b FROM BonusCheck b");
        bonusCheckList3 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : bonusCheckQuery3.getResultList();
        bonusCheckQuery4 = java.beans.Beans.isDesignTime() ? null : WebMarketPUEntityManager.createQuery("SELECT b FROM BonusCheck b");
        bonusCheckList4 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : bonusCheckQuery4.getResultList();
        bonusCheckQuery5 = java.beans.Beans.isDesignTime() ? null : WebMarketPUEntityManager.createQuery("SELECT b FROM BonusCheck b");
        bonusCheckList5 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : bonusCheckQuery5.getResultList();
        bonusCheckQuery6 = java.beans.Beans.isDesignTime() ? null : WebMarketPUEntityManager.createQuery("SELECT b FROM BonusCheck b");
        bonusCheckList6 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : bonusCheckQuery6.getResultList();
        bonusCheckQuery7 = java.beans.Beans.isDesignTime() ? null : WebMarketPUEntityManager.createQuery("SELECT b FROM BonusCheck b");
        bonusCheckList7 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : bonusCheckQuery7.getResultList();
        bonusCheckQuery8 = java.beans.Beans.isDesignTime() ? null : WebMarketPUEntityManager.createQuery("SELECT b FROM BonusCheck b");
        bonusCheckList8 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : bonusCheckQuery8.getResultList();
        bonusCheckQuery9 = java.beans.Beans.isDesignTime() ? null : WebMarketPUEntityManager.createQuery("SELECT b FROM BonusCheck b");
        bonusCheckList9 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : bonusCheckQuery9.getResultList();
        bonusCheckQuery10 = java.beans.Beans.isDesignTime() ? null : WebMarketPUEntityManager.createQuery("SELECT b FROM BonusCheck b");
        bonusCheckList10 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : bonusCheckQuery10.getResultList();
        jLabel1 = new javax.swing.JLabel();
        logedUserText1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ExitButton = new javax.swing.JButton();
        logedUserText3 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        logedUserText2.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WebMarket - Διαχείριση Προφίλ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("3.1.3. Προβολή δωροεπιταγών");

        logedUserText1.setEnabled(false);

        jLabel8.setText("Όνομα");

        jLabel6.setText("Επώνυμο");

        ExitButton.setText("Επιστροφή");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        logedUserText3.setEnabled(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, bonusCheckList10, jTable2);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${checkId}"));
        columnBinding.setColumnName("Κωδικός Επιταγής");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateIn}"));
        columnBinding.setColumnName("Ημερομηνία");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${amount}"));
        columnBinding.setColumnName("Ποσό");
        columnBinding.setColumnClass(Float.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${purchase}"));
        columnBinding.setColumnName("Κατάσταση");
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(logedUserText1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(logedUserText3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logedUserText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(logedUserText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(ExitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed

        int holdExit = JOptionPane.showConfirmDialog(this, "Σίγουρα ζητήσατε επιστροφή...     ", "     WebMarket", JOptionPane.YES_NO_OPTION);

        if (holdExit != 0)
        return;   

        UserProfile userprofile = new UserProfile();
        userprofile.setLogedUser(logedUser);
        userprofile.setLocationRelativeTo(null);
        userprofile.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_ExitButtonActionPerformed

    public void setLogedUser (Customer logedUser) {
        this.logedUser = logedUser;
                      
        logedUserText1.setText(logedUser.getFirstName());
        logedUserText3.setText(logedUser.getLastName());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserChecks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserChecks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserChecks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserChecks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserChecks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.persistence.EntityManager WebMarketPUEntityManager;
    private java.util.List<model.BonusCheck> bonusCheckList;
    private java.util.List<model.BonusCheck> bonusCheckList1;
    private java.util.List<model.BonusCheck> bonusCheckList10;
    private java.util.List<model.BonusCheck> bonusCheckList2;
    private java.util.List<model.BonusCheck> bonusCheckList3;
    private java.util.List<model.BonusCheck> bonusCheckList4;
    private java.util.List<model.BonusCheck> bonusCheckList5;
    private java.util.List<model.BonusCheck> bonusCheckList6;
    private java.util.List<model.BonusCheck> bonusCheckList7;
    private java.util.List<model.BonusCheck> bonusCheckList8;
    private java.util.List<model.BonusCheck> bonusCheckList9;
    private javax.persistence.Query bonusCheckQuery;
    private javax.persistence.Query bonusCheckQuery1;
    private javax.persistence.Query bonusCheckQuery10;
    private javax.persistence.Query bonusCheckQuery2;
    private javax.persistence.Query bonusCheckQuery3;
    private javax.persistence.Query bonusCheckQuery4;
    private javax.persistence.Query bonusCheckQuery5;
    private javax.persistence.Query bonusCheckQuery6;
    private javax.persistence.Query bonusCheckQuery7;
    private javax.persistence.Query bonusCheckQuery8;
    private javax.persistence.Query bonusCheckQuery9;
    private java.util.List<model.Customer> customerList;
    private java.util.List<model.Customer> customerList1;
    private javax.persistence.Query customerQuery;
    private javax.persistence.Query customerQuery1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField logedUserText1;
    private javax.swing.JTextField logedUserText2;
    private javax.swing.JTextField logedUserText3;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}