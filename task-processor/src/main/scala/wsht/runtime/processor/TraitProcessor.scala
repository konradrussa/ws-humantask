package wsht.runtime.processor
import wsht.messages.WSHTMessage
import wsht.messages.TraitMessageListener
import wsht.infrastructure.domain.entity.TaskInfo

trait TraitProcessor {

   protected def apply(instanceName: String, task:TaskInfo): TaskProcessor
   
}