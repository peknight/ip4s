import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val ip4s = (project in file("."))
  .settings(name := "ip4s")
  .aggregate(
    ip4sCore.jvm,
    ip4sCore.js,
  )

lazy val ip4sCore = (crossProject(JVMPlatform, JSPlatform) in file("ip4s-core"))
  .settings(name := "ip4s-core")
  .settings(crossDependencies(comcast.ip4s))
  .settings(crossTestDependencies(scalaTest))

