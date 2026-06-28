import com.peknight.build.gav
import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val ip4s = (project in file("."))
  .settings(name := "ip4s")
  .aggregate(ip4sCore.projectRefs *)

lazy val ip4sCore = (projectMatrix in file("ip4s-core"))
  .settings(name := "ip4s-core")
  .settings(libraryDependencies ++= dependencies(comcast.ip4s))
  .settings(libraryDependencies ++= testDependencies(scalaTest))
  .jvmPlatform(scalaVersions = Seq(scala.scala3.version))
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))
