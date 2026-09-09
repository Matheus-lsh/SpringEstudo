package ms.group.contato.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ms.group.contato.dao.modelo.Usuario;

@Repository
public class UserDao {
	private final JdbcTemplate jdbcTemplate;
	
	public UserDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void cadastrarUser(Usuario usuario) {
		String comando = "INSERT INTO USUARIO (nome,tipo,senha) VALUES (?,?,?)";
		try {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			jdbcTemplate.update(comando,usuario.getNome(),usuario.getUser().getNome());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
