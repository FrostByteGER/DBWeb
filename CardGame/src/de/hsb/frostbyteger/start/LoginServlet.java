package de.hsb.frostbyteger.start;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.hsb.frostbyteger.core.BackendManager;
import de.hsb.frostbyteger.core.User;

@WebServlet(urlPatterns={"/LoginServlet"})
/** * Servlet implementation class LoginServlet */
public class LoginServlet extends HttpServlet {
	
	private BackendManager bm = new BackendManager();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		String url = request.getRequestURL().toString();
		String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
		System.out.println(baseURL);
		System.out.println(request.getRequestURI());
		try {
			String username = request.getParameter("username");
			String email = "";
			String password = request.getParameter("password");
			User user = new User(username, email, password);
			if (bm.loginUser(user)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				response.sendRedirect("UserLoggedIn.jsp");
			} else {
				response.sendRedirect("InvalidLogin.jsp");

			}

		} catch (Throwable theException) {
			System.out.println(theException);
		}

	}

}