/**
 * 
 */
package de.hsb.frostbyteger.servlets;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.hsb.frostbyteger.core.BackendManager;
import de.hsb.frostbyteger.core.Card;
import de.hsb.frostbyteger.core.User;

/**
 * @author kevin Kuegler
 * @version 1.00
 */
@WebServlet(urlPatterns={"/content/CreateDeck","/content/createDeck"})
public class DeckServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2698068695100736239L;
	private BackendManager bm = new BackendManager();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

		try {
			String username = request.getParameter("username");
			String email = "";
			String password = request.getParameter("password");
			User user = new User(username, email, password);
			if (true) {
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
		HttpSession session = request.getSession(false);
		User u = (User) session.getAttribute("currentSessionUser");
		ArrayList<Card> cards = bm.getPlayerCards(request, u.getName());
		request.setAttribute("cards", cards);
		//response.sendRedirect(request.getContextPath() + "/content/createdeck.jsp");
		request.getRequestDispatcher("/content/createdeck.jsp").forward(request, response);
	}
}
