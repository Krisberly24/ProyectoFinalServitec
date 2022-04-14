package jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrdenTrabajo")
public class OrdenTrabajoTbl {

	@Id @GeneratedValue
	private int nId;
	
	@Column(nullable=false)
	private int nContrato;

	@Column(nullable=false)
	private int nIdSupervisor;
	
	@Column(nullable=false, length=10)
	private String fProgramada;
	
	@Column(nullable=false, length=10)
	private String fEjecucion;

	@Column(nullable=false, length=90)
	private String cObservaciones;

	// Constructor x defecto
	public OrdenTrabajoTbl() {}

	// Constructor general
	public OrdenTrabajoTbl(int nId, int nContrato, int nIdSupervisor, String fProgramada, String fEjecucion,
			String cObservaciones) {
		this.nId = nId;
		this.nContrato = nContrato;
		this.nIdSupervisor = nIdSupervisor;
		this.fProgramada = fProgramada;
		this.fEjecucion = fEjecucion;
		this.cObservaciones = cObservaciones;
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

	public int getnIdSupervisor() {
		return nIdSupervisor;
	}

	public void setnIdSupervisor(int nIdSupervisor) {
		this.nIdSupervisor = nIdSupervisor;
	}

	public String getfProgramada() {
		return fProgramada;
	}

	public void setfProgramada(String fProgramada) {
		this.fProgramada = fProgramada;
	}

	public String getfEjecucion() {
		return fEjecucion;
	}

	public void setfEjecucion(String fEjecucion) {
		this.fEjecucion = fEjecucion;
	}

	public String getcObservaciones() {
		return cObservaciones;
	}

	public void setcObservaciones(String cObservaciones) {
		this.cObservaciones = cObservaciones;
	}

}
