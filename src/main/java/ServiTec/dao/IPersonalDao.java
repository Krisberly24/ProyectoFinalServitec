package ServiTec.dao;

import java.util.List;

import ServiTec.dto.PersonalDto;

public interface IPersonalDao {
	public int crear(PersonalDto persona);
	public int modificar(PersonalDto persona);
	public int eliminar(String idPersona);
	public PersonalDto consultar1(int idPersona);
	public List<PersonalDto> todos();

}
