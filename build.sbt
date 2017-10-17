name := "hdfs-scala-example"

organization := "bleibinhaus"

version := "0.1"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "org.apache.hadoop" % "hadoop-client" % "2.8.1",
  "org.scalatest" % "scalatest_2.10" % "3.0.3" % "test"
)

initialCommands := "import bleibinhaus.hdfsscalaexample._"

