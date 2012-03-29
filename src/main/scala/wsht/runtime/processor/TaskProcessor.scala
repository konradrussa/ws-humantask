package wsht.runtime.processor
import wsht.infrastructure.domain.entity.TaskInfo
import wsht.errorkernel.FaultHandler
import akka.actor.Props
import wsht.errorkernel.actors._
import wsht.messages._
import akka.actor._


case class TaskProcessor(var instanceName: String, var task:TaskInfo) extends FaultHandler {
  
  import Worker._
  
  trait Processor
  case object TaskCreate extends Processor
  case object InvokeEscalation extends Processor
  case object InvokeDeadline extends Processor
  case object InvokeNotification extends Processor
  case object InvokeLocalNotification extends Processor
  
  var supervisorActor:ActorRef = system.actorOf(Props[FaultTolerantSupervisor])
  var taskActor:ActorRef = system.actorOf(Props[TaskActor])
  
  

}

object Worker {
  case object Start
  case object Do
  case object End
}

object TaskProcessor extends TraitProcessor {
  
  def apply(task:TaskInfo) = new TaskProcessor(task.getTaskIdentifier(), task)
  
  
  def processMessage(m:WSHTMessage, task:TaskInfo): Unit = {
    processMessage(m)
    TaskProcessor(task).taskActor ! m
  }
  
  def processMessage(m:WSHTMessage) = {
    println("TaskProcessor.processMessage=" + m)
    
    m match {
      case DeadlineMessage(deadline, computated) if deadline.getUntil() != null => println(deadline)
      case EscalationMessage(escalation, computated) if escalation.getCondition() != null => println(escalation)
      case DelegateMessage(delegate, computated) => println(delegate)
      case NominateMessage(nominate, computated) => println(nominate)
      case _ => println("nieznany komunikat")
    }
    
  }
}

