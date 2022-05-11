package controlador;

import dao.ClienteDAO;
import dao.CuentaDAO;
import vista.MenuConsultasAdicionales;
import vista.ConsultarClientesOrdenados;
import vista.ConsultarInformacionClienteCuentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.ConsultarCuentasOrdenadas;
import vista.ConsultarInformacionCuentas;


/**
 * Abstraccion de la clase ControladorMenuConsultasAdicionales
 * Clase que utiliza las funcionalidades de la vista del menu de consultas adicionales
 * @author Daniel Vaglio Fallas y Jafet Chavarria Moreno
 * @version Proyecto Programado I
 */
public class ControladorMenuConsultasAdicionales implements ActionListener {
  public MenuConsultasAdicionales vistaConsultasAdicionales;
  
  /**
   * Metodo Constructor
   * @param pVista despliega la vista del menu de consultas adicionales
   */
  public ControladorMenuConsultasAdicionales(MenuConsultasAdicionales pVista) {
    vistaConsultasAdicionales = pVista;

    this.vistaConsultasAdicionales.btnConsultarClientesOrdenados.addActionListener(this);
    this.vistaConsultasAdicionales.btnConsultarInformacionCliente.addActionListener(this);
    this.vistaConsultasAdicionales.btnConsultarCuentasOrdenadas.addActionListener(this);
    this.vistaConsultasAdicionales.btnConsultarInformacionCuentaParticular.addActionListener(this);
    this.vistaConsultasAdicionales.btnConsultarListaDeCursos.addActionListener(this); 
    this.vistaConsultasAdicionales.btnVolver.addActionListener(this);
  }
  
  /**
   * Metodo para accionar y ejecutar los botones de la vista
   * @param e recibe la accion del boton
   */  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vistaConsultasAdicionales.btnConsultarClientesOrdenados) {
      consultarClientesOrdenados();
    }
    if (e.getSource() == vistaConsultasAdicionales.btnConsultarInformacionCliente) {
      consultarInformacionClienteParticular();
    }
    if (e.getSource() == vistaConsultasAdicionales.btnConsultarCuentasOrdenadas) {
      consultarCuentasOrdenadas();
    }
    if (e.getSource() == vistaConsultasAdicionales.btnConsultarInformacionCuentaParticular) {
      consultarInformacionCuentaParticular();
    }
    if (e.getSource() == vistaConsultasAdicionales.btnVolver) {
      this.vistaConsultasAdicionales.setVisible(false);
    } 
  }
 
  public void consultarClientesOrdenados() {
    ConsultarClientesOrdenados consulta = new ConsultarClientesOrdenados();
    ClienteDAO clienteDao = new ClienteDAO();
    ControladorCliente controlador = new ControladorCliente(consulta,clienteDao);
    controlador.vistaConsultarClientesOrdenados.setVisible(true);
    ResultSet rs;
    JTable tabla;
    DefaultTableModel dfm = new DefaultTableModel();
    rs = clienteDao.consultarClientesOrdenados();
    tabla = consulta.tablaClientesOrdenados;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Primer Apellido","Segundo Apellido", "Nombre", 
        "Identificacion"});
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("PrimerApellido"), rs.getString("SegundoApellido"),
            rs.getString("Nombre"), rs.getInt("Identificacion")});
      }    
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
  }
  
  public void consultarInformacionClienteParticular(){
    ConsultarInformacionClienteCuentas consulta = new ConsultarInformacionClienteCuentas();
    ClienteDAO clienteDao = new ClienteDAO();
    ControladorCliente controlador = new ControladorCliente(consulta, clienteDao);
    controlador.vistaConsultarInformacionClienteCuentas.setVisible(true);
  }
  
  public void consultarCuentasOrdenadas() {
    ConsultarCuentasOrdenadas consulta = new ConsultarCuentasOrdenadas();
    CuentaDAO cuentaDao = new CuentaDAO();
    ControladorCuenta controlador = new ControladorCuenta(consulta,cuentaDao);
    controlador.vistaConsultarCuentasOrdenadas.setVisible(true);
    ResultSet rs;
    JTable tabla;
    DefaultTableModel dfm = new DefaultTableModel();
    rs = cuentaDao.consultarCuentasOrdenadas();
    tabla = consulta.tablaCuentasOrdenadas;
    tabla.setModel(dfm);
    dfm.setColumnIdentifiers(new Object[]{"Numero Cuenta", "Estado","Saldo","Identificacion",
        "Primer Apellido", "Segundo Apellido","Nombre"});
    try {
      while (rs.next()) {
        dfm.addRow(new Object[] {rs.getString("Numero_Cuenta"),rs.getString("Estado"),rs.getDouble("Saldo"),
            rs.getInt("Identificacion"),rs.getString("PrimerApellido"), rs.getString("SegundoApellido"),
            rs.getString("Nombre")});
      }    
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,ex); 
    }
  }
  
  public void consultarInformacionCuentaParticular(){
    ConsultarInformacionCuentas consulta = new ConsultarInformacionCuentas();
    CuentaDAO cuentaDao = new CuentaDAO();
    ControladorCuenta controlador = new ControladorCuenta(consulta, cuentaDao);
    controlador.vistaConsultarInformacionCuentas.setVisible(true);
  }
}
