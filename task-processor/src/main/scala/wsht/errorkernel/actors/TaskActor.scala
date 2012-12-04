package wsht.errorkernel.actors

import akka.event.{Logging, LoggingReceive}

import wsht.infrastructure.domain.entity._
import wsht.messages._

case class TaskActor extends BaseActor {
  
  import context._
  
  def receive = LoggingReceive {
    case event:NominateMessage if event.computated => process(event)
  	case event:DelegateMessage if event.computated => process(event)
  	case event:DeadlineMessage if event.computated => process(event)
  	case event:EscalationMessage if event.computated => process(event)
  }
  
  def process(m:WSHTMessage): Unit = {
    m.processMessage();
  }
  
  def sendMessage(m:WSHTMessage) = {
    
  }

}