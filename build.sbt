name := "akka-actors-state-machine"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor"       % "2.5.2",
  "com.typesafe.akka" %% "akka-persistence" % "2.5.2"
)