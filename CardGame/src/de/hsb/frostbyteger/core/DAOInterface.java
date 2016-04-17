/**
 * 
 */
package de.hsb.frostbyteger.core;

/**
 * @author kevin Kuegler
 * @version 1.00
 */
public interface DAOInterface {

	boolean addUser();
	boolean updateUser();
	boolean removeUser();
	
	boolean addDeck(Deck d);
	boolean updateDeck(Deck d);
	boolean removeDeck(String id);
	
	User getUser(String name);
	Card getCard(String id);
	Deck getDeck(String id);

}
