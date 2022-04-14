package ServiTec.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ServiTec.dto.ContratoDto;

@Repository
@Transactional
public class ContratoDao implements IContratoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ContratoDao() {}

	@Override
	public int crear(ContratoDto contrato) {
	int ret = 0;
			
			String sql = "INSERT INTO contratomantencion (nIdCliente, fDesde, fHasta, nPeriodicidad) "+
								"VALUES(?,?,?,?)";
			Object[] args = {contrato.getnIdCliente(),contrato.getfDesde() , contrato.getfHasta(),
								contrato.getnPeriodicidad()
							};
			
			try {
				ret = jdbcTemplate.update(sql, args);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return ret;
		}

	@Override
	public int modificar(ContratoDto contrato) {
		int ret = 0;
		
		String sql = "UPDATE contratomantencion Set fDesde=?, fHasta=?, nPeriodicidad=? "+
						" WHERE nContrato = ?"	;
		Object[] args = {contrato.getfDesde() , contrato.getfHasta(),
				contrato.getnPeriodicidad(), contrato.getnContrato()
			};
		
		try {
			ret = jdbcTemplate.update(sql, args);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return ret;
	}

	@Override
	public int eliminar(int nContrato) {
		// Retorna 0 si falla; > 0, si tiene éxito.
				int ret = 0;
				
				String sql = "DELETE FROM contratomantencion WHERE nContrato = ?";
				Object[] args = {nContrato};
				
				try {
					ret = jdbcTemplate.update(sql, args);
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				return ret;
	}

	@Override
	public ContratoDto consultar(int nContrato) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<ContratoDto> listar(int nContrato) {
		// TODO Auto-generated method stub
		List<ContratoDto> ret = null;
		String qry = "SELECT * FROM contratomantencion join cliente on contratomantencion.nIdCliente = cliente.nId";
		
		if(nContrato>0)
		{
			qry += " where nContrato = " + nContrato;
			
		}
		try {
			ret = jdbcTemplate.query
					(qry, BeanPropertyRowMapper.newInstance(ContratoDto.class) );
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return ret;
	}


}
