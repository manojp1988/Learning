package demo.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletDemo
 */
@WebServlet(name="ServletDemo",
		urlPatterns = { 
				"/demo"
		}, 
		initParams = { 
				@WebInitParam(name = "name", value = "Manoj")
		})
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	  System.out.println("Servlet destroyed...");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Service method called..");
		}*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("do Get called .. "+ getServletName());
	    HttpSession session = request.getSession();
	    System.out.println(session.getCreationTime());
	    System.out.println(session.getLastAccessedTime());
	    System.out.println(session.isNew());
	     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  System.out.println("do Post called .. ");
	}

}
