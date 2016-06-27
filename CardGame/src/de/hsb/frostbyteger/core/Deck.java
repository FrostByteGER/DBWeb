/**
 * 
 */
package de.hsb.frostbyteger.core;

import java.awt.Image;
import java.util.ArrayList;

/**
 * @author kevin Kuegler
 * @version 1.00
 */
public class Deck {

	
	private String name;
	private int id;
	private ArrayList<Card> cards;
	//TODO: change to custom image class
	private Image cover;
	private String user;
	private boolean playable;
	
	
	/**
	 * @param name
	 * @param id
	 * @param cards
	 * @param cover
	 * @param user
	 * @param playable
	 */
	public Deck(String name, int id, ArrayList<Card> cards, Image cover, String user, boolean playable) {
		this.name = name;
		this.id = id;
		this.cards = cards;
		this.cover = cover;
		this.user = user;
		this.playable = playable;
	}


	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the cards
	 */
	public final ArrayList<Card> getCards() {
		return cards;
	}


	/**
	 * @param cards the cards to set
	 */
	public final void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}


	/**
	 * @return the cover
	 */
	public final Image getCover() {
		return cover;
	}


	/**
	 * @param cover the cover to set
	 */
	public final void setCover(Image cover) {
		this.cover = cover;
	}


	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}


	/**
	 * @return the user
	 */
	public final String getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public final void setUser(String user) {
		this.user = user;
	}


	/**
	 * @return the playable
	 */
	public final boolean isPlayable() {
		return playable;
	}


	/**
	 * @param playable the playable to set
	 */
	public final void setPlayable(boolean playable) {
		this.playable = playable;
	}
}
