import sbt._
import Keys._
import Resolvers._

lazy val commonSettings = Seq(
  organization := "com.self.demo",
  version := "0.1.0",
  scalaVersion := "2.12.1"
)

lazy val root = (project in file("."))
  .settings(
    commonSettings,
    name := "ScalaHadoop",
    Compile / scalaSource := baseDirectory.value / "src/main/scala",
    javacOptions ++= Seq("-source", "11", "-target", "11"),
    scalacOptions += "-deprecation",
    assembly / mainClass := Some("com.self.scala.WordCount"),
    assembly / assemblyJarName := "ScalaHadoop.jar",
    assembly / assemblyMergeStrategy := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case x => MergeStrategy.first
    },
    libraryDependencies +=
          "org.apache.hadoop" % "hadoop-core" % "1.2.1" excludeAll(
          ExclusionRule(organization = "com.sun.jdmk"),
          ExclusionRule(organization = "com.sun.jmx"),
          ExclusionRule(organization = "javax.jms"),
          ExclusionRule(organization = "org.mortbay.jetty"),
          ExclusionRule(organization = "tomcat")
      )
  )

