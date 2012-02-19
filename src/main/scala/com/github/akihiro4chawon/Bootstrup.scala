package com.github.akihiro4chawon

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.DefaultServlet
import org.eclipse.jetty.servlet.ServletContextHandler
import org.eclipse.jetty.servlet.ServletHolder
import org.eclipse.jetty.webapp.WebAppContext

object RunJetty extends scala.App {
  val port = envPort getOrElse 8080
  val server = new Server(port)
  val context = createWebappContext("src/main/webapp")
  server.setHandler(context)
  server.start()
  server.join()
  
  private def envPort: Option[Int] =
    Option(System getenv "PORT") map Integer.parseInt
  
  private def createWebappContext(webapp: String) = {
    val context = new WebAppContext()
    context.setDescriptor(webapp+"WEB-INF/web.xml")
    context.setResourceBase(webapp)
    context.setContextPath("/")
    context.setParentLoaderPriority(true)
    context
  }
}
