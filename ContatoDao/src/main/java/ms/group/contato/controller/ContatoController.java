package ms.group.contato.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ms.group.contato.dao.modelo.Contato;
import ms.group.contato.dao.service.ServiceContato;

@Controller
public class ContatoController {
	private final ServiceContato serviceContato;

    public ContatoController(ServiceContato serviceContato) {
    	this.serviceContato = serviceContato;
    }
	
	@PostMapping("/adicionacontato")
	public String adicionacontato(@RequestParam String nome,@RequestParam String email,@RequestParam String endereco,@RequestParam String dataNascimento){
		if(serviceContato.adicionaContatoServlet(nome, endereco, email, dataNascimento)) {
			return redirecionaIndex();
		}
		return "error";
	}
	
	@PostMapping("/removeContato")
	public String removecontato(@RequestParam String id) {
		if(serviceContato.removeContatoServlet(id)){
			return redirecionaIndex();
		}
		return "error";
	}
	
	@PostMapping("/pesquisacontato")
	public String pesquisaContao(@RequestParam String nome,Model model) {
		if(nome.equalsIgnoreCase("todos")) {
	        List<Contato> contatos = serviceContato.listarContatoServlet();

	        model.addAttribute("contatos", contatos);
		}else {
	        List<Contato> contatos = serviceContato.pesquisaContato(nome);

	        model.addAttribute("contatos", contatos);
		}
		return exibircontato();
	}
	
    @GetMapping("/")
    public String inicio() {
        return "index";
    }
    
    private String redirecionaIndex() {
    	return "redirect:/index";
    }
    
    @GetMapping("/index")
    public String index() {
        return "index";
    }
	
	@GetMapping("/adicionacontato")
	public String adicionacontato() {
		return "adicionacontato";
	}
	
	@GetMapping("/removecontato")
	public String removecontato() {
		return "removecontato";
	}
	
	@GetMapping("/error")
	public String erro() {
		return "error";
	}
	
	@GetMapping("/exibircontato")
	public String exibircontato() {
		return "exibircontato";
	}
	
	@GetMapping("/consultacontato")
	public String consultacontato() {
		return "consultacontato";
	}
}
