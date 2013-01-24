package wsht.runtime.configuration;

import java.util.HashMap;
import java.util.Map;

import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.LeanTaskCallbackOperations;

public class PublicProtocolConfiguration {
	
	enum InterfaceEnum {
		LEANTASKCALLBACK;
	}
	
	private static final Map<InterfaceEnum, Class> interfatcesMap = new HashMap<InterfaceEnum, Class>();

	static {
		interfatcesMap.put(InterfaceEnum.LEANTASKCALLBACK, LeanTaskCallbackOperations.class);
	}
	
	private static Class getInterfaceByName(InterfaceEnum en) {
		return interfatcesMap.get(en);
	}
	
	public static Class getLeanTaskCallbackOperationInterface() {
		return getInterfaceByName(InterfaceEnum.LEANTASKCALLBACK);
	}
}
