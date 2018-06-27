lazy val akkaHttpVersion = "10.1.3"
lazy val akkaVersion    = "2.5.13"
lazy val alpakkaVersion = "0.19"

scalacOptions += "-Ypartial-unification"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization    := "cataclysm",
      scalaVersion    := "2.12.6",
      version := "0.0.1"
    )),
    name := "scala-functional-cats_testing",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-xml"        % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream"          % akkaVersion,
      "com.lightbend.akka" %% "akka-stream-alpakka-amqp" % alpakkaVersion,
      "org.json4s" %% "json4s-core" % "3.6.0-M4",
      "org.json4s" %% "json4s-native" % "3.6.0-M4",
      "org.json4s" %% "json4s-jackson" % "3.6.0-M4",
      "de.heikoseeberger" %% "akka-http-json4s" % "1.21.0",
      "com.typesafe" % "config" % "1.3.3",

      "ch.qos.logback"    %  "logback-classic"   % "1.2.3",

      "joda-time" % "joda-time" % "2.10",

      "com.typesafe.akka" %% "akka-http-testkit"    % akkaHttpVersion % Test,
      "com.typesafe.akka" %% "akka-testkit"         % akkaVersion     % Test,
      "com.typesafe.akka" %% "akka-stream-testkit"  % akkaVersion     % Test,
      "org.scalatest"     %% "scalatest"            % "3.2.0-SNAP10"  % Test,

      "org.typelevel" %% "cats-core" % "1.1.0"
    )
  )

enablePlugins(JavaAppPackaging)