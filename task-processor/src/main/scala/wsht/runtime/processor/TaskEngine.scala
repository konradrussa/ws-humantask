package wsht.runtime.processor
import wsht.messages.EscalationMessage
import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase
import wsht.errorkernel.actors.BaseActor
import wsht.messages.WSHTMessage
import wsht.infrastructure.domain.entity._
import wsht.errorkernel.FaultHandler
import wsht.errorkernel.actors.TaskActor
import wsht.messages.ErrorMessage
import wsht.errorkernel.actors.FaultTolerantSupervisor
import akka.actor.ActorRef
import akka.actor.Props
import akka.actor.ActorSystem
import akka.kernel.Bootable
import akka.pattern.{ ask, pipe }
import akka.util._
import akka.util.duration._
import wsht.runtime.utils.ActorUtils


object Processor extends Enumeration {
  type Processor = ProcessorType

  import TaskEngine._

  case class ProcessorType(name: String, t: TaskInfo) extends Val(name) {

    def this(name: String) = this(name, new TaskInfo())
    def this(t: TaskInfo) = this(t.getTaskIdentifier(), t)

    def apply(t: TaskInfo) = new ProcessorType(t);
    
    implicit val timeout = Timeout(5000000 seconds) // needed for ‘?‘ below

    def process = this match {
      case CreateTask => {
        TaskProcessor(t).taskActor ! t
      }
      case CreateEscalation => {
        supervisorActor ! ""
      }
      case CreateNotification => {
        //supervisorActor ! "test"
        val future = supervisorActor ? "notification"
        
        future onSuccess {
          case x => println("success" + x)
        }
        future onFailure {
          case _ => println("failure")
        }
      }
      case CreateError => {
        supervisorActor ! ""
      }
      case _ if t == null => {
        println("processor t == null")
      }
      case _ if t.getFault() != null => {
        println("processor t.getFault() != null")
        supervisorActor ! "co tu wyslac"
        //TaskProcessor(t).taskActor ! new ErrorMessage(t.getFault())
      }
    }
  }

  case object CreateTask extends ProcessorType("CreateTask")
  case object CreateEscalation extends ProcessorType("CreateEscalation")
  case object CreateError extends ProcessorType("CreateError")
  case object CreateNotification extends ProcessorType("CreateNotification")

}

case class TaskEngine(var engineName:String) {
  
  def this() = this("default")
}

object TaskEngine extends FaultHandler with Bootable {

  var supervisorActor: ActorRef = system.actorOf(Props[FaultTolerantSupervisor], ActorUtils.a_1_faultTolerantSupervisor)

  def startup = {
  }

  def shutdown = {
    system.shutdown()
  }

  def process(t: TaskInfo) {
    if (t.getState().isNotificationReady()) {
      Processor.CreateNotification(t).process
      
    }
    if (t.getFault() != null) {
      Processor.CreateError(t).process
    }
  }

}