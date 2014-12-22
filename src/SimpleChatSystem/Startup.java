/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleChatSystem;

import Common.Codes;
import Cryptography.Hasher;
import CurrentDb.TableColumns.User;
import CurrentDb.TableNames;
import CurrentDb.Tables.UserTable;
import DesignPattern.JFrameInheritable;
import Global.AppConfig;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Alim
 */
public class Startup extends JFrameInheritable {

    private static final long serialVersionUID = 1L;

    private int loginCounter = 0;

    /**
     * Creates new form Startup
     */
    public Startup() {
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        UsernameTextBox = new javax.swing.JTextField();
        UsernameLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        PasswordTextBox = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple Chat by Alim Ul Karim\n");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        jButton1.setLabel("Server Start");
        jButton1.setName("ServerStartBtn"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setLabel("Register");
        jButton2.setName("RegisterBtn"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setLabel("Server Stop");
        jButton3.setName("ServerStopBtn"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        UsernameTextBox.setText("username or email");

        UsernameLabel.setText("Username:");

        PasswordLabel.setText("Password:");
        PasswordLabel.setName("PasswordLabel"); // NOI18N

        jButton4.setText("Login");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        PasswordTextBox.setToolTipText("Please write your password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4)
                    .addComponent(UsernameLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(UsernameTextBox)
                    .addComponent(PasswordLabel)
                    .addComponent(PasswordTextBox))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(15, 15, 15)
                .addComponent(UsernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UsernameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(344, 241));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ChatingInterface frm = new ChatingInterface();
        frm.show(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    @SuppressWarnings("deprecation")
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        RegisterForm reg = new RegisterForm();
        reg.setPreviousForm(this);
        reg.show(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    @SuppressWarnings("deprecation")
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (loginCounter >= AppConfig.MAX_TRY_LOGIN) {
            getMessageBox().show(this, "Your login is blocked for short time. Try again later.");
            return;
        }
        String usernameOrEmail = UsernameTextBox.getText();
        String password = PasswordTextBox.getText();
        String hashedPassword = Hasher.getShA1Hash(password);

        int numberOfFields = 4;
        String Columns[] = new String[numberOfFields];
        String Values[] = new String[numberOfFields];
        int i = 0;
        Columns[i] = User.Username;
        Values[i++] = usernameOrEmail;

        Columns[i] = User.Password;
        Values[i++] = hashedPassword;

        Columns[i] = User.IsActive;
        Values[i++] = "1";

        Columns[i] = User.IsBlocked;
        Values[i++] = "0";
        boolean isUserExistByUsername = this.getDb().isExist(Columns, Values);
        if (isUserExistByUsername == false) {
            // user name is not found with this password.. 
            // now try for email 
            Columns[0] = User.Email;

            boolean isUserExistByEmail = this.getDb().isExist(Columns, Values);
            if (isUserExistByEmail) {
                OnSuccessLogin(false);
            } else {
                OnLoginFailed();
            }

        } else {
            OnSuccessLogin(true);
        }
        loginCounter++;

    }//GEN-LAST:event_jButton4ActionPerformed

    @SuppressWarnings("deprecation")
    public void OnSuccessLogin(boolean foundByUserName) {
        UserTable _user = new UserTable();

        getMessageBox().show(this, "Congratulations, you have successfully logged in.");
        if (foundByUserName) {
            this.getDb().readData(User.Username, UsernameTextBox.getText()); // get user
        } else {
            this.getDb().readData(User.Email, UsernameTextBox.getText()); // get user
        }

        this.getDb().getResultsAsObject(_user.getClass(), _user);

        ListOfFriends listOfFriendsForm = new ListOfFriends(_user);
        Codes.displayRightMiddle(listOfFriendsForm);
        loadNewForm(listOfFriendsForm);

        this.hide();
    }

    public void OnLoginFailed() {
        // no found in any where
        // user doesn't exist with this user name and password
        getMessageBox().show(this, "Either user doesn't exist in the database or user is not active.");
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Startup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Startup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Startup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Startup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Startup().setVisible(true);
            }
        });
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPasswordField PasswordTextBox;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JTextField UsernameTextBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void initalizeTableName() {
        this.getDb().setTableName(TableNames.USER);
    }
}
