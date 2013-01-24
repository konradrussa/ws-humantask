package test;

import org.eclipse.jetty.server.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	@org.junit.Test
	public void testProject() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		

		Object lock = new Object();
        synchronized (lock) {
            lock.wait();  
        }
	}
}
