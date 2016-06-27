/**
 * 
 */
package de.hsb.frostbyteger.core;

import java.util.ArrayList;

/**
 * @author kevin Kuegler
 * @version 1.00
 */
public interface DAOInterface {

	boolean addUser(User u);
	boolean updateUser(User u, String currentName);
	boolean removeUser(String name);
	boolean setActiveDeck(String name, int deckID);
	
	boolean addDeck(Deck d);
	boolean updateDeck(Deck d);
	boolean removeDeck(int id);
	
	User getUser(String name);
	Card getCard(String name);
	Deck getDeck(int id);
	
	ArrayList<Card> getPlayerCards(String username);
	Deck getActivePlayerDeck(String username);
	ArrayList<Deck> getPlayerDecks(String username);
	
	boolean addCardToUser(String name, String cardName, int amount);
	boolean addCardToDeck(int deckID, String cardName, int amount);

}
