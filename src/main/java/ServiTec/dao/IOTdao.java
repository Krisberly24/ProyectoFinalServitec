package ServiTec.dao;

import java.util.List;

import ServiTec.dto.OTdto;

public interface IOTdao {
	public int crear(OTdto ot);
	public int modificar(OTdto ot);
	public int eliminar(int idOT);
	public OTdto consultar(int idOT);
	public List<OTdto> listar();

}
