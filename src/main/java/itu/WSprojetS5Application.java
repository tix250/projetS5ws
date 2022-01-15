package itu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import itu.dao.ContactRepository;
import itu.entities.Contact;

@SpringBootApplication
public class WSprojetS5Application implements CommandLineRunner {
	@Autowired
	private ContactRepository contactReopsitory;
	public static void main(String[] args) {
		SpringApplication.run(WSprojetS5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactReopsitory.save(new Contact("tix" ,"andrianjafison" , df.parse("23/06/1999"),"tix@gmail.com" , 330251763 ,"tix.jpg"));
		contactReopsitory.save(new Contact("bapampa" ,"parfait" , df.parse("2/08/2001"),"bapampa@gmail.com" , 330251763 ,"bapampa.jpg"));
		contactReopsitory.save(new Contact("mila" ,"kely" , df.parse("23/04/2001"),"mika@gmail.com" , 330251763 ,"mika.jpg"));
		
		contactReopsitory.findAll().forEach(c->{
			System.out.println(c.getNom());
		});*/
	}

}
