package wsht.messages

abstract case class WSHTMessage() {
  
  def processMessage()
}