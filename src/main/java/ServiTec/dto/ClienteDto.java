package ServiTec.dto;

public class ClienteDto extends Persona {

	private String cEmail;
	
	// Constructor x defecto
	public ClienteDto() {}

	// Constructor general
	public ClienteDto(int nId, int nRut, String cNombre, String cDireccion, String cFono, String eMail) {
		super(nId, nRut, cNombre, cDireccion, cFono);

		this.cEmail = eMail;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String eMail) {
		this.cEmail = eMail;
	}

}
