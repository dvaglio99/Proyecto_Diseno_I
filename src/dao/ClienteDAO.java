package dao;

import java.io.IOException;

import logicadenegocios.Cliente;
import validaciones.Validaciones;
import conexion.Conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;



public class ClienteDAO {
	Conexion conexion;
	
  public ClienteDAO() {
    conexion = new Conexion();
  }

  public DefaultComboBoxModel llenarComboBox() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    try {
      CallableStatement cmd = conexion.Conexion().prepareCall("{CALL [dbo].[Combo_IdentificacionClientes]}");
      ResultSet resultado = cmd.executeQuery();    
      while (resultado.next()) {
        modelo.addElement(resultado.getString(1));
      }
    } catch (SQLException e) {
    }
      return modelo;
  }
  
  public void registrarCliente(String primerApellido, String segundoApellido, String nombre,
          String identificacion, String fechaNacimiento, String numeroTelefonico,String correoElectronico) throws IOException {
    PreparedStatement ps;
    Connection conect = conexion.Conexion();    		   
    try {
      CallableStatement cstmt2 = conect.prepareCall("{call dbo.registrarPersona(?,?,?,?,?,?,?)}");
      cstmt2.setString(1, primerApellido);
      cstmt2.setString(2, segundoApellido);
      cstmt2.setString(3, nombre);
      cstmt2.setString(4, identificacion);
      cstmt2.setString(5, fechaNacimiento);
      cstmt2.setString(6, numeroTelefonico);
      cstmt2.setString(7, correoElectronico);
      cstmt2.executeUpdate();
      CallableStatement cstmt = conect.prepareCall("{call dbo.registrarCliente(?,?,?,?,?,?,?)}");
      cstmt.setString(1, primerApellido);
      cstmt.setString(2, segundoApellido);
      cstmt.setString(3, nombre);
      cstmt.setString(4, identificacion);
      cstmt.setString(5, fechaNacimiento);
      cstmt.setString(6, numeroTelefonico);
      cstmt.setString(7, correoElectronico);
      cstmt.executeUpdate();		         
    } catch (SQLException e) {
      System.err.println(e);
    }
    finally{
      try{
        conect.close();
      } catch(SQLException e){
	System.err.println(e);
      }
    }  
  }
  public ResultSet consultarClientesOrdenados() {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.ordenarClientesAscendentemente");
    } catch (SQLException e) {
    }  
    return rs;
  }
  
  public ResultSet consultarInformacionClienteParticular(String pCliente) {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.consultarInformacionClienteParticular '" 
          + pCliente +"'");
    } catch (SQLException ex) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

    }  
    return rs;
  }
}
