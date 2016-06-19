/**
 * 
 */
package de.hsb.frostbyteger.core;

/**
 * @author kevin Kuegler
 * @version 1.00
 */
public interface BusinessInterface {

	
	boolean registerUser(User u);
	boolean deleteUser(String name);
	boolean updateUser(User u);
	
	boolean loginUser(User u);
	boolean logoutUser(User u);
	
	boolean buyCard(String id, User u, int amount);
	boolean sellCard(String id, User u, int amount);
	Card getCard(String id);
}
