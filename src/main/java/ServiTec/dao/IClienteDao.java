package ServiTec.dao;

import java.util.List;

import ServiTec.dto.ClienteDto;

public interface IClienteDao {
	public int crear(ClienteDto cliente);
	public int modificar(ClienteDto cliente);
	public int eliminar(int idClte);
	public ClienteDto consultar(int idClte);
	public List<ClienteDto> listar();
}
