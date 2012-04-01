package wsht.messages

import wsht.infrastructure.domain.entity._
import wsht.runtime.processor.TaskProcessor

case class DeadlineMessage (val message:Deadline,var computated:Boolean) extends WSHTMessage with TraitMessageListener {

  def this(message:Deadline) = this(message,false)
  
  def processMessage = {
    processMessage(message)
  }
  
  def processMessage(deadline : Deadline) = {
    var until = deadline.getUntil()
    var _for = deadline.get_for()
    
    val expressionLanguage = until.getExpressionLanguage()
    var otherAttributes = until.getOtherAttributes()
    println("DeadlineMessage=" + deadline)
  }
  
  def processEscalation(m:EscalationMessage) = {
    m.message.getCondition()
    m.message.getLocalNotification()
    m.message.getNotification()
    m.message.getReassignment()
    m.message.getToParts()
    m.processMessage()
  }
  
  def processMessage(m: WSHTMessage) = {
    m.processMessage()
  }
  
  override def toString = message.getName()
  
}