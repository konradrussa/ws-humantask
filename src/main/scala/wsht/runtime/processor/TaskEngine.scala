package wsht.runtime.processor
import wsht.messages.EscalationMessage
import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase
import wsht.errorkernel.actors.BaseActor
import wsht.messages.WSHTMessage
import wsht.infrastructure.domain.entity._
import wsht.errorkernel.FaultHandler
import akka.actor.ActorRef
import akka.actor.Props
import wsht.errorkernel.actors.FaultTolerantSupervisor
import akka.actor.ActorSystem

object Processor extends Enumeration {
  type Processor = ProcessorType
  
  import TaskEngine._

  case class ProcessorType(name: String, t:TaskInfo) extends Val(name) {
    
    def this(name:String) = this(name,null)
    
    def apply(t:TaskInfo) = new ProcessorType(name)
    
    def process = this match {
      case CreateTask => {
        supervisorActor ! ""
        
        TaskProcessor(t).taskActor ! t
      }
      case CreateEscalation => supervisorActor ! ""
      case CreateNotification => supervisorActor ! "test"
      case CreateError => supervisorActor ! ""
    }
  }

  case object CreateTask extends ProcessorType("CreateTask")
  case object CreateEscalation extends ProcessorType("CreateEscalation")
  case object CreateError extends ProcessorType("CreateError")
  case object CreateNotification extends ProcessorType("CreateNotification")

}

object TaskEngine extends FaultHandler {

  var supervisorActor: ActorRef = system.actorOf(Props[FaultTolerantSupervisor])
  
  def process(t: TaskInfo) {
    if (t.getState().isNotificationReady()) {
    	Processor.CreateError.process
    }
    if (t.getFault() != null) {
    	Processor.CreateNotification.process
    }
  }

}