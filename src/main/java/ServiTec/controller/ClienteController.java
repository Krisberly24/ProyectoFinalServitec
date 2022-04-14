package ServiTec.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ServiTec.dao.IClienteDao;
import ServiTec.dto.ClienteDto;


@Controller
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private IClienteDao cliente;
	
	@RequestMapping("/crear")
	public @ResponseBody long crear(HttpServletRequest req) {
		int rut = Integer.parseInt(req.getParameter("rut"));
		String nom = req.getParameter("nombre");
		String dir = req.getParameter("direccion");
		String fono = req.getParameter("fono");
		String email = req.getParameter("email");
		
		return cliente.crear( new ClienteDto( 0, rut, nom, dir, fono, email ) );
	}
	
	@RequestMapping("/modificar")
	public @ResponseBody int modificar(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		int rut = Integer.parseInt(req.getParameter("rut"));
		String nom = req.getParameter("nombre");
		String dir = req.getParameter("direccion");
		String fono = req.getParameter("fono");
		String email = req.getParameter("email");
		
		return cliente.modificar( new ClienteDto( id, rut, nom, dir, fono, email ) );
	}
	
	@RequestMapping("/eliminar")
	public @ResponseBody int eliminar(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		
		return cliente.eliminar( id );
	}

	@RequestMapping("/consultar")
	public @ResponseBody ClienteDto consultar(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));

		return cliente.consultar( id );
	}

	@RequestMapping("/listar")
	public @ResponseBody List<ClienteDto> listar(HttpServletRequest req) {
		return cliente.listar();
	}
}

