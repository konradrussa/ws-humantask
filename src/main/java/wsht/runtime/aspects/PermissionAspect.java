package wsht.runtime.aspects;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.IllegalState;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.IllegalStateFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.IllegalAccessFault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wsht.infrastructure.domain.entity.UserSession;
import wsht.runtime.enums.OperationsEnum;
import wsht.runtime.scheduler.tasks.CreateLeanTask;

public class PermissionAspect {
	
	private static final Logger log = LoggerFactory.getLogger(PermissionAspect.class);

	private UserSession userSession;
	
	public Object checkPermissionForUser(ProceedingJoinPoint pjp) throws Throwable {
		
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();
        String methodName = method.getName();
        
        boolean permission = userSession.checkPermission(OperationsEnum.getOperationForName(methodName));
        
        if(permission) {
        	Object o = pjp.proceed();
        	return o;
        } else {
        	log.debug("User operation - access denied");
        	throw new IllegalAccessFault("Access Denied","User operation - access denied");
        }
	}
	
	public Object checkPermissionForTask(ProceedingJoinPoint pjp) throws Throwable {
		
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();
        String methodName = method.getName();
        
        boolean permission = userSession.getTaskInfo().checkPermission(OperationsEnum.getOperationForName(methodName));
        
        if(permission) {
        	Object o = pjp.proceed();
        	return o;
        } else {
        	log.debug("Task operation - wrong state");
        	IllegalState illegalState = new IllegalState();
        	illegalState.setMessage("Task operation - wrong state");
        	illegalState.setStatus("FAILED");
        	throw new IllegalStateFault("Access Denied", illegalState);
        }
	}

	public UserSession getUserSession() {
		return userSession;
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}
}
