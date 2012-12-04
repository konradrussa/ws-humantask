package test

import org.scalatest.{FunSuite, BeforeAndAfter, BeforeAndAfterAll}
import org.scalatest.matchers.ShouldMatchers
import org.junit.Assert._

import collection.mutable.Stack


import wsht.errorkernel.actors._
import akka.actor.{ ActorSystem, Actor, Props }
import wsht.messages._
import wsht.infrastructure.domain.entity._
import wsht.runtime.processor.TaskProcessor

class WSHTTestFunSuiteScala extends FunSuite with ShouldMatchers with BeforeAndAfter {
  
  var stack: Stack[Int] = _

  before {
    stack = new Stack[Int]
  }

  test("pop is invoked on a non-empty stack") {
 
    stack.push(1)
    stack.push(2)
    val oldSize = stack.size
    val result = stack.pop()
    assert(result === 2)
    assert(stack.size === oldSize - 1)
  }
 
  test("pop is invoked on an empty stack") {
 
    intercept[NoSuchElementException] {
      stack.pop()
    }
    assert(stack.isEmpty)
  }
  
}