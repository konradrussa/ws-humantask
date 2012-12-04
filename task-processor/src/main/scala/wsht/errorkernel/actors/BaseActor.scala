package wsht.errorkernel.actors

import akka.event.Logging

import akka.actor.{Actor, ActorLogging, ReceiveTimeout}

import akka.actor.OneForOneStrategy
import akka.actor.SupervisorStrategy._

import akka.util.Duration
import akka.util.duration._
import java.util.concurrent.TimeUnit

import com.typesafe.config.ConfigFactory

import wsht.messages.WSHTMessage

import scala.reflect.BeanProperty

abstract class BaseActor/*(@BeanProperty val identifier: String)*/ extends Actor {
  
  val log = Logging(context.system, this)

  def sendMessage(m: WSHTMessage)
}