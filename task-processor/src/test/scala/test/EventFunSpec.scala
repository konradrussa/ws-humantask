package test

import org.scalatest.FunSpec
import org.scalatest.GivenWhenThen

import wsht.infrastructure.domain.entity.TaskInfo
import wsht.runtime.enums.TaskStatesEnum
import wsht.infrastructure.domain.entity.Fault
import wsht.runtime.processor.TaskEngine

import scala.collection.mutable.Stack
//import org.scalatest.junit.AssertionsForJUnit
//import scala.collection.mutable.ListBuffer
//import org.junit.Assert._
//import org.junit.Test
//import org.junit.Before

class EventFunSpec extends FunSpec with GivenWhenThen {

  describe("A Stack") {

    it("should pop values in last-in-first-out order") {
      given("a non-empty stack")
      val stack = new Stack[Int]
      stack.push(1)
      stack.push(2)
      val oldSize = stack.size

      when("when pop is invoked on the stack")
      val result = stack.pop()

      then("the most recently pushed element should be returned")
      assert(result === 2)

      and("the stack should have one less item than before")
      assert(stack.size === oldSize - 1)
      
    }
    
    it("should be ok") {
      given("an empty stack")
      val emptyStack = new Stack[String]

      when("when pop is invoked on the stack")
      then("NoSuchElementException should be thrown")
      intercept[NoSuchElementException] {
        emptyStack.pop()
      }

      and("the stack should still be empty")
      assert(emptyStack.isEmpty)
    }

    it("should throw NoSuchElementException if an empty stack is popped") (pending)
    
    it("should process corectly") {
      var taskInfo = new TaskInfo
      taskInfo.setState(TaskStatesEnum.NOTIFICATION_READY)
      taskInfo.setFault(new Fault())
      TaskEngine.process(taskInfo)
    }
  }
}