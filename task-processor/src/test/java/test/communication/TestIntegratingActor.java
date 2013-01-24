package test.communication;

import org.junit.Test;

import wsht.runtime.communication.IIntegration;
import wsht.runtime.communication.IntegratingActor;

public class TestIntegratingActor {
	
	@Test
	public void testIntegratingActor() {
		IIntegration interActor = new IntegratingActor();
	}

}
