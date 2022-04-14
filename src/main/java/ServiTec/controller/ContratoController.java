package ServiTec.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ServiTec.dao.IContratoDao;
import ServiTec.dto.ClienteDto;
import ServiTec.dto.ContratoDto;

@Controller
@RequestMapping("/contrato")
public class ContratoController {
	@Autowired
	private IContratoDao contrato;
	
	@RequestMapping("/listar")
	public @ResponseBody List<ContratoDto> listar(HttpServletRequest req) {
		int nContrato = Integer.parseInt(req.getParameter("nContrato"));
		return contrato.listar(nContrato);
	}
	
	@RequestMapping("/eliminar")
	public @ResponseBody int eliminar(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		
		return contrato.eliminar( id );
	}
	
	@RequestMapping("/crear")
	public @ResponseBody long crear(HttpServletRequest req) {
		int nIdCliente = Integer.parseInt(req.getParameter("nIdCliente"));
		String fDesde = req.getParameter("fDesde");
		String fHasta = req.getParameter("fHasta");
		int nPeriodicidad = Integer.parseInt(req.getParameter("nPeriodicidad"));
		
		return contrato.crear(new ContratoDto(0,nIdCliente , fDesde, fHasta, nPeriodicidad));
	}
	
	@RequestMapping("/modificar")
	public @ResponseBody int modificar(HttpServletRequest req) {
		
		int nContrato = Integer.parseInt(req.getParameter("id"));
		int nIdCliente = 0;//Integer.parseInt(req.getParameter("nIdCliente"));
		String fDesde = req.getParameter("fDesde");
		String fHasta = req.getParameter("fHasta");
		int nPeriodicidad = Integer.parseInt(req.getParameter("nPeriodicidad"));
		
		
		return contrato.modificar(new ContratoDto(nContrato ,nIdCliente,fDesde,fHasta, nPeriodicidad));
	}
	
	
}
