package wsht.errorkernel.actors
import akka.actor.ActorLogging
import akka.actor.Actor
import akka.actor.OneForOneStrategy
import akka.util.Duration
import java.util.concurrent.TimeUnit
import akka.actor.OneForOneStrategy
import akka.actor.SupervisorStrategy._
import akka.util.duration._
import akka.actor.ReceiveTimeout
import akka.event.Logging
import wsht.messages.WSHTMessage
import com.typesafe.config.ConfigFactory

abstract class BaseActor extends Actor {

  val log = Logging(context.system, this)

  def sendMessage(m: WSHTMessage)
}