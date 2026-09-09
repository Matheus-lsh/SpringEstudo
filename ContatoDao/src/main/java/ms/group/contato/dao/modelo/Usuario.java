package ms.group.contato.dao.modelo;

public class Usuario {
	private String nome;
	private TipoUser user;
	private String senha;
	private Long id;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoUser getUser() {
		return user;
	}
	public void setUser(TipoUser user) {
		this.user = user;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
