package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {
	private static final Logger log=LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return args->{
			repository.save(new Customer("raj","s"));
			repository.save(new Customer("hema","r"));
			repository.save(new Customer("guru","s"));
			repository.save(new Customer("ram","s"));
			repository.save(new Customer("bheem","a"));
			
			log.info("Customers found with findAll():");
		    log.info("-------------------------------");
		    for(Customer customer:repository.findAll()) {
		    	log.info(customer.toString());
		    }
		    log.info("");
		    
		    Customer customer=repository.findById(1L);
		    log.info("Customers found with findById(1L):");
		    log.info("-------------------------------");
		    log.info(customer.toString());
		    log.info("");
		    
		    log.info("Customer found with findByLastName('Bauer'):");
		    log.info("--------------------------------------------");
		    repository.findByLastName("s").forEach(s->{
		    	log.info(s.toString());
		    });
		  //  for(Customer s:repository.findByLastName("s"){
		  //  	log.info(s.toString());
		  //  }
		    log.info("");
		};
		
	}

}
