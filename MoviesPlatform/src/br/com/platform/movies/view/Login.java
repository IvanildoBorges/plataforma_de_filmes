package br.com.platform.movies.view;

import br.com.platform.movies.controller.PersonController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elieu
 */
public class Login extends javax.swing.JFrame {
  private PersonController personController;

  /**
   * Creates new form LoginScreen
   */
  public Login() {
    initComponents();
    
    this.personController = new PersonController();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        textEmail = new javax.swing.JLabel();
        textPassword = new javax.swing.JLabel();
        camporEmail = new javax.swing.JTextField();
        campoPassword = new javax.swing.JPasswordField();
        butaoLogin = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        jPanel1.setLayout(null);

        Title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("LOGIN");
        jPanel1.add(Title);
        Title.setBounds(260, 50, 120, 50);

        textEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textEmail.setForeground(new java.awt.Color(255, 255, 255));
        textEmail.setText("E-mail:");
        jPanel1.add(textEmail);
        textEmail.setBounds(170, 190, 58, 25);

        textPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textPassword.setForeground(new java.awt.Color(255, 255, 255));
        textPassword.setText("Senha:");
        jPanel1.add(textPassword);
        textPassword.setBounds(170, 230, 57, 25);
        jPanel1.add(camporEmail);
        camporEmail.setBounds(240, 180, 275, 27);
        jPanel1.add(campoPassword);
        campoPassword.setBounds(240, 220, 275, 30);

        butaoLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butaoLogin.setForeground(new java.awt.Color(137, 61, 140));
        butaoLogin.setText("Entrar");
        butaoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoLoginActionPerformed(evt);
            }
        });
        jPanel1.add(butaoLogin);
        butaoLogin.setBounds(420, 270, 90, 33);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/platform/movies/midia/Retângulo 1.jpg"))); // NOI18N
        jPanel1.add(background);
        background.setBounds(0, 0, 650, 390);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  private void butaoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoLoginActionPerformed
    String email = this.camporEmail.getText();
    char pass[] = this.campoPassword.getPassword();
    
    try {
      int personId = this.personController.login(email, new String(pass));
      
      System.out.println("personId" + personId);
      System.out.println("ação do botão");
      
      UserArea userArea = new UserArea();
      userArea.setTitle("bndjfnsdjkfnbjkdfn");
      userArea.personId = 2;
      userArea.setVisible(true);
      
      this.setVisible(false);
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage());
    }
  }//GEN-LAST:event_butaoLoginActionPerformed

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
      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Login().setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JLabel background;
    private javax.swing.JButton butaoLogin;
    private javax.swing.JPasswordField campoPassword;
    private javax.swing.JTextField camporEmail;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel textEmail;
    private javax.swing.JLabel textPassword;
    // End of variables declaration//GEN-END:variables
}
