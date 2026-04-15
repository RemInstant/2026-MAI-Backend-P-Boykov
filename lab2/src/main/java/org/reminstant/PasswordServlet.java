package org.reminstant;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class PasswordServlet extends HttpServlet {

  private static final int HTTP_OK = 200;

  private final transient PasswordGenerator passwordGenerator;

  public PasswordServlet(PasswordGenerator passwordGenerator) {
    this.passwordGenerator = passwordGenerator;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String password = passwordGenerator.generate();

    resp.setStatus(HTTP_OK);
    resp.getWriter().println(password);
  }
}
