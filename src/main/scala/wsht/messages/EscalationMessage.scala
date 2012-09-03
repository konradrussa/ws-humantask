package wsht.messages

import wsht.infrastructure.domain.entity.Escalation

case class EscalationMessage(val message:Escalation,var computated:Boolean) extends WSHTMessage {

  def this(message:Escalation) = this(message,false)
  
  def processMessage(m: WSHTMessage) = {
    
    computated = true
  }
  
  def processMessage = {
    processMessage(message)
  }
  
  def processMessage(escalation : Escalation) = {
    
    val condition = escalation.getCondition()
    val localNotification = escalation.getLocalNotification()
    val notification = escalation.getNotification()
    val reassignment = escalation.getReassignment()
    val toParts = escalation.getToParts()
    
    println("EscalationMessage=" + escalation)
  }
    
  override def toString = message.getName()
  
}