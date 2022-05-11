/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author USUARIO
 */
public class CuentaDAO {
  Conexion conexion;
  
  public CuentaDAO() {
    conexion = new Conexion();
  }
  
  public DefaultComboBoxModel llenarComboBox() {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    try {
      CallableStatement cmd = conexion.Conexion().prepareCall("{CALL [dbo].[Combo_NumeroCuenta]}");
      ResultSet resultado = cmd.executeQuery();    
      while (resultado.next()) {
        modelo.addElement(resultado.getString(1));
      }
    } catch (SQLException e) {
    }
      return modelo;
  }
    
  public ResultSet consultarCuentasOrdenadas() {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.ordenarCuentasDescendentemente");
    } catch (SQLException e) {
    }  
    return rs;
  }
  
  public ResultSet consultarInformacionCuentaParticular(String pCuenta) {
    Statement ejecutor;
    ResultSet rs = null;
    try {
      Connection con = conexion.Conexion();
      ejecutor = con.createStatement();
      rs = ejecutor.executeQuery("execute dbo.consultarInformacionCuentaParticular '" 
          + pCuenta +"'");
    } catch (SQLException ex) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

    }  
    return rs;
  }
  
  public boolean cambiarPIN(String pPIN, String pNumeroCuenta) {
      return false;
  }
}
