package ServiTec.service;

import ServiTec.entity.Usuario;

public interface IUsuarioService {
	public Usuario findByUsername(String username);
}
