package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sun.xml.bind.api.ErrorListener;

public class Main {

	@org.junit.Test
	public void testProject() throws InterruptedException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		context.getBean("applicationContextProvider");
		Object lock = new Object();
        synchronized (lock) {
            lock.wait();  
        }
	}
}
