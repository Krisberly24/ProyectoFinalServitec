package jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ContratoMantencion")
public class ContratoTbl {

	@Id @GeneratedValue
	private int nContrato;
	
	@Column(nullable=false)
	private ClienteTbl clienteTbl;
	
	@Column(nullable=false, length=10)
	private String fDesde;

	@Column(nullable=false, length=10)
	private String fHasta;

	@Column(nullable=false)
	private int nPeriodicidad;
	
	// Constructor x defecto
	public ContratoTbl() {}

	// Constructor general
	public ContratoTbl
		(int nContrato, ClienteTbl clienteTbl, String fDesde, String fHasta, int nPeriodicidad) 
	{
		this.nContrato = nContrato;
		this.clienteTbl = clienteTbl;
		this.fDesde = fDesde;
		this.fHasta = fHasta;
		this.nPeriodicidad = nPeriodicidad;
	}

	
	public int getnContrato() {
		return nContrato;
	}

	public void setnContrato(int nContrato) {
		this.nContrato = nContrato;
	}

	public ClienteTbl getCliente() {
		return clienteTbl;
	}

	public void setCliente(ClienteTbl clienteTbl) {
		this.clienteTbl = clienteTbl;
	}

	public String getfDesde() {
		return fDesde;
	}

	public void setfDesde(String fDesde) {
		this.fDesde = fDesde;
	}

	public String getfHasta() {
		return fHasta;
	}

	public void setfHasta(String fHasta) {
		this.fHasta = fHasta;
	}

	public int getnPeriodicidad() {
		return nPeriodicidad;
	}

	public void setnPeriodicidad(int nPeriodicidad) {
		this.nPeriodicidad = nPeriodicidad;
	}

}
