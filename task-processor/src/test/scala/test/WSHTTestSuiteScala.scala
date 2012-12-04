package test

import org.scalatest.{FunSuite, Suite, BeforeAndAfter, BeforeAndAfterAll}
import org.scalatest.matchers.ShouldMatchers
import org.junit.Assert._

import collection.mutable.Stack


import wsht.errorkernel.actors._
import akka.actor.{ActorSystem, Actor, Props}
import wsht.messages._
import wsht.infrastructure.domain.entity._
import wsht.runtime.processor.TaskProcessor

import org.scalatest.Ignore


class WSHTTestSuiteScala extends Suite with ShouldMatchers with BeforeAndAfter {
  
 
  
  def testAddition {
    val sum = 1 + 1
    sum should equal (2)
  }

  def testSubtraction {
    val diff = 4 - 1
    diff should equal (3)
  }
  
  def testProcessors {
    val task = new TaskInfo("identifier")
    
    val message1= new Deadline()
    val deadline = new DeadlineMessage(message1)
    TaskProcessor.processMessage(deadline,task)

    
    val message2 = new Delegation()
    val delegation = new DelegateMessage(message2)
    TaskProcessor.processMessage(delegation,task)
    
    
    val message3 = new Escalation()
    val escalation = new EscalationMessage(message3)
    TaskProcessor.processMessage(escalation,task)
    
    val message4 = new Nominate()
    message4.setIdentifier("nominateIdentifier")
    val nominate = new NominateMessage(message4)
    TaskProcessor processMessage nominate
  }
  
}