package webmarket;

/**
 * @author Petter Sellers ( User_Password )
 */

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import model.Customer;

public class UserPassword extends javax.swing.JFrame {

   /**
     * Creates new form UserPassword
     */
    
    private static EntityManager em;
    private javax.persistence.Query query1;
    private Integer customerId;

    Customer logedUser;
    
    public UserPassword() {
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        screenOldPassword = new javax.swing.JPasswordField();
        OkButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        logedUserText2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        screenNewPassword = new javax.swing.JPasswordField();
        screenRetypeNewPassword = new javax.swing.JPasswordField();
        logedUserText1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WebMarket - Διαχείριση Προφίλ");

        jLabel2.setText("Παλαιός κωδικός");

        jLabel3.setText("Νέος κωδικός");

        jLabel4.setText("Επανάληψη κωδικού");

        OkButton.setText("Αποθήκευση");
        OkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkButtonActionPerformed(evt);
            }
        });

        ExitButton.setText("Ακύρωση/Επιστροφή");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Aλλαγή κωδικού");

        logedUserText2.setEnabled(false);
        logedUserText2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logedUserText2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Επώνυμο");

        logedUserText1.setEnabled(false);

        jLabel8.setText("Όνομα");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ExitButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logedUserText2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(screenOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(screenNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logedUserText1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(screenRetypeNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel5)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logedUserText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logedUserText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(screenOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(screenNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(screenRetypeNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkButton)
                    .addComponent(ExitButton))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        
        int holdExit = JOptionPane.showConfirmDialog(this, "Σίγουρα ζητήσατε ακύρωση & επιστροφή...     ", "     WebMarket", JOptionPane.YES_NO_CANCEL_OPTION);
        
        if (holdExit != 0)
            return;
        
        UserProfile userprofile = new UserProfile();
        userprofile.setLogedUser(logedUser);
        userprofile.setLocationRelativeTo(null);
        userprofile.setVisible(true);
        dispose();
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkButtonActionPerformed
      
        String theOldPassword       = new String(screenOldPassword.getPassword());
        String theNewPassword       = new String(screenNewPassword.getPassword());
        String theRetypeNewPassword = new String(screenRetypeNewPassword.getPassword());  
                        
        int maxLength = 16 ;
        int minLength =  8 ;
        int doAgain   =  0 ;
        
        //στην περίπτωση που στην οθονη υπάρχει διπλό λάθος, ο έλεγχος και η ενημέρωση του χρήστη
        //γίνεται κάθε φορά (ανά λάθος) με την χρήση ενός διακόπτη doAgain ο οποιος εαν αναψει το
        //προγραμμα δεν κάνει και τους επόμενους ελέγχους αλλά δίνει το λάθος
        
        // ελεγχος να μην αφηνει το κενο
        
        if (theOldPassword.equals ("") ) 
        { 
           JOptionPane.showMessageDialog(rootPane ,"Θα πρέπει να πληκτρολογήσετε τον παλαιό σας κωδικό...     ", "     Προσοχή !",2); 
           doAgain = 1;
        } else 
        
        //έλεγχος εαν γνωρίζει τον παλαιο κωδικό
        
        if (!logedUser.getPassword().equals(theOldPassword))
        { 
           JOptionPane.showMessageDialog(rootPane ,"O Παλαιός κωδικός που πληκτρολογήσατε είναι λάθος...     " ,"     Προσοχή !",2);  
           doAgain = 1;
        } else
        
        //έλεγχος του κωδικού σε μήκος max=16
            
        if (theNewPassword.length() > maxLength) 
        { 
           JOptionPane.showMessageDialog(rootPane ,"Αποδεκτοί κωδικοί θεωρούνται, οι συνδυασμοί τουλάχιστον 8 έως 16 χαρακτήρων...     ", "     Προσοχή !",2); 
           doAgain = 1;
        } else 
         
        //έλεγχος του κωδικού σε μήκος min=8
            
        if (theNewPassword.length() < minLength) 
        { 
           JOptionPane.showMessageDialog(rootPane ,"Αποδεκτοί κωδικοί θεωρούνται, οι συνδυασμοί τουλάχιστον 8 έως 16 χαρακτήρων...     ", "     Προσοχή !",2); 
           doAgain = 1;
        } else
                    
        //έλεγχος έαν το έγραψε σωστά
            
        if (!theNewPassword.equals(theRetypeNewPassword))
        { 
           JOptionPane.showMessageDialog(rootPane ,"Δεν επαναλάβατε σωστά τον νέο σας κωδικό...     " ,"     Προσοχή !",2);  
           doAgain = 1;
        }    
        
        // εάν ο διακόπτης ύπαρξης λάθους είναι μηδεν (δεν βρέθηκε πρόβλημα) τότε γινεται η ενημέρωση
        
        if (doAgain == 0) 
        {
            
            
            logedUser.setPassword(theNewPassword);
            
            
            Customer temp = em.merge(logedUser);
            em.persist(temp);
            em.getTransaction().begin();
            em.getTransaction().commit();
            

            JOptionPane.showMessageDialog(rootPane ,"O κωδικός σας άλλαξε...     " ,"     WebMarket",1);
       
            
            UserProfile userprofile = new UserProfile();
            userprofile.setLogedUser(logedUser);
            userprofile.setLocationRelativeTo(null);
            userprofile.setVisible(true);
            dispose();    
        } 
    }//GEN-LAST:event_OkButtonActionPerformed

    private void logedUserText2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logedUserText2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logedUserText2ActionPerformed
  
    public void setLogedUser (Customer logedUser) {
        this.logedUser = logedUser;
                      
        logedUserText1.setText(logedUser.getFirstName());
        logedUserText2.setText(logedUser.getLastName());
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
            java.util.logging.Logger.getLogger(UserPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton OkButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField logedUserText1;
    private javax.swing.JTextField logedUserText2;
    private javax.swing.JPasswordField screenNewPassword;
    private javax.swing.JPasswordField screenOldPassword;
    private javax.swing.JPasswordField screenRetypeNewPassword;
    // End of variables declaration//GEN-END:variables
}