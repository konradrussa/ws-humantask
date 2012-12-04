package test.main;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wsht.infrastructure.web.UserInfo;
import wsht.infrastructure.webservice.commons.AuthenticatorWebService;
import wsht.infrastructure.webservice.exceptions.WSHTWebServiceException;

public class TestClientTask {

	@Test
	public void testParentTask() throws WSHTWebServiceException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		AuthenticatorWebService authService = (AuthenticatorWebService) context.getBean("authServiceWebServicesClient");
		
		UserInfo userInfo = new UserInfo();
		userInfo.setIpAddress("1.2.3.4");
		userInfo.setPassword("pass");
		userInfo.setUserName("Johny Smith");

		userInfo = authService.logIn(userInfo);
		Assert.assertTrue(userInfo.getLoggedIn());
		System.out.println(userInfo);
		
		boolean afterCheckIfLogged = authService.checkLoggedIn();
		System.out.println("1afterCheckIfLogged = " + afterCheckIfLogged);
		
		boolean checkedUser = authService.checkCurrentUser(userInfo);
		System.out.println("1checkedUser = " + checkedUser);
		
		afterCheckIfLogged = authService.checkLoggedIn();
		System.out.println("2afterCheckIfLogged = " + afterCheckIfLogged);
		
		checkedUser = authService.checkCurrentUser(userInfo);
		System.out.println("2checkedUser = " + checkedUser);
	}
}
