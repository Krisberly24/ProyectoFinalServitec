package ServiTec.dto;

public class OTdto {

	private int nId;
	
	private int nContrato;

	private int nIdSupervisor;
	
	private String fProgramada;
	
	private String fEjecucion;

	private String cObservaciones;

	// Constructor x defecto
	public OTdto() {}

	// Constructor general
	public OTdto(int nId, int nContrato, int nIdSupervisor, String fProgramada, String fEjecucion,
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
