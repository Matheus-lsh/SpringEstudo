package ms.group.contato.dao.modelo;

public enum TipoUser {
	ADMIN("administrador"),COMUM("comum");
	
	private String nome;
	private TipoUser(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
}
