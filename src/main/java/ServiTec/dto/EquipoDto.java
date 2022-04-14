package ServiTec.dto;

public class EquipoDto {
	
	private int nId;
	
	private int nContrato;
	
	private String cNombre;
	
	// Constructor x defecto
	public EquipoDto() {}

	// Constructor general
	public EquipoDto(int nId, int nContrato, String cNombre) {
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
