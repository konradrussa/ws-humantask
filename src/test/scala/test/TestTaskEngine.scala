package test
import wsht.runtime.processor.TaskEngine
import akka.actor.ActorRef
import akka.actor.ActorSystem
import wsht.infrastructure.domain.entity.TaskInfo
import wsht.runtime.enums.TaskStatesEnum
import wsht.infrastructure.domain.entity.Fault

object TestTaskEngine {
  
  def main(args:Array[String]) {
  
    var taskInfo = new TaskInfo
    taskInfo.setState(TaskStatesEnum.NOTIFICATION_READY)
    taskInfo.setFault(new Fault())
	TaskEngine.process(taskInfo)
  }

}