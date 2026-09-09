package ms.group.contato.dao.modelo;

import java.util.Calendar;

public class Contato {
	private String nome;
	private String endereco;
	private String email;
	private Long id;
	private Calendar dataNascimento;
	
	public Contato() {
	}
	
	public Contato(String nome, String endereco, String email, Calendar dataNascimento) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
