package com.demo

import akka.actor.Actor

class BecomeUnbecomeStateActor extends Actor {

  //need this for become/unbecome
  import context._

  def receive = {
    case "lock" =>
      println("locking, becoming")
      become({
        case "unlock" =>
          println("unlocking, unbecoming")
          unbecome() // resets the latest 'become'
        case _ => println("Unknown message, state only likes locking")
      }, discardOld = false) // push on top instead of replace

    case "unlock" =>
      println("unlocking, becoming")
      become({
        case "lock" =>
          println("locking, unbecoming")
          unbecome() // resets the latest 'become'
        case _ => println("Unknown message, state only likes unlocking")
      }, discardOld = false) // push on top instead of replace

    case _ => println("Unknown message")
  }

}
