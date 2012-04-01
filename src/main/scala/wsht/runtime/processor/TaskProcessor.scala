package wsht.runtime.processor
import wsht.infrastructure.domain.entity.TaskInfo
import wsht.errorkernel.FaultHandler
import akka.actor.Props
import wsht.errorkernel.actors._
import wsht.messages._
import akka.actor._
import akka.event.LoggingReceive


case class TaskProcessor(var instanceName: String, var task:TaskInfo) extends Actor { 
   
  var taskActor:ActorRef = context.actorOf(Props[TaskActor], instanceName)
  
  def receive = LoggingReceive  {
    case _ => TaskEngine.process(task)
  }

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
      case DeadlineMessage(deadline, computated) if deadline.getUntil() != null =>  {
        println(deadline)
      }
      case EscalationMessage(escalation, computated) if escalation.getCondition() != null =>  {
        println(escalation)
      }
      case DelegateMessage(delegate, computated) =>  {
        println(delegate)
      }
      case NominateMessage(nominate, computated) => {
        println(nominate)
      }
      
      case _ => println("nieznany komunikat")
    }
    
  }
  
}

