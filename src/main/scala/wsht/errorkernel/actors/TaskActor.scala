package wsht.errorkernel.actors

import wsht.infrastructure.domain.entity._
import akka.event.Logging
import wsht.messages._
import akka.event.LoggingReceive

case class TaskActor extends BaseActor {

  
  def receive = LoggingReceive {
    case event:NominateMessage => process(event)
  	case event:DelegateMessage => process(event)
  	case event:DeadlineMessage => process(event)
  	case event:EscalationMessage => process(event)
  }
  
  def process(m:WSHTMessage): Unit = {
    m.processMessage();
  }
  
  def sendMessage(m:WSHTMessage) = {
    
  }

}