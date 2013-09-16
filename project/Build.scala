import sbt._
import Keys._
import play.Project._
import com.typesafe.sbteclipse.plugin.EclipsePlugin.EclipseKeys

object ApplicationBuild extends Build {

  val appName         = "censeurRest"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    cache,
    //anorm
    "com.typesafe.slick" % "slick_2.10" % "1.0.1",
    "com.typesafe.slick" %% "slick-extensions" % "1.0.0",
    "com.h2database" % "h2" % "1.3.166",
    "com.oracle" % "ojdbc6" % "11.2.0.3",
    "org.scala-lang" % "scala-actors" % "2.10.0" % "test",
    "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
	  // Add your own project settings here
    testOptions in Test := Nil,
	EclipseKeys.withSource := true,
	
	resolvers += "Nexus Cocktail" at "http://nexus.asso-cocktail.org/content/groups/public/"

  ).dependsOn(RootProject( uri("http://github.com/freekh/play-slick.git") ))
}
