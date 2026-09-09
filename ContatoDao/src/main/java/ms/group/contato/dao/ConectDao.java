package ms.group.contato.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ms.group.contato.dao.modelo.Contato;

@Repository
public class ConectDao {
	private final JdbcTemplate jdbcTemplate;
	
	public ConectDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Contato> listaContato(){
		ArrayList<Contato> contatoList = new ArrayList<Contato>();
		String comando = "SELECT id, nome, email, endereco,datanascimento FROM CONTATO";
		jdbcTemplate.query(comando, (rs, rowNum) ->{
			Contato contato = new Contato();
			Date date;
		    contato.setId(rs.getLong("id"));
		    contato.setNome(rs.getString("nome"));
		    contato.setEmail(rs.getString("email"));
		    contato.setEndereco(rs.getString("endereco"));
		    date = rs.getDate("datanascimento");
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    contato.setDataNascimento(calendar);
		    
		    contatoList.add(contato);
		    return null;
		});
		return contatoList;
	}
	
	public Contato criaContatoTerminal() {
		String nome,email,endereco,strNascimento;
		Scanner scanner = new Scanner(System.in);
		
		System.out.printf("Digite nome\t");
		nome = scanner.nextLine();
		System.out.printf("Digite email\t");
		email = scanner.nextLine();
		System.out.printf("Digite endereco\t");
		endereco = scanner.nextLine();
		System.out.printf("Digite data de nascimento\t");
		strNascimento = scanner.nextLine();
		
		scanner.close();
		Calendar dataNasc = Calendar.getInstance();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(strNascimento, formatter);
		dataNasc.set(
		    data.getYear(),
		    data.getMonthValue() - 1,
		    data.getDayOfMonth()
		);
		Contato contato = new Contato(nome,endereco,email,dataNasc);
		
		return contato;
	}
	
	public boolean adicionarContato() {
		Contato contato = criaContatoTerminal();
		String comando = "INSERT INTO CONTATO (nome,endereco,email,datanascimento) VALUES(?,?,?,?)";
		try {
			jdbcTemplate.update(comando,contato.getNome(),contato.getEndereco(),contato.getEmail(),contato.getDataNascimento());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	public boolean adicionarContato(Contato contato) {
		String comando = "INSERT INTO CONTATO (nome,endereco,email,datanascimento) VALUES(?,?,?,?)";
		try {
			jdbcTemplate.update(comando,contato.getNome(),contato.getEndereco(),contato.getEmail(),contato.getDataNascimento());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean removerContato(Long index) {
		Contato contato = new Contato();
		contato.setId(index);
		String comando = "DELETE FROM CONTATO WHERE id = ?";
		try {
			jdbcTemplate.update(comando,contato.getId());
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Contato> pesquisaContato(String nome) {
		String comando = "SELECT id, nome, email, endereco, datanascimento FROM CONTATO WHERE nome = ?";
		try {
			List<Contato> contatoList = jdbcTemplate.query(comando, (rs,rowNum) -> {
					Contato contato = new Contato();
					contato.setNome(rs.getString("nome"));
				    contato.setEmail(rs.getString("email"));
				    contato.setEndereco(rs.getString("endereco"));
				    contato.setId(Long.parseLong(rs.getString("id")));
				    Calendar calendar = Calendar.getInstance();
				    Date date = rs.getDate("datanascimento");
				    calendar.setTime(date);
				    contato.setDataNascimento(calendar);
				    return contato;
				},nome);
			return contatoList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
