package wsht.infrastructure.webservice.commons;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import wsht.infrastructure.web.UserInfo;
import wsht.infrastructure.webservice.exceptions.WSHTWebServiceException;

@WebService(name="authService")
public interface AuthenticatorWebService {

	
	@WebMethod(operationName="logIn")
	public UserInfo logIn(@WebParam(name="userInfo") UserInfo userInfo) throws WSHTWebServiceException;
	
	@WebMethod(operationName="logOut")
	public void logOut() throws WSHTWebServiceException;
	
	@WebMethod(operationName="checkLoggedIn")
	public boolean checkLoggedIn() throws WSHTWebServiceException;
	
	@WebMethod(operationName="checkCurrentUser")
	public boolean checkCurrentUser(@WebParam(name="userInfo") UserInfo userInfo) throws WSHTWebServiceException;
}
