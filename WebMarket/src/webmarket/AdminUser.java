package webmarket;

/**
 * @author Simos
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import model.Customer;

public class AdminUser extends javax.swing.JFrame {
    
    private static EntityManager em;

    /**
     * Creates new form AdminUser
     */

    public AdminUser() {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebMarketPU");
        // Δημιουργία του Entity Manager
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

        WebMarketPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("WebMarketPU").createEntityManager();
        customerQuery = java.beans.Beans.isDesignTime() ? null : WebMarketPUEntityManager.createQuery("SELECT c FROM Customer c");
        customerList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : customerQuery.getResultList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        newCustomerButton = new javax.swing.JButton();
        editCustomerButton = new javax.swing.JButton();
        delCustomerButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WebMarket - Διαχείριση πελατών (administrator)");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Λίστα πελατών");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, customerList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstName}"));
        columnBinding.setColumnName("First Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastName}"));
        columnBinding.setColumnName("Last Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${address}"));
        columnBinding.setColumnName("Address");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pointsCardNumber}"));
        columnBinding.setColumnName("Points Card Number");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("Email");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${password}"));
        columnBinding.setColumnName("Password");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${availablePoints}"));
        columnBinding.setColumnName("Available Points");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${creditCardNumber}"));
        columnBinding.setColumnName("Credit Card Number");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        newCustomerButton.setText("Νέος");
        newCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCustomerButtonActionPerformed(evt);
            }
        });

        editCustomerButton.setText("Τροποποίηση");
        editCustomerButton.setEnabled(false);
        editCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustomerButtonActionPerformed(evt);
            }
        });

        delCustomerButton.setText("Διαγραφή");
        delCustomerButton.setEnabled(false);
        delCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delCustomerButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Πίσω");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(newCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202)
                .addComponent(editCustomerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(delCustomerButton)
                .addGap(210, 210, 210)
                .addComponent(exitButton)
                .addGap(88, 88, 88))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(561, 561, 561))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {delCustomerButton, editCustomerButton, exitButton, newCustomerButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newCustomerButton)
                    .addComponent(editCustomerButton)
                    .addComponent(delCustomerButton)
                    .addComponent(exitButton))
                .addGap(35, 35, 35))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        AdminFrame mainadmin = new AdminFrame();
        mainadmin.setLocationRelativeTo(null);
        mainadmin.setVisible(true);
        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void newCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCustomerButtonActionPerformed
        // Δημιουργία πελάτου
        AdminNewUser newUser = new AdminNewUser ();
        newUser.setLocationRelativeTo(null);
        newUser.setVisible(true);
        dispose();
    }//GEN-LAST:event_newCustomerButtonActionPerformed

    private void editCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustomerButtonActionPerformed
        // Επεξεργασία πελάτου
        int selected = jTable1.getSelectedRow();
        AdminEditUser editUser = new AdminEditUser (customerList.get(selected));
        editUser.setLocationRelativeTo(null);
        editUser.setVisible(true);
        dispose();
    }//GEN-LAST:event_editCustomerButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.getSelectedRow() >= 0) {
            editCustomerButton.setEnabled(true);
            delCustomerButton.setEnabled(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void delCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delCustomerButtonActionPerformed
        // Διαγραφή καταστήματος.
        int selected = jTable1.getSelectedRow();
        int n;
        Customer delUser = customerList.get(selected);
        n = JOptionPane.showOptionDialog(rootPane,
            "O πελάτης θα διαγραφεί, καθώς και\n" +
            "τυχόν επιταγές και παραγγελίες που\n" +
            "είχε στο λογαριασμό του.\n" +
            "  Είστε σίγουροι;","    Προσοχή !!!", 2,
            2, null, null, rootPane);
        if (n == 0) {
            em.getTransaction().begin();
            Customer tempcu = em.merge(delUser);
            em.remove(tempcu);
            em.getTransaction().commit();
            customerList.remove(selected);
        }
        AdminUser adminuser = new AdminUser();
        adminuser.setLocationRelativeTo(null);
        adminuser.setVisible(true);
        dispose();
    }//GEN-LAST:event_delCustomerButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AdminUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager WebMarketPUEntityManager;
    private java.util.List<model.Customer> customerList;
    private javax.persistence.Query customerQuery;
    private javax.swing.JButton delCustomerButton;
    private javax.swing.JButton editCustomerButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton newCustomerButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}