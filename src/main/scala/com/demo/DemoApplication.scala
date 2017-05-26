package com.demo

import akka.actor.{ActorSystem, Props}

import scala.io.StdIn

object DemoApplication extends App {

  //uncomment / comment out as required to run the demos
  //RunBecomeUnbecomeStateDemo
  RunStateDemo

  def RunStateDemo : Unit = {
    //create the actor system
    val system = ActorSystem("StateMachineSystem")

    val hotColdStateActor = system.actorOf(Props(classOf[StateActor]), "demo-stateActor")

    println("sending lock")
    hotColdStateActor ! "lock"
    //actors are async, so give it chance to get message
    //obviously we would not do this in prod code, its just
    //for the demo, to get the correct ordering for the print
    //statements
    Thread.sleep(1000)

    println("sending lock")
    hotColdStateActor ! "lock"
    Thread.sleep(1000)

    println("sending unlock")
    hotColdStateActor ! "unlock"
    Thread.sleep(1000)

    println("sending unlock")
    hotColdStateActor ! "unlock"
    Thread.sleep(1000)

    println("sending lock")
    hotColdStateActor ! "lock"
    Thread.sleep(1000)

    println("sending unlock")
    hotColdStateActor ! "unlock"
    Thread.sleep(1000)

    StdIn.readLine()

    //shutdown the actor system
    system.terminate()

    StdIn.readLine()
  }

  def RunBecomeUnbecomeStateDemo : Unit = {
    //create the actor system
    val system = ActorSystem("StateMachineSystem")

    val becomeUnbecomeStateActor = system.actorOf(Props(classOf[BecomeUnbecomeStateActor]), "demo-BecomeUnbecomeStateActor")

    println("Sending unlock")
    becomeUnbecomeStateActor ! "unlock"
    //actors are async, so give it chance to get message
    Thread.sleep(1000)

    println("Sending unlock")
    becomeUnbecomeStateActor ! "unlock"
    Thread.sleep(1000)

    println("Sending lock")
    becomeUnbecomeStateActor ! "lock"
    Thread.sleep(1000)

    println("Sending lock")
    becomeUnbecomeStateActor ! "lock"
    Thread.sleep(1000)

    println("Sending unlock")
    becomeUnbecomeStateActor ! "unlock"
    Thread.sleep(1000)

    StdIn.readLine()

    //shutdown the actor system
    system.terminate()

    StdIn.readLine()
  }

}
