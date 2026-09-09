package ms.group.contato;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ms.group.contato.dao.ConectDao;

@SpringBootApplication
public class ContatoDaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContatoDaoApplication.class, args);
	}

	/*@Bean
    CommandLineRunner executar(ConectDao conectDao) {
        return args -> {
            conectDao.testar();
        };
    }*/
}
