package br.com.platform.movies.view;

import br.com.platform.movies.controller.MovieController;
import br.com.platform.movies.model.Movie;
import javax.swing.JOptionPane;

/**
 *
 * @author Elieudo Maia
 * @author Ivanildo Borges
 */
public class Watch extends javax.swing.JFrame {
    private MovieController movieController = new MovieController();
    private int id;

    /**
     * Creates new form Watch
     */
    public Watch() {
        initComponents();
        this.getMovie();
    }
    
    public void setId(int id) {
        this.id = id;
        System.out.println("\n" + "ID recebido:" +id);
    }
    
    private void getMovie() {
      System.out.println("chamou a função que pega o filme");
      try {
        Movie movie = this.movieController.findById(this.id);
        System.out.println(movie.getName());
      } catch (Exception e) {
        System.out.println("Erro ao buscar informações do filme");
      }
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logo = new javax.swing.JLabel();
        tableInfo = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        qtdMin = new javax.swing.JSpinner();
        watch = new javax.swing.JButton();
        backGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Assistir filme");
        setResizable(false);
        getContentPane().setLayout(null);

        Logo.setFont(new java.awt.Font("Stencil", 0, 50)); // NOI18N
        Logo.setForeground(new java.awt.Color(255, 0, 0));
        Logo.setText("PLATAFORMA DE FILMES");
        getContentPane().add(Logo);
        Logo.setBounds(170, 20, 580, 60);

        tableInfo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Filme", "Gênero", "Classificação", "Duração", "Minutos assistidos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableInfo.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(200);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(300);
            jTable1.getColumnModel().getColumn(1).setMinWidth(100);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(2).setMinWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(3).setMinWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(1540);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(4).setMinWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        getContentPane().add(tableInfo);
        tableInfo.setBounds(120, 200, 720, 50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Quantos minutos deseja assistir?");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 280, 290, 30);
        getContentPane().add(qtdMin);
        qtdMin.setBounds(410, 280, 70, 30);

        watch.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        watch.setForeground(new java.awt.Color(137, 61, 140));
        watch.setText("ASSISTIR");
        watch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watchActionPerformed(evt);
            }
        });
        getContentPane().add(watch);
        watch.setBounds(390, 360, 190, 50);

        backGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/platform/movies/midia/Retângulo 1.jpg"))); // NOI18N
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 960, 590);

        setSize(new java.awt.Dimension(958, 617));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void watchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_watchActionPerformed
        int n = (int) qtdMin.getValue();
        
//        try {
//            
//            
//            JOptionPane.showMessageDialog(null, "Progresso salvo!");
//            new MyAccount().setVisible(true);
//            this.setVisible(false);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
    }//GEN-LAST:event_watchActionPerformed

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
            java.util.logging.Logger.getLogger(Watch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Watch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Watch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Watch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Watch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel backGround;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner qtdMin;
    private javax.swing.JScrollPane tableInfo;
    private javax.swing.JButton watch;
    // End of variables declaration//GEN-END:variables
}
