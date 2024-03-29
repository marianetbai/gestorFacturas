/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package es.marianetbai.vista;

import es.marianetbai.controlador.UsuarioJpaController;
import es.marianetbai.modelo.Usuario;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Maria
 */
public class RegistroUsuario extends javax.swing.JPanel {

    /**
     * Creates new form RegistroUsuario
     */
    public RegistroUsuario() {
        Locale.setDefault(Locale.UK);
        initComponents();
        setVisible(true);
    }
    
    private boolean camposValidos() {
        return !txtUsuario.getText().isEmpty() && !txtContrasenia.getText().isEmpty();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        lblContrasenia = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        lblLogo = new javax.swing.JLabel();
        lblCabecera = new javax.swing.JLabel();
        lblFondoLogin = new javax.swing.JLabel();
        pnlFondo = new javax.swing.JPanel();
        lblIcono2 = new javax.swing.JLabel();
        lblIcono1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogin.setBackground(new java.awt.Color(250, 244, 251));
        pnlLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAceptar.setBackground(new java.awt.Color(153, 153, 255));
        btnAceptar.setForeground(new java.awt.Color(51, 51, 51));
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("es/marianetbai/vista/Bundle"); // NOI18N
        btnAceptar.setText(bundle.getString("RegistroUsuario.btnAceptar.text")); // NOI18N
        btnAceptar.setToolTipText(bundle.getString("RegistroUsuario.btnAceptar.toolTipText")); // NOI18N
        btnAceptar.setBorder(null);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        pnlLogin.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 110, 40));

        lblContrasenia.setForeground(new java.awt.Color(73, 80, 87));
        lblContrasenia.setText(bundle.getString("RegistroUsuario.lblContrasenia.text")); // NOI18N
        pnlLogin.add(lblContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(153, 153, 255));
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setText(bundle.getString("RegistroUsuario.btnCancelar.text")); // NOI18N
        btnCancelar.setToolTipText(bundle.getString("RegistroUsuario.btnCancelar.toolTipText")); // NOI18N
        btnCancelar.setBorder(null);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlLogin.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 110, 40));

        lblUsuario.setForeground(new java.awt.Color(73, 80, 87));
        lblUsuario.setText(bundle.getString("RegistroUsuario.lblUsuario.text")); // NOI18N
        pnlLogin.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        txtContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseniaActionPerformed(evt);
            }
        });
        pnlLogin.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 390, 40));

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        pnlLogin.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 390, 40));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cc.png"))); // NOI18N
        pnlLogin.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 450, 70));

        lblCabecera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro.jpg"))); // NOI18N
        pnlLogin.add(lblCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 110));

        lblFondoLogin.setBackground(new java.awt.Color(255, 255, 255));
        pnlLogin.add(lblFondoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 450, 380));

        add(pnlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondo.setPreferredSize(new java.awt.Dimension(1040, 570));
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIcono2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Ellipse 209.png"))); // NOI18N
        pnlFondo.add(lblIcono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, 690, 390));

        lblIcono1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Union.png"))); // NOI18N
        lblIcono1.setText(bundle.getString("RegistroUsuario.lblIcono1.text")); // NOI18N
        lblIcono1.setMaximumSize(new java.awt.Dimension(1040, 570));
        lblIcono1.setMinimumSize(new java.awt.Dimension(1040, 570));
        lblIcono1.setPreferredSize(new java.awt.Dimension(1040, 570));
        pnlFondo.add(lblIcono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-230, -740, 4590, 1900));

        add(pnlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (camposValidos()) {
            try {
                //nos conectamos con la base de datos
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
                UsuarioJpaController ujpa = new UsuarioJpaController(emf);

                Usuario usuario = new Usuario();
                usuario.setUsuario(txtUsuario.getText());
                usuario.setPassword(txtContrasenia.getText());
                ujpa.create(usuario);

                JOptionPane.showMessageDialog(this, "The user has been successfully registered",
                        "Registering user...", JOptionPane.INFORMATION_MESSAGE);

                //cerramos la ventana actual (RegistroUsuario)
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                frame.dispose();

                //abrimos la ventana del Login
                JFrame loginFrame = new JFrame("Log in");
                loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginFrame.getContentPane().add(new Login());
                loginFrame.pack();
                loginFrame.setVisible(true);
                loginFrame.setLocationRelativeTo(null);
            } catch (Exception ex) {
                Logger.getLogger(GestorFacturas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "You must fill out all fields to continue",
                    "Incomplete fields", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //cerramos la ventana actual (CambioContrasenia)
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();

        //abrimos la ventana del Login
        JFrame loginFrame = new JFrame("Log in");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.getContentPane().add(new Login());
        loginFrame.pack();
        loginFrame.setVisible(true);
        loginFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        btnAceptar.setEnabled(camposValidos());
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseniaActionPerformed
        btnAceptar.setEnabled(camposValidos());
    }//GEN-LAST:event_txtContraseniaActionPerformed
     
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblCabecera;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblFondoLogin;
    private javax.swing.JLabel lblIcono1;
    private javax.swing.JLabel lblIcono2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
