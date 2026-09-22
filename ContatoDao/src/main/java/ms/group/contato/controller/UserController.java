package ms.group.contato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ms.group.contato.dao.service.ServiceUser;

@Controller
public class UserController {
	private final ServiceUser serviceUserServlet;
	
	public UserController(ServiceUser serviceUserServlet) {
		this.serviceUserServlet = serviceUserServlet;
	}
	
	@PostMapping("/adicionauser")
	public String adicionaUser(@RequestParam String nome,@RequestParam String user,@RequestParam String senha){
		if(serviceUserServlet.adicionaUsuario(nome, user, senha)) {
			return redirecionaIndex();
		}else {
			return "redirect:/error";
		}
	}
    
    private String redirecionaIndex() {
    	return "redirect:/index";
    }
    
    @GetMapping("/adicionauser")
    public String adicionaUser() {
    	return "adicionauser";
    }
}