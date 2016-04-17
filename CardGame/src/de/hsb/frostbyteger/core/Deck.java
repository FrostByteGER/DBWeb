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
	private String id;
	private ArrayList<Card> cards;
	//TODO: change to custom image class
	private Image cover;
	
	/**
	 * @param name
	 * @param id
	 * @param cards
	 * @param cover
	 */
	public Deck(String name, String id, ArrayList<Card> cards, Image cover) {
		this.name = name;
		this.id = id;
		this.cards = cards;
		this.cover = cover;
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
	public final String getId() {
		return id;
	}
}
