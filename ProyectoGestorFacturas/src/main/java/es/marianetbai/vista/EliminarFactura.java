/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package es.marianetbai.vista;

import es.marianetbai.controlador.FacturaJpaController;
import es.marianetbai.controlador.exceptions.NonexistentEntityException;
import es.marianetbai.modelo.Factura;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maria
 */
public class EliminarFactura extends javax.swing.JFrame {

    /**
     * Creates new form EliminarFactura
     */
    
    ImagenFondo ejemplo = new ImagenFondo();
    
    //lista temporal 
    private Factura ultimaFacturaEliminada;

    public EliminarFactura() {
        Locale.setDefault(Locale.UK);
        this.setContentPane(ejemplo);
        this.setSize(1040,570);
        this.setLocationRelativeTo(null);
        initComponents();
                
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        mostrarFacturasEnTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEliminarFactura = new javax.swing.JLabel();
        lblSeleccionarFactura = new javax.swing.JLabel();
        scrollPaneTabla = new javax.swing.JScrollPane();
        tablaListaFactura = new javax.swing.JTable();
        lblIcono4 = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        lblIcono1 = new javax.swing.JLabel();
        btnDeshacer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("es/marianetbai/vista/Bundle"); // NOI18N
        setTitle(bundle.getString("EliminarFactura.title")); // NOI18N
        setSize(new java.awt.Dimension(1040, 570));

        lblEliminarFactura.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblEliminarFactura.setText(bundle.getString("EliminarFactura.lblEliminarFactura.text")); // NOI18N

        lblSeleccionarFactura.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSeleccionarFactura.setText(bundle.getString("EliminarFactura.lblSeleccionarFactura.text")); // NOI18N

        tablaListaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Subject", "Date", "Amount", "Type", "Client", "Deleted"
            }
        ));
        scrollPaneTabla.setViewportView(tablaListaFactura);

        lblIcono4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoBorrar.png"))); // NOI18N

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imEliminar.png"))); // NOI18N

        btnEliminar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnEliminar.setText(bundle.getString("EliminarFactura.btnEliminar.text")); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblIcono1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Maria\\Documents\\NetBeansProjects\\ProyectoGestorFacturas\\src\\main\\resources\\imagenes\\icons8-recuperar-48.png")); // NOI18N
        lblIcono1.setText(bundle.getString("EliminarFactura.lblIcono1.text")); // NOI18N

        btnDeshacer.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnDeshacer.setText(bundle.getString("EliminarFactura.btnDeshacer.text")); // NOI18N
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEliminarFactura)
                            .addComponent(scrollPaneTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSeleccionarFactura))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIcono4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar))
                            .addComponent(lblIcono)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIcono1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(lblEliminarFactura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSeleccionarFactura)
                        .addGap(29, 29, 29)
                        .addComponent(scrollPaneTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcono4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIcono1)
                    .addComponent(btnDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            int filaSeleccionada = tablaListaFactura.getSelectedRow();
            if (filaSeleccionada != -1) {
                //obtenemos el ID de la factura seleccionada
                int idFacturaEliminar = (int) tablaListaFactura.getValueAt(filaSeleccionada, 0);

                //eliminamos la factura de la base de datos
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
                FacturaJpaController ujpa = new FacturaJpaController(emf);
                Factura facturaEliminada = ujpa.findFactura(idFacturaEliminar);

                //guardamos la factura eliminada
                ultimaFacturaEliminada = facturaEliminada;
                
                //ponemos el valor de "Baja" a 1 antes de eliminarla
                facturaEliminada.setBaja(1);
                
                try {
                    //y actualizamos la base de datos
                    ujpa.edit(facturaEliminada);
                } catch (Exception ex) {
                    Logger.getLogger(EliminarFactura.class.getName()).log(Level.SEVERE, null, ex);
                }

                //eliminamos la factura de la base de datos
                ujpa.destroy(idFacturaEliminar);

                //eliminamos la fila de la tabla
                DefaultTableModel modeloTabla = (DefaultTableModel) tablaListaFactura.getModel();
                modeloTabla.removeRow(filaSeleccionada);

                JOptionPane.showMessageDialog(this, "The invoice has been successfully deleted",
                        "Deleting invoice...", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Select an invoice to delete", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NonexistentEntityException | HeadlessException ex) {
            JOptionPane.showMessageDialog(this, "Error deleting invoice: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        try {
            if (ultimaFacturaEliminada != null) {
                //restauramos la última factura eliminada con su ID original
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
                FacturaJpaController ujpa = new FacturaJpaController(emf);

                //ponemos el valor de "Baja" a 1 porque está ya eliminada
                ultimaFacturaEliminada.setBaja(1);

                //verificamos si ya existe una factura con el mismo ID
                Factura facturaExistente = ujpa.findFactura(ultimaFacturaEliminada.getId());

                if (facturaExistente == null) {
                    //si no existe, restaura la factura con su ID original
                    ujpa.create(ultimaFacturaEliminada);  // Aquí estás creando una nueva factura

                    //actualizamos la tabla con la factura restaurada
                    DefaultTableModel modeloTabla = (DefaultTableModel) tablaListaFactura.getModel();
                    modeloTabla.addRow(new Object[]{ultimaFacturaEliminada.getId(), ultimaFacturaEliminada.getAsunto(),
                        ultimaFacturaEliminada.getFecha(), ultimaFacturaEliminada.getCantidad(),
                        ultimaFacturaEliminada.getTipo(), ultimaFacturaEliminada.getCliente(), ultimaFacturaEliminada.getBaja()});

                JOptionPane.showMessageDialog(this, "The invoice has been successfully restored",
                    "Restoring invoice...", JOptionPane.INFORMATION_MESSAGE);

                ultimaFacturaEliminada = null;
            } else {
                //di ya existe una factura con el mismo ID, muestra un mensaje de error
                JOptionPane.showMessageDialog(this, "The invoice already exists in the database", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No deleted invoices to undo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error restoring invoice: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeshacerActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EliminarFactura eliminarFactura = new EliminarFactura();
                eliminarFactura.mostrarFacturasEnTabla();
                eliminarFactura.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel lblEliminarFactura;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblIcono1;
    private javax.swing.JLabel lblIcono4;
    private javax.swing.JLabel lblSeleccionarFactura;
    private javax.swing.JScrollPane scrollPaneTabla;
    private javax.swing.JTable tablaListaFactura;
    // End of variables declaration//GEN-END:variables

    class ImagenFondo extends JPanel{
        private Image imagen;
        public void paint (Graphics g){
            imagen = new javax.swing.ImageIcon(getClass().getResource("/imagenes/addf.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

    public void mostrarFacturasEnTabla() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
            FacturaJpaController ujpa = new FacturaJpaController(emf);

            //obtenemos la lista actual de facturas
            List<Factura> listaFacturas = ujpa.findFacturaEntities();

            //y actualizamos el modelo de la tabla con la nueva lista de facturas
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaListaFactura.getModel();

            //liampiamos la tabla antes de agregar las nuevas filas
            modeloTabla.setRowCount(0);

            //agregamos la información de cada factura a la tabla
            for (Factura factura : listaFacturas) {
                //formateamos la cantidad para que aparezca sin decimales
                DecimalFormat decimalFormat = new DecimalFormat("#");
                String cantidadFormateada = decimalFormat.format(factura.getCantidad());

                //formatemoas la fecha para mostrar solo la fecha
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fechaFormateada = dateFormat.format(factura.getFecha());

                modeloTabla.addRow(new Object[]{factura.getId(), factura.getAsunto(), fechaFormateada,
                        cantidadFormateada, factura.getTipo(), factura.getCliente(), factura.getBaja()});
            }
            //tras agregar las filas, vuelve a establecer el modelo de la tabla
            tablaListaFactura.setModel(modeloTabla);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
