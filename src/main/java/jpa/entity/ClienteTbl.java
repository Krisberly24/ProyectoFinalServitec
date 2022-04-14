package jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Cliente")
public class ClienteTbl extends Persona {

	@Column(nullable=false, length=50)
	private String eMail;
	
	// Constructor x defecto
	public ClienteTbl() {}

	// Constructor general
	public ClienteTbl(int nId, int nRut, String cNombre, String cDireccion, String cFono, String eMail) {
		super(nId, nRut, cNombre, cDireccion, cFono);

		this.eMail = eMail;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

}
