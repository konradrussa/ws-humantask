package test;

import java.io.InputStream;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wsht.marshalling.JAXBUtilBean;

public class TestWSHT {

	@org.junit.Test
	public void testProject() throws InterruptedException {
		
		InputStream ins = JAXBUtilBean.class.getClassLoader().getResourceAsStream("oasis/xml.xsd");
		Assert.assertNotNull(ins);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		context.getBean("applicationContextProvider");
		Object lock = new Object();
        synchronized (lock) {
            lock.wait();  
        }
	}
}
