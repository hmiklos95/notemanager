name := """jpatest"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

libraryDependencies ++= Seq(
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",
  "org.hibernate" % "hibernate-jpamodelgen" % "5.1.0.Final"
)

javacOptions ++= Seq("-s", "app")

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.36"
// http://mvnrepository.com/artifact/org.mockito/mockito-core
libraryDependencies += "org.mockito" % "mockito-core" % "2.0.52-beta"

PlayKeys.externalizeResources := false