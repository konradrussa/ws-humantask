package wsht.messages

import wsht.infrastructure.domain.entity._

case class DelegateMessage(val message:Delegation,var computated:Boolean) extends WSHTMessage {

  def this(message:Delegation) = this(message,false)
  
  def processMessage(m: WSHTMessage) = {
    
  }
  
  def processMessage = {
    processMessage(message)
  }
  
  def processMessage(delegation : Delegation) = {
    	val from = delegation.getFrom();
    	val potentialDelegatees = delegation.getPotentialDelegatees();
    	//potentialDelegatees.
    	println("DelegateMessage="+from)
    	println("DelegateMessage="+potentialDelegatees)
    
  }
  override def toString = "DelegateMessage toString"
  
}