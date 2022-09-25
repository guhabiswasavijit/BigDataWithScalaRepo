
lazy val commonSettings = Seq(
  organization := "com.self.scala.storm",
  version := "0.1.0",
  scalaVersion := "2.13.7"
)
lazy val root = (project in file("."))
  .settings(
    commonSettings,
    name := "ScalaStorm",
    scalaSource in Compile := baseDirectory.value / "src/main/scala",
    javacOptions ++= Seq("-source", "11", "-target", "11"),
    scalacOptions += "-deprecation"
    assembly / mainClass := Some("com.self.scala.storm.RandomSentenceSpout"),
    assembly / assemblyJarName := "ScalaStorm.jar",
    libraryDependencies +=
        "org.apache.storm" % "storm-core" % "1.0.2" % "provided"excludeAll(
        ExclusionRule(organization = "com.sun.jdmk"),
        ExclusionRule(organization = "com.sun.jmx"),
        ExclusionRule(organization = "javax.jms")
      )
  )
