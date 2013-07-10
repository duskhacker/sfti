import sbt._
import sbt.Keys._

object Dependencies {
  val scalaTest = "org.scalatest" %% "scalatest" % "1.9.1" % "test"
//  val slick = "com.typesafe.slick" %% "slick" % "1.0.0"
//  val slf4j = "org.slf4j" % "slf4j-simple" % "1.6.4"
//  val mysqlConnector = "mysql" % "mysql-connector-java" % "5.1.17"
  
}

object Sfti extends Build {
  import Dependencies._

  lazy val sfti = Project(
    id = "sfti",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "Scala for the impatient",
      organization := "ws.zepeda",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.1",
      resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases",
      libraryDependencies ++= Seq(scalaTest)
    )
  )
}
