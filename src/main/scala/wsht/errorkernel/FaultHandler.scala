package wsht.errorkernel
import com.typesafe.config.ConfigFactory
import akka.actor._
import wsht.errorkernel.actors.FaultTolerantSupervisor

abstract class FaultHandler {

  val config = ConfigFactory.parseString("""
		  		akka.loglevel = DEBUG
		  		akka.actor.debug {
		  			receive = on
		  			lifecycle = on
		  		}
  				""")
  				
  val system = ActorSystem("FaultToleranceSample", config)
  
  
}