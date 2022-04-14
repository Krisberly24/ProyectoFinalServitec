package jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Personal")
public class PersonalTbl extends Persona {

	// Constructor x defecto
	public PersonalTbl() {}

	// Constructor general
	public PersonalTbl(int nId, int nRut, String cNombre, String cDireccion, String cFono) {
		super(nId, nRut, cNombre, cDireccion, cFono);
	}

}
