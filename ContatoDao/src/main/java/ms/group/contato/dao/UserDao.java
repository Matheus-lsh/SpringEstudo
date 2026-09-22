package ms.group.contato.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import ms.group.contato.dao.modelo.Usuario;

@Repository
public class UserDao {
	private final JdbcTemplate jdbcTemplate;
	private final PasswordEncoder passwordEncoder;
	
	public UserDao(JdbcTemplate jdbcTemplate,PasswordEncoder passwordEncoder) {
		this.jdbcTemplate = jdbcTemplate;
		this.passwordEncoder = passwordEncoder;
	}
	
	public boolean cadastrarUser(Usuario usuario) {
		String comando = "INSERT INTO USUARIO (nome,tipo,senha) VALUES (?,?,?)";
		try {
			String senha = passwordEncoder.encode(usuario.getSenha());
			jdbcTemplate.update(comando,usuario.getNome(),usuario.getUser().getNome(),senha);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String buscarUser(String nome){
		String comando = "SELECT FROM USUARIO (tipo,senha) WHERE nome = ?";
		return "";
	}
}
