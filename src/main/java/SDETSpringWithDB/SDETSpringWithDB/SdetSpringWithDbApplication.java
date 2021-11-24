package SDETSpringWithDB.SDETSpringWithDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"SDETSpringWithDB.SDETSpringWithDB.Repository.CountryRepository","SDETSpringWithDB.SDETSpringWithDB.Entity.Country","SDETSpringWithDB.SDETSpringWithDB.Service.CountryService","SDETSpringWithDB.SDETSpringWithDB.Controller.CountryController"})

public class SdetSpringWithDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdetSpringWithDbApplication.class, args);
	}

}
