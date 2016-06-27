/**
 * 
 */
package de.hsb.frostbyteger.core;

import java.util.ArrayList;

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

	boolean createDeck(HttpServletRequest req, Deck d);

	boolean updateDeck(HttpServletRequest req, Deck d);

	boolean removeDeck(HttpServletRequest req, Deck d);

	boolean removeDeck(HttpServletRequest req, int id);

	boolean buyCard(HttpServletRequest req, String id, User u, int amount);

	boolean sellCard(HttpServletRequest req, String id, User u, int amount);

	Card getCard(HttpServletRequest req, String id);
	
	ArrayList<Card> getPlayerCards(HttpServletRequest req, String username);
}
