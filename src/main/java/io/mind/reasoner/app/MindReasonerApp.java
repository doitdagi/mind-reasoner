package io.mind.reasoner.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Mind reasoner Spring boot starter 
 * @author dagi
 *
 */
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = {"io.mind.reasoner.app.*"})
public class MindReasonerApp {

	public static void main(String[] args) {
		
		//Configure and start this class as Spring boot app*tion
		/**
		 * - Setup the default configuration
		 * - Starts Spring application context
		 * - Perform class path scan
		 * -  Start Tomcat server
		 */
		SpringApplication.run(MindReasonerApp.class, args);
		
		
		
	}
	
}
