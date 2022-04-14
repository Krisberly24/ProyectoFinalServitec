package ServiTec.dto;

public abstract class Persona {
	
	private int nId;
	
	private int nRut;
	   
	private String cNombre;
	
	private String cDireccion;

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
