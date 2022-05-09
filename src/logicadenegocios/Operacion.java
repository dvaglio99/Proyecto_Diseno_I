/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadenegocios;

import java.util.Date;

/**
 *
 * @author chava
 */
public class Operacion {
    
  private Date fecha;
  private String tipoOperacion;
  private boolean cargoOperacion;
  private double monto;
  
  
  public Operacion(Date pFecha, String pTipoOperacion, boolean pCargoOperacion, double pMonto) {
	setFecha(pFecha);
	setTipoOperacion(pTipoOperacion);
	setCargoOperacion(pCargoOperacion);
	setMonto(pMonto);
  }

  public Date getFecha() {
	return fecha;
  }
  
  public String getTipoOperacion() {
	return tipoOperacion;
  }
  
  public boolean isCargoOperacion() {
	return cargoOperacion;
  }
  
  public double getMonto() {
	return monto;
  }
  
  public void setFecha(Date pFecha) {
	this.fecha = pFecha;
  }
  
  public void setTipoOperacion(String pTipoOperacion) {
	this.tipoOperacion = pTipoOperacion;
  }
 
  public void setCargoOperacion(boolean pCargoOperacion) {
	this.cargoOperacion = pCargoOperacion;
  }
  
  public void setMonto(double pMonto) {
	this.monto = pMonto;
  }      
    
}
