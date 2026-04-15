package org.reminstant;

import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JettyApp {

  private static final Logger log = LoggerFactory.getLogger(JettyApp.class);

  private static final int PORT = 8080;

  public static void main(String[] args) throws Exception {
    var passwordGenerator = new PasswordGenerator();

    Server server = new Server(PORT);
    ServletContextHandler context = new ServletContextHandler();
    context.setContextPath("/");

    context.addServlet(
        new ServletHolder(new PasswordServlet(passwordGenerator)),
        "/password"
    );

    server.setHandler(context);
    server.start();

    log.info("App started on http://localhost:{}", PORT);
  }
}
