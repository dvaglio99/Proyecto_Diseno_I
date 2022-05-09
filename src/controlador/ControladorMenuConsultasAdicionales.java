package controlador;

import dao.ClienteDAO;
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
    this.vistaConsultasAdicionales.btnConsultarPlanDeEstudioCursoParticular.addActionListener(this);
    this.vistaConsultasAdicionales.btnConsultarCorrequisitoCurso.addActionListener(this);
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
    /*if (e.getSource() == vistaConsultasAdicionales.btnVolver) {
      this.vistaConsultasAdicionales.setVisible(false);
    } */
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
}
