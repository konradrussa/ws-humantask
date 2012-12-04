package wsht.messages

abstract case class WSHTMessage() extends TraitMessageListener {
  
  def processMessage()
}

trait TraitMessageListener {

  def processMessage(m: WSHTMessage)
}