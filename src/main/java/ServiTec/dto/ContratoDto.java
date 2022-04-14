package ServiTec.dto;

public class ContratoDto {

	private int nContrato;
	
	private String cNombre;
	private int nIdCliente;
	private String fDesde;

	private String fHasta;

	private int nPeriodicidad;
	
	// Constructor x defecto
	public ContratoDto() {}

	// Constructor general
	public ContratoDto
		(int nContrato, String cNombre, String fDesde, String fHasta, int nPeriodicidad) 
	{
		this.nContrato = nContrato;
		this.cNombre = cNombre;
		this.fDesde = fDesde;
		this.fHasta = fHasta;
		this.nPeriodicidad = nPeriodicidad;
	}
	public ContratoDto(int nContrato, int nIdCliente, String fDesde, String fHasta, int nPeriodicidad) 
	{
		this.nContrato = nContrato;
		this.nIdCliente = nIdCliente;
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

	public String getcNombre() {
		return cNombre;
	}

	public void setcNombre(String cNombre) {
		this.cNombre = cNombre;
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

	public int getnIdCliente() {
		return nIdCliente;
	}

	public void setnIdCliente(int nIdCliente) {
		this.nIdCliente = nIdCliente;
	}
	
	
}