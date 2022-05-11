/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.CuentaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logicadenegocios.Cuenta;
import vista.CambiarPIN;
import vista.ConsultarCuentasOrdenadas;
import vista.ConsultarInformacionCuentas;

/**
 *
 * @author USUARIO
 */
public class ControladorCuenta implements ActionListener {
  Conexion conexion;
  public ResultSet rs;
  public JTable tabla;
  public ConsultarCuentasOrdenadas vistaConsultarCuentasOrdenadas = new ConsultarCuentasOrdenadas();
  public ConsultarInformacionCuentas vistaConsultarInformacionCuentas = 
    new ConsultarInformacionCuentas();
  public CambiarPIN vistaCambiarPIN = new CambiarPIN();
  public Cuenta cuenta;
  public CuentaDAO cuentaDao;
  
  public ControladorCuenta(ConsultarCuentasOrdenadas pVistaConsultarCuentasOrdenadas, 
          CuentaDAO pModelo) {
    vistaConsultarCuentasOrdenadas = pVistaConsultarCuentasOrdenadas;
    cuentaDao = pModelo;

    this.vistaConsultarCuentasOrdenadas.btnVolver.addActionListener(this);
  }
  public ControladorCuenta(ConsultarInformacionCuentas pVistaConsultarInformacionCuentas, 
          CuentaDAO pModelo) {
    vistaConsultarInformacionCuentas = pVistaConsultarInformacionCuentas;
    cuentaDao = pModelo;

    this.vistaConsultarInformacionCuentas.btnBuscar.addActionListener(this);
    this.vistaConsultarInformacionCuentas.btnVolver.addActionListener(this);
  }
  
  public ControladorCuenta(CambiarPIN pVistaCambiarPIN, 
          CuentaDAO pModelo) {
    vistaCambiarPIN = pVistaCambiarPIN;
    cuentaDao = pModelo;

    this.vistaCambiarPIN.btnCambiarPIN.addActionListener(this);
    this.vistaCambiarPIN.btnVolver.addActionListener(this);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vistaConsultarInformacionCuentas.btnBuscar){
        consultarInformacionCuentaParticular();
    }
    if (e.getSource() == vistaConsultarInformacionCuentas.btnVolver) {
        this.vistaConsultarInformacionCuentas.setVisible(false);
    }
    if (e.getSource() == vistaConsultarCuentasOrdenadas.btnVolver) {
        this.vistaConsultarCuentasOrdenadas.setVisible(false);
    }
    if (e.getSource() == vistaCambiarPIN.btnVolver) {
        this.vistaCambiarPIN.setVisible(false);
    }
    
  }
  
   public void consultarInformacionCuentaParticular(){
    String cuenta = vistaConsultarInformacionCuentas.cbxCuentas.getSelectedItem().
        toString();
    rs = cuentaDao.consultarInformacionCuentaParticular(cuenta);
    DefaultTableModel dfm = new DefaultTableModel();
    tabla = vistaConsultarInformacionCuentas.tablaInformeCuentaParticular;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Numero Cuenta","PIN", "ID duenio", "Fecha Creacion",
        "Saldo","Estado", "Primer Apellido", "Segundo Apellido", "Nombre"});
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("Numero_Cuenta"), rs.getString("PIN"),
        rs.getString("ID_Duenio_Cuenta"),rs.getString("FechaCreacion"), rs.getDouble("Saldo"),
        rs.getString("Estado"), rs.getString("PrimerApellido"), rs.getString("SegundoApellido"),
        rs.getString("Nombre")});
      }    
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
  }    
}
