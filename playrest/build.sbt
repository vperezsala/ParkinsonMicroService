name := """PlayREST"""
organization := "com.aj"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.10"

libraryDependencies += guice

//Drools

libraryDependencies ++= Seq(
  "org.drools" % "drools-core" % "8.36.0.Final",
  "org.drools" % "drools-compiler" % "8.36.0.Final",
  "org.drools" % "drools-xml-support" % "8.36.0.Final",
  "org.drools" % "drools-mvel" % "8.36.0.Final"


)