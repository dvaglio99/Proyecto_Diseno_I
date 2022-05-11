package vista;

import dao.CuentaDAO;


/**
 * Vista para consultar el plan de estudio de un curso en particular
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class CambiarPIN extends javax.swing.JFrame {
  public CambiarPIN() {
    initComponents();
    llenarCbxCuentas();
  }

  /**
   * Metodo para llenar el ComboBox de escuelas
   */
  public void llenarCbxCuentas() {
    CuentaDAO cuentaDao = new CuentaDAO();
    cbxCuentas.setModel(cuentaDao.llenarComboBox());
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConsulta = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblNombreEscuela = new javax.swing.JLabel();
        cbxCuentas = new javax.swing.JComboBox<>();
        btnCambiarPIN = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblNombreEscuela1 = new javax.swing.JLabel();
        lblNombreEscuela2 = new javax.swing.JLabel();
        lblNombreEscuela3 = new javax.swing.JLabel();
        txtPIN = new javax.swing.JPasswordField();
        txtNuevoPIN = new javax.swing.JPasswordField();
        txtNuevoNuevoPIN = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelConsulta.setBackground(new java.awt.Color(0, 102, 102));

        lblTitulo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 28)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Cambiar PIN de la cuenta");

        lblNombreEscuela.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela.setText("Seleccione un numero de cuenta existente : ");

        cbxCuentas.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        cbxCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCuentasActionPerformed(evt);
            }
        });

        btnCambiarPIN.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        btnCambiarPIN.setText("Cambiar PIN");
        btnCambiarPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarPINActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblNombreEscuela1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela1.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela1.setText("Ingrese el nuevo PIN de la cuenta:");

        lblNombreEscuela2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela2.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela2.setText("Ingrese el PIN de la cuenta:");

        lblNombreEscuela3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        lblNombreEscuela3.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEscuela3.setText("Ingrese nuevamente el nuevo PIN de la cuenta:");

        javax.swing.GroupLayout panelConsultaLayout = new javax.swing.GroupLayout(panelConsulta);
        panelConsulta.setLayout(panelConsultaLayout);
        panelConsultaLayout.setHorizontalGroup(
            panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaLayout.createSequentialGroup()
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver)
                        .addGap(181, 181, 181)
                        .addComponent(lblTitulo))
                    .addGroup(panelConsultaLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreEscuela)
                            .addComponent(lblNombreEscuela1)
                            .addComponent(lblNombreEscuela2)
                            .addComponent(lblNombreEscuela3))
                        .addGap(18, 18, 18)
                        .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxCuentas, 0, 352, Short.MAX_VALUE)
                            .addComponent(txtPIN)
                            .addComponent(txtNuevoPIN)
                            .addComponent(txtNuevoNuevoPIN)))
                    .addGroup(panelConsultaLayout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(btnCambiarPIN)))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        panelConsultaLayout.setVerticalGroup(
            panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo))
                .addGap(18, 18, 18)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEscuela2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEscuela1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNuevoPIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEscuela3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNuevoNuevoPIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(btnCambiarPIN)
                .addGap(113, 113, 113))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCuentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCuentasActionPerformed

    private void btnCambiarPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarPINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCambiarPINActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(CambiarPIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CambiarPIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CambiarPIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CambiarPIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CambiarPIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCambiarPIN;
    public javax.swing.JButton btnVolver;
    public javax.swing.JComboBox<String> cbxCuentas;
    private javax.swing.JLabel lblNombreEscuela;
    private javax.swing.JLabel lblNombreEscuela1;
    private javax.swing.JLabel lblNombreEscuela2;
    private javax.swing.JLabel lblNombreEscuela3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelConsulta;
    private javax.swing.JPasswordField txtNuevoNuevoPIN;
    private javax.swing.JPasswordField txtNuevoPIN;
    private javax.swing.JPasswordField txtPIN;
    // End of variables declaration//GEN-END:variables
}
