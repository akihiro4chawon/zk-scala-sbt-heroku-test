import com.typesafe.startscript.StartScriptPlugin

seq(StartScriptPlugin.startScriptForClassesSettings: _*)

seq(webSettings :_*)

name := "zktweetbot"

organization := "com.github.akihiro4chawon"

version := "0.0.1"

libraryDependencies ++= Seq(
  "org.zkoss.zk" % "zk" % "6.0.0",
  "org.zkoss.zk" % "zkbind" % "6.0.0",
  "org.mortbay.jetty" % "jetty" % "6.1.22" % "container",
  "org.eclipse.jetty" % "jetty-server" % "7.4.5.v20110725",
  "org.eclipse.jetty" % "jetty-servlet" % "7.4.5.v20110725",
  "org.mortbay.jetty" % "jetty-runner" % "7.5.4.v20111024",
  "javax.servlet" % "servlet-api" % "2.5" % "provided->default"
)

resolvers += "ZK CE" at "http://mavensync.zkoss.org/maven2"

resolvers += "Jetty Repo" at "http://repository.codehaus.org"

