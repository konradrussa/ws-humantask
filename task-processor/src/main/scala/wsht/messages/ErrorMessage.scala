package wsht.messages
import wsht.infrastructure.domain.entity.Fault

case class ErrorMessage (val message:Fault,var computated:Boolean) extends WSHTMessage {

  def this(message:Fault) = this(message,false)
  
  def processMessage = {
    processMessage(message)
  }
  
  def processMessage(fault : Fault) = {
    var faultData = fault.getFaultData()
    println("ErrorMessage=" + fault)
  }
  

  
  def processMessage(m: WSHTMessage) = {
    m.processMessage()
  }
  
  override def toString = message.getFaultName()
  
}