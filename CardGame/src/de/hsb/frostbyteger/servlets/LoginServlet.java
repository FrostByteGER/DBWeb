package de.hsb.frostbyteger.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.hsb.frostbyteger.core.BackendManager;
import de.hsb.frostbyteger.core.User;

@WebServlet(urlPatterns={"/Login", "/login"})
/** * Servlet implementation class LoginServlet */
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1358293869737825629L;
	private BackendManager bm = new BackendManager();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		//String url = request.getRequestURL().toString();
		//String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
		//System.out.println(baseURL);
		//System.out.println(request.getRequestURI());
		System.out.println("REQUESTING LOGIN FROM: " + request.getRemoteAddr());
		try {
			String username = request.getParameter("username");
			String email = "";
			String password = request.getParameter("password");
			User user = new User(username, email, password);
			if (bm.loginUser(request, user)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				if(user.getName() == "admin"){
					response.sendRedirect(request.getContextPath() + "/content/home.jsp");
				}else{
					response.sendRedirect(request.getContextPath() + "/content/home.jsp");
				}
				
			} else {
				response.sendRedirect("InvalidLogin.jsp");
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		doPost(request, response);
	}
	
	

}