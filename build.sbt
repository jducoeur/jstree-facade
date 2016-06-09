lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "jsTree Facade"

normalizedName := "jstree-facade"

version := "0.3"

organization := "org.querki"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.10.5", "2.11.8")

libraryDependencies ++= Seq(
  "org.querki" %%% "querki-jsext" % "0.7",
  "org.scala-js" %%% "scalajs-dom" % "0.9.0",
  "org.querki" %%% "jquery-facade" % "1.0-RC5"
)

jsDependencies += "org.webjars" % "jstree" % "3.2.1" / "jstree.js" minified "jstree.min.js"

jsDependencies in Test += RuntimeDOM

homepage := Some(url("http://www.querki.net/"))

licenses += ("MIT License", url("http://www.opensource.org/licenses/mit-license.php"))

scmInfo := Some(ScmInfo(
    url("https://github.com/jducoeur/jstree-facade"),
    "scm:git:git@github.com:jducoeur/jstree-facade.git",
    Some("scm:git:git@github.com:jducoeur/jstree-facade.git")))

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := (
  <developers>
    <developer>
      <id>jducoeur</id>
      <name>Mark Waks</name>
      <url>https://github.com/jducoeur/</url>
    </developer>
  </developers>
)

pomIncludeRepository := { _ => false }
