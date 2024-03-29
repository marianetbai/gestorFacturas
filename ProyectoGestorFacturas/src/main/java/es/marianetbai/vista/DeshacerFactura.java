/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package es.marianetbai.vista;

import es.marianetbai.controlador.FacturaJpaController;
import es.marianetbai.modelo.Factura;
import java.awt.Graphics;
import java.awt.Image;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maria
 */
public class DeshacerFactura extends javax.swing.JFrame {

    /**
     * Creates new form DeshacerFactura
     */
    ImagenFondo ejemplo = new ImagenFondo();
    
    //lista temporal para usar el deshacer
    private Factura ultimaFacturaEliminada;
    
    public DeshacerFactura() {
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

        btnDeshacer = new javax.swing.JButton();
        scrollPaneTabla = new javax.swing.JScrollPane();
        tablaListaFactura = new javax.swing.JTable();
        lblDeshacerFactura = new javax.swing.JLabel();
        lblBotonDeshacer = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("es/marianetbai/vista/Bundle"); // NOI18N
        setTitle(bundle.getString("DeshacerFactura.title")); // NOI18N
        setSize(new java.awt.Dimension(1040, 570));

        btnDeshacer.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnDeshacer.setText(bundle.getString("DeshacerFactura.btnDeshacer.text")); // NOI18N
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });

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

        lblDeshacerFactura.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lblDeshacerFactura.setText(bundle.getString("DeshacerFactura.lblDeshacerFactura.text")); // NOI18N

        lblBotonDeshacer.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblBotonDeshacer.setText(bundle.getString("DeshacerFactura.lblBotonDeshacer.text")); // NOI18N

        lblIcono.setIcon(new javax.swing.ImageIcon("C:\\Users\\Maria\\Documents\\NetBeansProjects\\ProyectoGestorFacturas\\src\\main\\resources\\imagenes\\icons8-recuperar-48.png")); // NOI18N
        lblIcono.setText(bundle.getString("DeshacerFactura.lblIcono.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(429, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIcono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeshacer))
                    .addComponent(scrollPaneTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDeshacerFactura)
                    .addComponent(lblBotonDeshacer))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblDeshacerFactura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBotonDeshacer)
                .addGap(36, 36, 36)
                .addComponent(scrollPaneTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIcono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        try {
            if (ultimaFacturaEliminada != null) {
                //restauramos la última factura eliminada con su ID original
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
                FacturaJpaController ujpa = new FacturaJpaController(emf);
                ultimaFacturaEliminada.setBaja(0);
                ujpa.edit(ultimaFacturaEliminada);

                //actualizamos la tabla con la factura restaurada
                mostrarFacturasEnTabla();
                JOptionPane.showMessageDialog(this, "The invoice has been successfully restored",
                        "Restoring invoice...", JOptionPane.INFORMATION_MESSAGE);
                ultimaFacturaEliminada = null;
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
            java.util.logging.Logger.getLogger(DeshacerFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeshacerFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeshacerFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeshacerFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DeshacerFactura deshacerFactura = new DeshacerFactura();
                deshacerFactura.mostrarFacturasEnTabla();
                deshacerFactura.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JLabel lblBotonDeshacer;
    private javax.swing.JLabel lblDeshacerFactura;
    private javax.swing.JLabel lblIcono;
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

            //obtenemos la lista de facturas eliminadas
            List<Factura> listaFacturasEliminadas = ujpa.findFacturasEliminadas();

            //y así se actualiza el modelo de la tabla con la nueva lista de facturas eliminadas
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaListaFactura.getModel();

            //limpiamos la tabla antes de agregar las nuevas filas
            modeloTabla.setRowCount(0);

            //agregamos la información de cada factura eliminada a la tabla
            for (Factura factura : listaFacturasEliminadas) {
                DecimalFormat decimalFormat = new DecimalFormat("#");
                String cantidadFormateada = decimalFormat.format(factura.getCantidad());

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fechaFormateada = dateFormat.format(factura.getFecha());

                modeloTabla.addRow(new Object[]{factura.getId(), factura.getAsunto(), fechaFormateada,
                        cantidadFormateada, factura.getTipo(), factura.getCliente(), factura.getBaja()});
            }
            tablaListaFactura.setModel(modeloTabla);

            //agregamos un listener para manejar la selección en la tabla
            tablaListaFactura.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        //cogemos la fila seleccionada
                        int selectedRow = tablaListaFactura.getSelectedRow();
                        //verificamos que haya una fila seleccionada
                        if (selectedRow != -1) {
                            //obtenemos el ID de la factura seleccionada
                            int selectedFacturaId = (int) tablaListaFactura.getValueAt(selectedRow, 0);
                            //obtenemos la factura correspondiente al ID
                            ultimaFacturaEliminada = ujpa.findFactura(selectedFacturaId);
                        }
                    }
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
