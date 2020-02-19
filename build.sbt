name := "cask.fsm.interface"

version := "1.0-SNAPSHOT"

scalaVersion := "2.13.1"

logBuffered in Test := false

scalacOptions ++= Seq("-unchecked", "-deprecation")

//resolvers += "typesafe" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.lihaoyi" %% "cask" % "0.5.6",
  "com.lihaoyi" %% "requests" % "0.5.0",
  "com.lihaoyi" %% "utest" % "0.7.3" % "test"
  //"org.scalactic" %% "scalactic" % "3.0.8",
  //"org.scalatest" %% "scalatest" % "3.0.8" % "test"
)

testFrameworks += new TestFramework("utest.runner.Framework")