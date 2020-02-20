name := "fsm-interface"
organization := "au.com.carringbushsw"
organizationName := "carringbush software"
version := "1.0-SNAPSHOT"

scalaVersion := "2.13.1"
scalacOptions ++= Seq("-unchecked", "-deprecation")

logBuffered in Test := false
//resolvers += "typesafe" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.lihaoyi" %% "cask" % "0.5.6",
  "com.lihaoyi" %% "requests" % "0.5.0",
  "com.lihaoyi" %% "pprint" % "0.5.6",
  "com.lihaoyi" %% "utest" % "0.7.3" % "test",

  "au.com.carringbushsw" %% "fsm-machine" % "1.0-SNAPSHOT"

  //"org.scalactic" %% "scalactic" % "3.0.8",
  //"org.scalatest" %% "scalatest" % "3.0.8" % "test"
)

testFrameworks += new TestFramework("utest.runner.Framework")