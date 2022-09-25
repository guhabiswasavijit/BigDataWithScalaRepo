
import sbt._
import Keys._
import Resolvers._

lazy val commonSettings = Seq(
  organization := "com.self",
  version := "0.1.0",
  scalaVersion := "2.10"
)

lazy val root = (project in file("."))
  .settings(
    commonSettings,
    name := "ScalaHadoop",
    Compile / scalaSource := baseDirectory.value / "src/main/scala",
    javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
    scalacOptions += "-deprecation",
    assembly / mainClass := Some("com.self.DruidDemo"),
    assembly / assemblyJarName := "ScalaDruid.jar",
    assembly / assemblyMergeStrategy := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case x => MergeStrategy.first
    },
    libraryDependencies += "com.ing.wbaa.druid" % "scruid" % "2.4.0"
  )

