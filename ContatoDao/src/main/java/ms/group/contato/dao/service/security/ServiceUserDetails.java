package ms.group.contato.dao.service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ms.group.contato.dao.modelo.Usuario;

@Service
public class ServiceUserDetails implements UserDetailsService{

	private final JdbcTemplate jdbcTemplate;
	
	public ServiceUserDetails(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario;
		String comando = "SELECT id, nome, senha FROM usuario WHERE nome = ?";

        try {
            usuario = jdbcTemplate.queryForObject(comando,(rs, rowNum) -> {
                    Usuario u = new Usuario();
                    u.setId(rs.getLong("id"));
                    u.setNome(rs.getString("nome"));
                    u.setSenha(rs.getString("senha"));
                    return u;
                },username);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return User.withUsername(usuario.getNome()).password(usuario.getSenha()).roles("USER").build();
    }
}
