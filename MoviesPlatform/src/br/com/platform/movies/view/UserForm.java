package br.com.platform.movies.view;

import br.com.platform.movies.controller.PersonController;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author elieudo Maia
 * @author Ivanildo Borges
 */
public class UserForm extends javax.swing.JFrame {
  private PersonController personController;

  /**
   * Creates new form RegisterUser
   */
  public UserForm() {
    this.personController = new PersonController();
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

    jLabel1 = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    Title = new javax.swing.JLabel();
    textName = new javax.swing.JLabel();
    textEmail = new javax.swing.JLabel();
    textTel = new javax.swing.JLabel();
    textAddress = new javax.swing.JLabel();
    textBirth = new javax.swing.JLabel();
    textPassword = new javax.swing.JLabel();
    isAdmin = new javax.swing.JCheckBox();
    name = new javax.swing.JTextField();
    email = new javax.swing.JTextField();
    phone = new javax.swing.JTextField();
    address = new javax.swing.JTextField();
    textConfirmPassword = new javax.swing.JLabel();
    password = new javax.swing.JPasswordField();
    passwordConfimation = new javax.swing.JPasswordField();
    btnCancel = new javax.swing.JButton();
    btnConfirm = new javax.swing.JButton();
    birthDate = new javax.swing.JFormattedTextField();
    Background = new javax.swing.JLabel();

    jLabel1.setText("jLabel1");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Cadastrar usuário");
    setResizable(false);

    jPanel1.setLayout(null);

    Title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    Title.setForeground(new java.awt.Color(130, 19, 138));
    Title.setText("CADASTRO");
    jPanel1.add(Title);
    Title.setBounds(360, 40, 200, 32);

    textName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    textName.setForeground(new java.awt.Color(255, 255, 255));
    textName.setText("Nome:");
    jPanel1.add(textName);
    textName.setBounds(60, 120, 60, 22);

    textEmail.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    textEmail.setForeground(new java.awt.Color(255, 255, 255));
    textEmail.setText("Email:");
    jPanel1.add(textEmail);
    textEmail.setBounds(540, 120, 47, 22);

    textTel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    textTel.setForeground(new java.awt.Color(255, 255, 255));
    textTel.setText("Telefone:");
    jPanel1.add(textTel);
    textTel.setBounds(540, 170, 71, 22);

    textAddress.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    textAddress.setForeground(new java.awt.Color(255, 255, 255));
    textAddress.setText("Endereço:");
    jPanel1.add(textAddress);
    textAddress.setBounds(60, 170, 75, 22);

    textBirth.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    textBirth.setForeground(new java.awt.Color(255, 255, 255));
    textBirth.setText("Data de Nascimento:");
    jPanel1.add(textBirth);
    textBirth.setBounds(540, 220, 159, 22);

    textPassword.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    textPassword.setForeground(new java.awt.Color(255, 255, 255));
    textPassword.setText("Senha:");
    jPanel1.add(textPassword);
    textPassword.setBounds(60, 220, 51, 22);

    isAdmin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    isAdmin.setForeground(new java.awt.Color(137, 61, 140));
    isAdmin.setText("Administrador");
    isAdmin.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        isAdminActionPerformed(evt);
      }
    });
    jPanel1.add(isAdmin);
    isAdmin.setBounds(540, 280, 110, 30);
    jPanel1.add(name);
    name.setBounds(60, 140, 367, 22);
    jPanel1.add(email);
    email.setBounds(540, 140, 310, 22);

    phone.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        phoneActionPerformed(evt);
      }
    });
    jPanel1.add(phone);
    phone.setBounds(540, 190, 190, 22);
    jPanel1.add(address);
    address.setBounds(60, 190, 350, 22);

    textConfirmPassword.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    textConfirmPassword.setForeground(new java.awt.Color(255, 255, 255));
    textConfirmPassword.setText("Confirmar Senha:");
    jPanel1.add(textConfirmPassword);
    textConfirmPassword.setBounds(60, 270, 132, 22);
    jPanel1.add(password);
    password.setBounds(60, 240, 250, 22);
    jPanel1.add(passwordConfimation);
    passwordConfimation.setBounds(60, 290, 250, 22);

    btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    btnCancel.setForeground(new java.awt.Color(137, 61, 140));
    btnCancel.setText("Cancelar");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCancelActionPerformed(evt);
      }
    });
    jPanel1.add(btnCancel);
    btnCancel.setBounds(300, 360, 120, 33);

    btnConfirm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    btnConfirm.setForeground(new java.awt.Color(137, 61, 140));
    btnConfirm.setText("Confirmar");
    btnConfirm.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnConfirmActionPerformed(evt);
      }
    });
    jPanel1.add(btnConfirm);
    btnConfirm.setBounds(460, 360, 117, 33);

    try {
      birthDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
    } catch (java.text.ParseException ex) {
      ex.printStackTrace();
    }
    birthDate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        birthDateActionPerformed(evt);
      }
    });
    jPanel1.add(birthDate);
    birthDate.setBounds(540, 240, 160, 30);

    Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/platform/movies/midia/Retângulo 1.jpg"))); // NOI18N
    jPanel1.add(Background);
    Background.setBounds(0, 0, 950, 430);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
    new UserArea().setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_btnCancelActionPerformed

  private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
    String name = this.name.getText();
    String email = this.email.getText();
    String phone = this.phone.getText();
    String address = this.address.getText();
    boolean isAdmin = this.isAdmin.isSelected();
    String birthDate = this.birthDate.getText();
    char[] password = this.password.getPassword();
    char[] passwordConfimation = this.passwordConfimation.getPassword();
    
    String day = birthDate.split("/")[0];
    String month = birthDate.split("/")[1];
    String year = birthDate.split("/")[2];
    
    Calendar cal = Calendar.getInstance();
    int dayNumber = day.startsWith("0") ? Integer.parseInt(String.valueOf(day.charAt(1))) : Integer.parseInt(day);
    int monthNumber = month.startsWith("0") ? Integer.parseInt(String.valueOf(month.charAt(1))) : Integer.parseInt(month);
    cal.set(Integer.parseInt(year), monthNumber - 1, dayNumber);
    
    Date date = new Date(cal.getTimeInMillis());
    
    try {
      // MOCKss
      this.personController.create(name, email, new String(password), phone, address, isAdmin, date);
      JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
      new UserArea().setVisible(true);
      this.setVisible(false);
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage());
    }
  }//GEN-LAST:event_btnConfirmActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void isAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isAdminActionPerformed

  private void birthDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthDateActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_birthDateActionPerformed

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
      java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> {
        new UserForm().setVisible(true);
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel Background;
  private javax.swing.JLabel Title;
  private javax.swing.JTextField address;
  private javax.swing.JFormattedTextField birthDate;
  private javax.swing.JButton btnCancel;
  private javax.swing.JButton btnConfirm;
  private javax.swing.JTextField email;
  private javax.swing.JCheckBox isAdmin;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTextField name;
  private javax.swing.JPasswordField password;
  private javax.swing.JPasswordField passwordConfimation;
  private javax.swing.JTextField phone;
  private javax.swing.JLabel textAddress;
  private javax.swing.JLabel textBirth;
  private javax.swing.JLabel textConfirmPassword;
  private javax.swing.JLabel textEmail;
  private javax.swing.JLabel textName;
  private javax.swing.JLabel textPassword;
  private javax.swing.JLabel textTel;
  // End of variables declaration//GEN-END:variables
}
