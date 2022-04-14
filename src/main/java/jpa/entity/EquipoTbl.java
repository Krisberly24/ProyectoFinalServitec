package jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EquipoContrato")
public class EquipoTbl {
	
	@Id @GeneratedValue
	private int nId;
	
	@Column(nullable=false)
	private int nContrato;
	
	@Column(nullable=false, length=40)
	private String cNombre;
	
	// Constructor x defecto
	public EquipoTbl() {}

	// Constructor general
	public EquipoTbl(int nId, int nContrato, String cNombre) {
		this.nId = nId;
		this.nContrato = nContrato;
		this.cNombre = cNombre;
	}

	
	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	public int getnContrato() {
		return nContrato;
	}

	public void setnContrato(int nContrato) {
		this.nContrato = nContrato;
	}

	public String getcNombre() {
		return cNombre;
	}

	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
	}

}
