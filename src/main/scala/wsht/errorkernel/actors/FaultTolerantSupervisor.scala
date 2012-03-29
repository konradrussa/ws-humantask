package wsht.errorkernel.actors

import akka.actor.Actor
import wsht.exception.{NonRecoverableError, TaskExpiredFault}
import wsht.errorkernel.TraitUncaughtExceptionHandler
import wsht.messages._
import akka.event.Logging
import wsht.runtime.processor._
import wsht.runtime.processor.TaskProcessor

class FaultTolerantSupervisor extends BaseActor with TraitUncaughtExceptionHandler {
  
  override def preRestart(reason: Throwable, message: Option[Any]) = {
    //clean up befre restart
    super.preRestart(reason, Option.apply(message))
    println(reason)
  }
  
  override def postRestart(reason: Throwable) = {
    //init after restart
    super.postRestart(reason);
  }
  
  def noRecoverableError(e: NonRecoverableError): Boolean = { 
		  
    true 
  }

  def taskExpiredFault(e: TaskExpiredFault): Boolean = { 
		  
    true 
  }
  
  def process = {
    
  }
  
  def sendMessage(m:WSHTMessage) = {
    
  }
  
  def receive = {
    case "test" => {
    	println("wywolanie FaultTolerantSupervisor")
    	log.info("received test")
    }
    case _ => log.info("received unknown message")
  }

}