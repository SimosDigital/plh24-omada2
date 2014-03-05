package webmarket;

/**
 * @author Petter Sellers ( USER_PROFILE )
 */

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import model.Customer;

public class UserEditProfile extends javax.swing.JFrame {

    /**
     * Creates new form UserEditProfile
     */

    private static EntityManager em;
    private javax.persistence.Query query1;
    private Integer customerId;

    Customer logedUser;
    
    public UserEditProfile() {
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

        DeleteButton = new javax.swing.JButton();
        screenAddress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        screenEmail = new javax.swing.JTextField();
        screenLastName = new javax.swing.JTextField();
        screenFirstName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        screenCreditCardNumber = new javax.swing.JTextField();
        screenCreditCardOwnerName = new javax.swing.JTextField();
        screenCreditCardCvv = new javax.swing.JTextField();
        choice1 = new java.awt.Choice();
        jLabel6 = new javax.swing.JLabel();
        screenPointsCardNumber = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        OkButton = new javax.swing.JButton();
        ExitButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WebMarket - Διαχείριση Προφίλ");

        DeleteButton.setText("Διαγραφή");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Όνομα");

        jLabel4.setText("email");

        jLabel3.setText("Επώνυμο");

        screenEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenEmailActionPerformed(evt);
            }
        });

        screenLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenLastNameActionPerformed(evt);
            }
        });

        screenFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenFirstNameActionPerformed(evt);
            }
        });

        jLabel5.setText("Διεύθυνση");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Στοιχεία πιστωτικής κάρτας", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Αριθμός κάρτας");

        jLabel8.setText("Όνομα κατόχου");

        jLabel9.setText("CVV");

        jLabel10.setText("Τράπεζα");

        screenCreditCardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenCreditCardNumberActionPerformed(evt);
            }
        });

        choice1.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(screenCreditCardCvv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(screenCreditCardNumber)
                    .addComponent(screenCreditCardOwnerName)
                    .addComponent(choice1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(screenCreditCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(screenCreditCardOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(screenCreditCardCvv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel6.setText("Αρ. κάρτας πόντων ");

        screenPointsCardNumber.setEnabled(false);
        screenPointsCardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenPointsCardNumberActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("3.1.1. Eπεξεργασία Προφίλ");

        OkButton.setText("Αποθήκευση");
        OkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkButtonActionPerformed(evt);
            }
        });

        ExitButton1.setText("Ακύρωση/Επιστροφή");
        ExitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(screenAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                    .addComponent(screenEmail)
                                    .addComponent(screenLastName)
                                    .addComponent(screenFirstName)
                                    .addComponent(screenPointsCardNumber)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(OkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ExitButton1)
                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel11)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(screenFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(screenLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(screenEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(screenAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(screenPointsCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteButton)
                    .addComponent(OkButton))
                .addGap(18, 18, 18)
                .addComponent(ExitButton1)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
      
        int holdExit = JOptionPane.showConfirmDialog(this, "Σίγουρα ζητήσατε διαγραφή...     ", "     Προσοχή !", JOptionPane.YES_NO_CANCEL_OPTION);

        if (holdExit != 0)
        return;        
        
        em.getTransaction().begin();
        try
        {
        
        
            model.Customer c = new model.Customer();
            
            em.remove(c);


            
                
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(rootPane ,"Το Προφίλ σας διαγράφηκε...     " ,"     Προσοχή !",1);
        } catch (Exception e)
        {
            e.printStackTrace();
            em.getTransaction().rollback();
        }  
        
        UserProfile userprofile = new UserProfile();
        userprofile.setLogedUser(logedUser);
        userprofile.setLocationRelativeTo(null);
        userprofile.setVisible(true);
        dispose();              
        
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void screenFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screenFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_screenFirstNameActionPerformed

    private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkButtonActionPerformed
    
        String theFirstName           = new String(screenFirstName.getText());   
        String theLastName            = new String(screenLastName.getText());   
        String theEmail               = new String(screenEmail.getText());   
        String theAddress             = new String(screenAddress.getText());   
        String thePointsCardNumber    = new String(screenPointsCardNumber.getText());   
        String theCreditCardNumber    = new String(screenCreditCardNumber.getText());   
        String theCreditCardOwnerName = new String(screenCreditCardOwnerName.getText());   
        String theCreditCardCvv       = new String(screenCreditCardCvv.getText());   
        
        em.getTransaction().begin();
        try
        {

            
            
            query1 = em.createQuery("select u from Customer u where u.customerId=:customerId");
            query1.setParameter("customerId", customerId);

            logedUser.setFirstName(theFirstName);
            logedUser.setLastName(theLastName);               

            model.Customer c = new model.Customer();
            
            c.setLastName(theLastName);
            c.setFirstName(theFirstName);
            c.setEmail(theEmail);
            c.setAddress(theAddress);
            c.setPointsCardNumber(thePointsCardNumber);
            c.setCreditCardNumber(theCreditCardNumber);
            c.setCreditCardOwnerName(theCreditCardOwnerName);  
            c.setCreditCardCvv(theCreditCardCvv); 
                
                
                
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(rootPane ,"Το Προφίλ σας ενημερώθηκε...     " ,"     Προσοχή !",1);
        } catch (Exception e)
        {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        UserProfile userprofile = new UserProfile();
        userprofile.setLogedUser(logedUser);
        userprofile.setLocationRelativeTo(null);
        userprofile.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_OkButtonActionPerformed

    private void ExitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButton1ActionPerformed

        int holdExit = JOptionPane.showConfirmDialog(this, "Σίγουρα ζητήσατε ακύρωση & επιστροφή...     ", "     Προσοχή !", JOptionPane.YES_NO_CANCEL_OPTION);

        if (holdExit != 0)
        return;

        UserProfile userprofile = new UserProfile();
        userprofile.setLogedUser(logedUser);
        userprofile.setLocationRelativeTo(null);
        userprofile.setVisible(true);
        dispose();
    }//GEN-LAST:event_ExitButton1ActionPerformed

    private void screenLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screenLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_screenLastNameActionPerformed

    private void screenEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screenEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_screenEmailActionPerformed

    private void screenCreditCardNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screenCreditCardNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_screenCreditCardNumberActionPerformed

    private void screenPointsCardNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screenPointsCardNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_screenPointsCardNumberActionPerformed

    public void setLogedUser (Customer logedUser) {
        this.logedUser = logedUser;
                      
        screenFirstName.setText(logedUser.getFirstName());                                                   
        screenLastName.setText(logedUser.getLastName());                                                     
        screenEmail.setText(logedUser.getEmail());                                                           
        screenAddress.setText(logedUser.getAddress());                                                       
        screenPointsCardNumber.setText(logedUser.getPointsCardNumber());                                     
        screenCreditCardNumber.setText(logedUser.getCreditCardNumber());                                     
        screenCreditCardOwnerName.setText(logedUser.getCreditCardOwnerName());                               
        screenCreditCardCvv.setText(logedUser.getCreditCardCvv());  
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
            java.util.logging.Logger.getLogger(UserEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserEditProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton ExitButton1;
    private javax.swing.JButton OkButton;
    private java.awt.Choice choice1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField screenAddress;
    private javax.swing.JTextField screenCreditCardCvv;
    private javax.swing.JTextField screenCreditCardNumber;
    private javax.swing.JTextField screenCreditCardOwnerName;
    private javax.swing.JTextField screenEmail;
    private javax.swing.JTextField screenFirstName;
    private javax.swing.JTextField screenLastName;
    private javax.swing.JTextField screenPointsCardNumber;
    // End of variables declaration//GEN-END:variables
}