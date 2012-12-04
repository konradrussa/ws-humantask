package wsht.errorkernel

import akka.actor._
import wsht.errorkernel.actors.FaultTolerantSupervisor

import com.typesafe.config.ConfigFactory

import wsht.runtime.utils.ActorUtils

abstract class FaultHandler {

  val config = ConfigFactory.parseString("""
		  		akka.loglevel = DEBUG
		  		akka.actor.debug {
		  			receive = on
		  			lifecycle = on
		  		}
  				""")
  				
  val system = ActorSystem(ActorUtils.a_0_system, config)
  
  
}