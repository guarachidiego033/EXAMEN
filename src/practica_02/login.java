
package practica_02;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import practica_01.Conexion;


public class login extends javax.swing.JFrame {

  
 Conexion cx;
    public login() {
        initComponents();
        this.setTitle("LOGIN");
        this.setSize(240,230);
        Image img=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/login.png"));
        Image img2=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/fondoxD.jpg"));
        lblLogo.setIcon(new ImageIcon(img.getScaledInstance(lblLogo.getWidth(),lblLogo.getHeight(),Image.SCALE_SMOOTH)));
         lblLogo2.setIcon(new ImageIcon(img2.getScaledInstance(lblLogo2.getWidth(),lblLogo2.getHeight(),Image.SCALE_SMOOTH)));
        this.setIconImage(img);
        this.setLocationRelativeTo(null);
        cx=new Conexion ("usuarios");
        cx.conectar();
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
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnIniciar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblLogo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USUARIO :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PASSWORD :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 128, -1));

        btnIniciar.setText("INICIAR");
        btnIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIniciarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIniciarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIniciarMouseExited(evt);
            }
        });
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        btnCancelar.setText("CANCELAR");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login.png"))); // NOI18N
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 120, 100));

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 130, -1));

        lblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoxD.jpg"))); // NOI18N
        getContentPane().add(lblLogo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        login2  login2=new login2();
     try { 
         String user=txtUsuario.getText();
         String password=String.valueOf(txtPassword.getPassword());
         String query="SELECT * FROM usuario WHERE user='"+user+"' and password='"+password+"'";
         
         Statement st= cx.conectar().createStatement();
         ResultSet rs=st.executeQuery(query);
         if(rs.next()){
         JOptionPane.showMessageDialog(this,"FELIZIDADES INGRESASTE CON EXITO");
         
         login2.setVisible(true);
         }
         else{JOptionPane.showMessageDialog(this,"EL USUARIO NO EXISTE EN LA BASE DE DATOS");
         }
     } catch (SQLException ex) {
         Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
     JOptionPane.showMessageDialog(this,"XAMP inactivo");
     }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
     System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnIniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarMouseClicked
  
        
        
    }//GEN-LAST:event_btnIniciarMouseClicked

    private void btnIniciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarMouseEntered
    btnIniciar.setBackground(Color.blue);
    
   
    }//GEN-LAST:event_btnIniciarMouseEntered

    private void btnIniciarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarMouseExited
     btnIniciar.setBackground(Color.white);
    }//GEN-LAST:event_btnIniciarMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
    btnCancelar.setBackground(Color.red);
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
      btnCancelar.setBackground(Color.white);
    }//GEN-LAST:event_btnCancelarMouseExited

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogo2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
