package wsht.runtime.communication;

import akka.dispatch.Future;
import akka.japi.Option;

public interface ICommunication {
	
	public Future<String> processMessage(String param);

	public Option<String> computeAndReturn();

}
