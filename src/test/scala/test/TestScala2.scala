package test;

import wsht.errorkernel.actors._
import akka.actor.{ ActorSystem, Actor, Props }
import wsht.messages._
import wsht.infrastructure.domain.entity._
import wsht.runtime.processor.TaskProcessor

object TestScala2 {

  def main(args: Array[String]) {

    val task = new TaskInfo("identifier")
    
    val message1= new Deadline()
    message1.set_for(new DurationExpr("12:30"))
    message1.setUntil(new DeadlineExpr("P7"))
    val deadline = new DeadlineMessage(message1)
    TaskProcessor.processMessage(deadline,task)

    
    val message2 = new Delegation()
    val delegation = new DelegateMessage(message2)
    TaskProcessor.processMessage(delegation,task)
    
    
    var message3 = new Escalation()
    message3.setCondition(new BooleanExpr("expressionLanguage"))
    var escalation = new EscalationMessage(message3)
    TaskProcessor.processMessage(escalation,task)
    
    message3 = new Escalation()
    TaskProcessor.processMessage(escalation,task)
    
    val message4 = new Nominate()
    message4.setIdentifier("nominateIdentifier")
    val nominate = new NominateMessage(message4)
    TaskProcessor processMessage nominate
    
    
  }
  
}