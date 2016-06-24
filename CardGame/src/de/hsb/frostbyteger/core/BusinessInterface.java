/**
 * 
 */
package de.hsb.frostbyteger.core;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kevin Kuegler
 * @version 1.00
 */
public interface BusinessInterface {

	
	boolean registerUser(HttpServletRequest req, User u);
	boolean deleteUser(HttpServletRequest req, String name);
	boolean updateUser(HttpServletRequest req, User u, String currentName);
	
	boolean loginUser(HttpServletRequest req, User u);
	boolean logoutUser(HttpServletRequest req, User u);
	
	boolean buyCard(String id, User u, int amount);
	boolean sellCard(String id, User u, int amount);
	Card getCard(String id);
}
