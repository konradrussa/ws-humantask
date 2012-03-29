package wsht.errorkernel.actors

import wsht.infrastructure.domain.entity._
import akka.event.Logging
import wsht.messages._

case class TaskActor extends BaseActor {
  
  
  def process = {
    
  }
  
  def receive = {
    case event:NominateMessage => process(event)
  	case event:DelegateMessage => process(event)
  	case event:DeadlineMessage => process(event)
  	case event:EscalationMessage => process(event)
  }
  
  def process(m:NominateMessage): Unit = {
    m.processMessage();
  }
  
  def process(m:DelegateMessage): Unit = {
    m.processMessage();
  }
  
  def process(m:DeadlineMessage): Unit = {
    m.processMessage();
  }
    
  def process(m:EscalationMessage): Unit = {
    m.processMessage();
  }
  
  def sendMessage(m:WSHTMessage) = {
    
  }

}