package com.model;
public class Ubigeo {
  
  private String idubigeo;
  private String departamento;
  private String provincia;
  private String distrito;

  public String getIdubigeo() {
    return idubigeo;
  }

  public void setIdubigeo(String idubigeo) {
    this.idubigeo = idubigeo;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  public String getProvincia() {
    return provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

  public String getDistrito() {
    return distrito;
  }

  public void setDistrito(String distrito) {
    this.distrito = distrito;
  }
  
  @Override
	public String toString() {
		return "Ubigeo [id=" + idubigeo + ", departamento=" + departamento	+ ", provincia=" + provincia + ", distrito=" + distrito + "]";
	}
  
}
