/**
 * 
 */
package de.hsb.frostbyteger.servlets;

import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.hsb.frostbyteger.core.User;

/**
 * @author kevin Kuegler
 * @version 1.00
 */
@WebServlet(urlPatterns={"/content/playGame","/content/PlayGame"})
public class GameServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8997047562757293967L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		System.out.println(">>>PLAYING AGAINST CPU<<<");
		Random rnd = new Random();
		String winner = "";
		float value = rnd.nextFloat();
		System.out.println("FLOAT IS: " + value);
		if(value > 0.5f){
			winner = "CPU";
		}else{
			HttpSession session = request.getSession(false);
			User u = (User) session.getAttribute("currentSessionUser");
			if(u != null){
				winner = u.getName();
			}
		}
		System.out.println("WINNTER IS: " + winner);
		response.sendRedirect(request.getContextPath() + "/content/home.jsp");
	}
}
