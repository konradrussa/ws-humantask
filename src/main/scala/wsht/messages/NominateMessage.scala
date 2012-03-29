package wsht.messages
import wsht.infrastructure.domain.entity.Nominate

case class NominateMessage (val message:Nominate,var compotated:Boolean) extends WSHTMessage with TraitMessageListener {

  def this(message:Nominate) = this(message,false)
  
  def processMessage(m: WSHTMessage) = {
    
  }
  
  def processMessage = {
    processMessage(message)
  }
  
  def processMessage(nominate: Nominate) = {
    val id = nominate.getId();
    val identifier = nominate.getIdentifier();
    val organizationalEntity = nominate.getOrganizationalEntity();
    println("NominateMessage="+nominate)
  }
  
  override def toString = message.getIdentifier()
  
}