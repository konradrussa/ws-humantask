package wsht.errorkernel.actors

import akka.actor.{ Actor, ActorRef, Props, Terminated, ReceiveTimeout }

import akka.event.Logging
import akka.event.LoggingReceive

import akka.util.Duration
import akka.util.duration._
import java.util.concurrent.TimeUnit

import akka.actor.OneForOneStrategy
import akka.actor.SupervisorStrategy._

import wsht.messages._
import wsht.exception.{NonRecoverableError, TaskExpiredFault}
import wsht.errorkernel.TraitUncaughtExceptionHandler
import wsht.runtime.processor._

class FaultTolerantSupervisor extends BaseActor with TraitUncaughtExceptionHandler {
  
  import context._
  
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
    case Register(actor) => {
    	//self.
    	def taskActor = actorOf(Props[TaskActor])
    	println("wywolanie test FaultTolerantSupervisor")
    	log.info("received test")
    }
    case _ => {
      println("wywolanie unknown message FaultTolerantSupervisor")
      log.info("received unknown message")
    }
  }

}

case class Register(val actor:ActorRef)