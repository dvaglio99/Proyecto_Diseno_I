package controlador;

import dao.CuentaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logicadenegocios.Cliente;
import logicadenegocios.Cuenta;
import vista.CambiarPIN;
import vista.MenuConsultasAdicionales;
import vista.MenuOpciones;
import vista.RegistrarCliente;
import vista.RegistrarCuenta;

public class ControladorMenuOpciones implements ActionListener{
  public MenuOpciones vista;
  
  public ControladorMenuOpciones(MenuOpciones pVista) {
    vista = pVista;
    
    this.vista.btnRegistrarCliente.addActionListener(this);
    this.vista.btnConsultasAdicionales.addActionListener(this);
    this.vista.btnCambiarPIN.addActionListener(this);
    this.vista.btnSalir.addActionListener(this);
    this.vista.btnRegistrarCuenta.addActionListener(this);
  }

@Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vista.btnRegistrarCliente) {
      registrarCliente();
    }
    if (e.getSource() == vista.btnConsultasAdicionales) {
      mostrarConsultasAdicionales();
    }
    if (e.getSource() == vista.btnCambiarPIN) {
      cambiarPIN();
    }
    if (e.getSource() == vista.btnSalir) {
      System.exit(0);
      this.vista.setVisible(false);
    }
    if (e.getSource() == vista.btnRegistrarCuenta) {
        registrarCuenta();
        
    }
  }

  private void registrarCliente() {
    RegistrarCliente registro = new RegistrarCliente();
    Cliente cliente = new Cliente();
    ControladorCliente controlador = new ControladorCliente(registro, cliente);
    controlador.vistaRegistrarCliente.setVisible(true);
    
  }
  
  public void mostrarConsultasAdicionales() {
    MenuConsultasAdicionales menu = new MenuConsultasAdicionales();
    ControladorMenuConsultasAdicionales controlador = new ControladorMenuConsultasAdicionales(menu);
    controlador.vistaConsultasAdicionales.setVisible(true);
  }
  
  public void cambiarPIN() {
    CambiarPIN cambio = new CambiarPIN();
    CuentaDAO cuentaDao = new CuentaDAO();
    ControladorCuenta controlador = new ControladorCuenta(cambio, cuentaDao);
    controlador.vistaCambiarPIN.setVisible(true);
  }
  
  public void registrarCuenta() {
      
      RegistrarCuenta nuevaCuenta = new RegistrarCuenta();
      Cuenta cuenta = new Cuenta();
      ControladorCuenta controlador = new ControladorCuenta(nuevaCuenta, cuenta);
      controlador.vistaRegistrarCuenta.setVisible(true);
      
  }
}