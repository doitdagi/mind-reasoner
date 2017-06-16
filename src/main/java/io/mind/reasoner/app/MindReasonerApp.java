package io.mind.reasoner.app;

import java.util.Arrays;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
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
		
		//Configure and start this class as Spring boot application 
		/**
		 * - Setup the default configuration
		 * - Starts Spring application context
		 * - Perform class path scan
		 * -  Start Tomcat server
		 */
		 ApplicationContext ctx =	SpringApplication.run(MindReasonerApp.class, args);
		
		  String[] beanNames = ctx.getBeanDefinitionNames();
	        Arrays.sort(beanNames);

	        StringBuilder sb = new StringBuilder("Application beans:\n");
	        for (String beanName : beanNames) {
	            sb.append(beanName + "\n");
	        }
	    }
	    
	    /**
	     * By defining the {@link KieContainer} as a bean here, we ensure that
	     * Drools will hunt out the kmodule.xml and rules on application startup.
	     * Those can be found in <code>src/main/resources</code>.
	     * 
	     * @return The {@link KieContainer}.
	     */
	    @Bean
	    public KieContainer kieContainer() {
	        return KieServices.Factory.get().getKieClasspathContainer();
	    }

}
