package wsht.errorkernel.actors

import akka.actor.Actor
import wsht.errorkernel.TraitUncaughtExceptionHandler
import wsht.messages._
import akka.event.Logging
import wsht.runtime.processor._
import wsht.runtime.processor.TaskProcessor
import akka.actor.Actor
import akka.util.Duration
import java.util.concurrent.TimeUnit
import akka.actor.OneForOneStrategy
import akka.actor.SupervisorStrategy._
import akka.util.duration._
import akka.actor.ReceiveTimeout
import wsht.messages.WSHTMessage
import akka.event.LoggingReceive
import wsht.exception.{NonRecoverableError, TaskExpiredFault}

class FaultTolerantSupervisor extends BaseActor with TraitUncaughtExceptionHandler {
  
  override val supervisorStrategy = OneForOneStrategy(maxNrOfRetries = 3, withinTimeRange = 1 minute) {
    case _: ArithmeticException => Resume
    case _: NullPointerException => Restart
    case _: IllegalArgumentException => Stop
    case _: Exception => Escalate
  }
  
  override def preRestart(reason: Throwable, message: Option[Any]) = {
    //clean up befre restart
    super.preRestart(reason, Option.apply(message))
    println(reason)
  }
  
  override def postRestart(reason: Throwable) = {
    //init after restart
    super.postRestart(reason);
  }
  
  def noRecoverableError(e: NonRecoverableError): Throwable = { 
		  
     e
  }

  def taskExpiredFault(e: TaskExpiredFault): Throwable = { 
		  
     e
  }

  
  def sendMessage(m:WSHTMessage) = {
    
  }
  
  def receive = LoggingReceive {
    case "test" => {
    	println("wywolanie test FaultTolerantSupervisor")
    	log.info("received test")
    }
    case _ => {
      println("wywolanie unknown message FaultTolerantSupervisor")
      log.info("received unknown message")
    }
  }

}