package ServiTec.dto;

public class PersonalDto extends Persona {

	// Constructor x defecto
	public PersonalDto() {}

	// Constructor general
	public PersonalDto(int nId, int nRut, String cNombre, String cDireccion, String cFono) {
		super(nId, nRut, cNombre, cDireccion, cFono);
	}

}
