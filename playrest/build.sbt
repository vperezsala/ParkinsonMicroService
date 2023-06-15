name := """PlayREST"""
organization := "com.aj"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,SwaggerPlugin)

scalaVersion := "2.13.10"

libraryDependencies += guice

libraryDependencies += "org.webjars" % "swagger-ui" % "2.2.0"
swaggerDomainNameSpaces := Seq("entities")
swaggerPlayJava := true
swaggerPrettyJson := true

//Drools
libraryDependencies ++= Seq(
  "org.drools" % "drools-core" % "8.36.0.Final",
  "org.drools" % "drools-compiler" % "8.36.0.Final",
  "org.drools" % "drools-xml-support" % "8.36.0.Final",
  "org.drools" % "drools-mvel" % "8.36.0.Final"


)