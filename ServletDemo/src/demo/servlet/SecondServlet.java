package demo.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet(name = "SecondServlet", urlPatterns = "/sec")
public class SecondServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public SecondServlet() {
    super();
    // TODO Auto-generated constructor stub
  }


  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("do Get called .. " + getServletName());
    System.out.println("First name : " + request.getParameter("fname"));
    // response.setIntHeader("Refresh", 5);

    String fname = request.getParameter("fname");
    if (fname.length() < 3) {
      throw new ServletException("Validation Error!!");
    }
    response.sendRedirect("success.html");

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("do POST called .. " + getServletName());
    System.out.println("First name : " + request.getParameter("fname"));
    
    String fname = request.getParameter("fname");
    if (fname.length() < 3) {
      throw new ServletException("Validation Error!!");
    }
    response.sendRedirect("success.html");

  }

  /**
   * @see Servlet#destroy()
   */
  public void destroy() {
    System.out.println("Servlet destroyed...");
  }
}
