/**
 * 
 */
package de.hsb.frostbyteger.core;

import java.awt.Image;

/**
 * @author kevin Kuegler
 * @version 1.00
 */
public class Card {

	
	private String name;
	private String ID;
	private int atk;
	private int def;
	private int cost;
	//TODO: change to custom image class
	private Image image;
	
	/**
	 * @param name
	 * @param iD
	 * @param atk
	 * @param def
	 * @param cost
	 * @param image
	 */
	public Card(String name, String iD, int atk, int def, int cost, Image image) {
		this.name = name;
		ID = iD;
		this.atk = atk;
		this.def = def;
		this.cost = cost;
		this.image = image;
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
	 * @return the atk
	 */
	public final int getAtk() {
		return atk;
	}
	/**
	 * @param atk the atk to set
	 */
	public final void setAtk(int atk) {
		this.atk = atk;
	}
	/**
	 * @return the def
	 */
	public final int getDef() {
		return def;
	}
	/**
	 * @param def the def to set
	 */
	public final void setDef(int def) {
		this.def = def;
	}
	/**
	 * @return the cost
	 */
	public final int getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public final void setCost(int cost) {
		this.cost = cost;
	}
	/**
	 * @return the image
	 */
	public final Image getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public final void setImage(Image image) {
		this.image = image;
	}
	/**
	 * @return the iD
	 */
	public final String getID() {
		return ID;
	}
}
