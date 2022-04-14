package ServiTec.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ServiTec.dto.ClienteDto;

@Repository
@Transactional
public class ClienteDao implements IClienteDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ClienteDao() {}

	@Override
	public int crear(ClienteDto cliente) {
		// Si la inserción es exitosa, retorna la ID asignada al nuevo cliente.
		// Si falla, retorna 0.
		int ret = 0;
		
		String sql = "INSERT INTO Cliente (nRut, cNombre, cDireccion, cFono, cEMail) "+
							"VALUES(?,?,?,?,?)";
		Object[] args = {cliente.getnRut(), cliente.getcNombre(), cliente.getcDireccion(),
							cliente.getcFono(), cliente.getcEmail()
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
	public int modificar(ClienteDto cliente) {
		// Retorna 0 si falla; >0 si tiene éxito.
		int ret = 0;
		
		String sql = "UPDATE Cliente Set nRut=?, cNombre=?, cDireccion=?, cFono=?, cEMail=? "+
						" WHERE nId = ?"	;
		Object[] args = {cliente.getnRut(), cliente.getcNombre(), cliente.getcDireccion(),
						 cliente.getcFono(), cliente.getcEmail(), cliente.getnId()
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
	public int eliminar(int idClte) {
		// Retorna 0 si falla; > 0, si tiene éxito.
		int ret = 0;
		
		String sql = "DELETE FROM Cliente WHERE nId = ?";
		Object[] args = { idClte };
		
		try {
			ret = jdbcTemplate.update(sql, args);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return ret;
	}

	@Override
	public ClienteDto consultar(int idClte) {
		ClienteDto ret = null;
		String qry = "SELECT * FROM Cliente WHERE nId = ?";;
		Object args[] = {idClte};

		try {
			ret = jdbcTemplate.queryForObject
				(qry, BeanPropertyRowMapper.newInstance(ClienteDto.class), args );
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ret;
	}

	@Override
	public List<ClienteDto> listar() {
		List<ClienteDto> ret = null;
		String qry = "SELECT * FROM Cliente";
		
		try {
			ret = jdbcTemplate.query
					(qry, BeanPropertyRowMapper.newInstance(ClienteDto.class) );
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return ret;
	}

}
