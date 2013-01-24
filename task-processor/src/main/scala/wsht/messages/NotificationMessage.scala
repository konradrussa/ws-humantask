package wsht.messages
import wsht.infrastructure.domain.entity.Notification

case class NotificationMessage (val message:Notification,var computated:Boolean) extends WSHTMessage {

  def this(message:Notification) = this(message,false)
  
  var emailAddress: String = ""
  
  def processMessage(m: WSHTMessage) = {
    
  }
  
  def processMessage = {
    processMessage(message)
  }
  
  def processMessage(notification: Notification) = {

    println("NotificationMessage="+notification)
  }
  
  override def toString = message.getName()
  
}