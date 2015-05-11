name := "finatra-swagger"

version := "0.1"

scalaVersion:="2.11.1"

crossScalaVersions := Seq("2.10.0", "2.11.0")

resolvers ++= Seq(
  "Twitter" at "http://maven.twttr.com",
  "Finatra Repo" at "http://twitter.github.com/finatra"
)

libraryDependencies ++= Seq(
  "com.wordnik" % "swagger-core" % "1.5.3-M1",
  "com.twitter.finatra" %% "finatra-http" % "2.0.0.M1",
  "com.twitter.finatra" %% "finatra-http" % "2.0.0.M1" % "test",
  "com.twitter.inject" %% "inject-server" % "2.0.0.M1" % "test"
)