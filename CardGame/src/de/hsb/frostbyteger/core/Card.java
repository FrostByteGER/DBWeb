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
	private int atk;
	private int def;
	private int mana;
	private String tribe;
	private int cost;

	/**
	 * @param name
	 * @param atk
	 * @param def
	 * @param mana
	 * @param tribe
	 * @param cost
	 */
	public Card(String name, int atk, int def, int mana, String tribe, int cost) {
		this.name = name;
		this.atk = atk;
		this.def = def;
		this.mana = mana;
		this.tribe = tribe;
		this.cost = cost;
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
	 * @return the mana
	 */
	public final int getMana() {
		return mana;
	}
	/**
	 * @param mana the mana to set
	 */
	public final void setMana(int mana) {
		this.mana = mana;
	}
	/**
	 * @return the tribe
	 */
	public final String getTribe() {
		return tribe;
	}
	/**
	 * @param tribe the tribe to set
	 */
	public final void setTribe(String tribe) {
		this.tribe = tribe;
	}
}
