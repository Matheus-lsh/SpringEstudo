package ms.group.contato.dao.service;

import org.springframework.stereotype.Service;

import ms.group.contato.dao.UserDao;
import ms.group.contato.dao.modelo.TipoUser;
import ms.group.contato.dao.modelo.Usuario;

@Service
public class ServiceUser {
	private final UserDao userDao;
	
	public ServiceUser(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public boolean adicionaUsuario(String nome,String user,String senha) {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setUser(TipoUser.valueOf(user.toUpperCase()));
		usuario.setSenha(senha);
		return userDao.cadastrarUser(usuario);
	}
}
