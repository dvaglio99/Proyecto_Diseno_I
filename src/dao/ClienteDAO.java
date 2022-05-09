/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author chava
 */
public class ClienteDAO {
    
  Conexion conexion;
	
	public ClienteDAO() {
		
	  conexion = new Conexion();
	  
	}
	 public String registrarCliente(String primerApellido, String segundoApellido, String nombre,
			 String identificacion, String fechaNacimiento, String numeroTelefonico,String correoElectronico) throws IOException {
		 
		 	String resultado = null;
		   
		    	try {
		    	 Connection conect = conexion.Conexion();    
		         CallableStatement cstmt = conect.prepareCall("{call dbo.registrarCliente(?,?,?,?,?,?,?)}");
		         cstmt.setString(1, primerApellido);
		         cstmt.setString(2, segundoApellido);
		         cstmt.setString(3, nombre);
		         cstmt.setString(4, identificacion);
		         cstmt.setString(5, fechaNacimiento);
		         cstmt.setString(6, numeroTelefonico);
		         cstmt.setString(7, correoElectronico);
		         int respuesta = cstmt.executeUpdate();
		         
		         if (respuesta > 0 ) {
		        	
		           resultado = "Registro exitoso";
		         }
		       } catch (SQLException e) {
		    	   resultado = ("Error: Revise que los datos que esta ingresando coincidan con los formatos pedidos"
			    	  		+ " y vuelva a intentarlo.");
		       }
		      
		     return resultado;
		  }    

    public void consultarClientesOrdenados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
