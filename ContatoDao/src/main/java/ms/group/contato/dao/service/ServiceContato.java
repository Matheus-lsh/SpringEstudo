package ms.group.contato.dao.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ms.group.contato.dao.ConectDao;
import ms.group.contato.dao.modelo.Contato;

@Service
public class ServiceContato {
	private final ConectDao conectDao;
	
		public ServiceContato(ConectDao conectDao) {
			this.conectDao = conectDao;
		}
	
	public boolean adicionaContatoServlet(String nome,String endereco,String email,String data) {
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

			Date date = formato.parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			contato.setDataNascimento(calendar);
			conectDao.adicionarContato(contato);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean removeContatoServlet(String id) {
		Long idFormato = Long.parseLong(id);
		conectDao.removerContato(idFormato);
		return true;
	}
	
	public List<Contato> listarContatoServlet(){
		return conectDao.listaContato();
	}
	
	public List<Contato> pesquisaContato(String nome) {
		return conectDao.pesquisaContato(nome);
	}
}
