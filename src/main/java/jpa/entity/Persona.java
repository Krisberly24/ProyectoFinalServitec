package jpa.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public abstract class Persona {
	
	@Id @GeneratedValue
	private int nId;
	
	@Column(nullable=false)
	private int nRut;
	   
	@Column(nullable=false, length=60)
	private String cNombre;
	
	@Column(nullable=false, length=60)
	private String cDireccion;

	@Column(nullable=false, length=20)
	private String cFono;
	
	// Constructor x defecto
	public Persona() {}

	// Constructor general
	public Persona(int nId, int nRut, String cNombre, String cDireccion, String cFono) {
		this.nId = nId;
		this.nRut = nRut;
		this.cNombre = cNombre;
		this.cDireccion = cDireccion;
		this.cFono = cFono;
	}

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	public int getnRut() {
		return nRut;
	}

	public void setnRut(int nRut) {
		this.nRut = nRut;
	}

	public String getcNombre() {
		return cNombre;
	}

	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}

	public String getcDireccion() {
		return cDireccion;
	}

	public void setcDireccion(String cDireccion) {
		this.cDireccion = cDireccion;
	}

	public String getcFono() {
		return cFono;
	}

	public void setcFono(String cFono) {
		this.cFono = cFono;
	}

}
