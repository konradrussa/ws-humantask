package wsht.messages

trait TraitMessageListener {

  def processMessage(m: WSHTMessage)
}