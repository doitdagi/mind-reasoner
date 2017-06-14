package io.mind.reasoner.appstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Mind reasoner Spring boot starter 
 * @author dagi
 *
 */
@SpringBootApplication
public class MindReasonerApiApp {

	public static void main(String[] args) {
		
		//Configure and start this class as Spring boot app*tion
		/**
		 * - Setup the default configuration
		 * - Starts Spring application context
		 * - Perform class path scan
		 * -  Start Tomcat server
		 */
		SpringApplication.run(MindReasonerApiApp.class, args);
		
		
		
	}
	
}
