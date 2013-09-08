import sbt._
import Keys._
import play.Project._
import com.typesafe.sbteclipse.plugin.EclipsePlugin.EclipseKeys

object ApplicationBuild extends Build {

  val appName         = "bristolRest"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    //anorm
    "com.typesafe.slick" % "slick_2.10" % "1.0.1",
    "com.typesafe.slick" %% "slick-extensions" % "1.0.0",
    "com.h2database" % "h2" % "1.3.166",
    "org.scala-lang" % "scala-actors" % "2.10.0" % "test",
    "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
	  // Add your own project settings here
      testOptions in Test := Nil,
	  EclipseKeys.withSource := true
  )
}
