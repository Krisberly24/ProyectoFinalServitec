package ServiTec.dao;

import java.util.List;

import ServiTec.dto.EquipoDto;

public interface IEquipoDao {
	public int crear(EquipoDto equipo);
	public int modificar(EquipoDto equipo);
	public int eliminar(int idEquipo);
	public EquipoDto consultar(int idEquipo);
	public List<EquipoDto> listar();

}
