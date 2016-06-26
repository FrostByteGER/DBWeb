package de.hsb.frostbyteger.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/content/logout", "/content/Logout" })
/** * Servlet implementation class LoginServlet */
public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1358293869737825629L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		HttpSession session = request.getSession(false);
		System.out.println("LOGGING OUT USER: " + session.getAttribute("currentSessionUser"));
		session.removeAttribute("currentSessionUser");
		session.invalidate();
		response.sendRedirect("../logout.jsp");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		HttpSession session = request.getSession(false);
		System.out.println("LOGGING OUT USER: " + session.getAttribute("currentSessionUser"));
		session.removeAttribute("currentSessionUser");
		session.invalidate();
		response.sendRedirect("../logout.jsp");
	}

}