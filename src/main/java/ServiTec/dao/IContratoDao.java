package ServiTec.dao;

import java.util.List;

import ServiTec.dto.ContratoDto;

public interface IContratoDao {
	public int crear(ContratoDto contrato);
	public int modificar(ContratoDto contrato);
	public int eliminar(int nContrato);
	public ContratoDto consultar(int nContrato);
	public List<ContratoDto> listar(int nContrato);

}
