package com.demo

import akka.actor.Actor

class StateActor extends Actor {

  //need this for become/unbecome
  import context._

  def lock: Receive = {
    case "lock" => println("I am already lock!")
    case "unlock" => becomeUnlock
  }

  def unlock: Receive = {
    case "unlock" => println("I am already unlock!")
    case "lock" => becomeLock
  }

  def receive = {
    case "lock" => becomeLock
    case "unlock" => becomeUnlock
  }


  private def becomeLock: Unit = {
    println("becoming lock")
    become(lock)
  }

  private def becomeUnlock: Unit = {
    println("becoming unlock")
    become(unlock)
  }


}
