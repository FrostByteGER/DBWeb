/**
 * 
 */
package de.hsb.frostbyteger.core;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author kevin Kuegler
 * @version 1.00
 */
@XmlRootElement
public class User {

	private String name;
	private String email;
	private String password;
	private int rights;
	private int gold;
	private int activeDeck;

	/**
	 * 
	 */
	public User() {
		this.name = "dummy";
		this.email = "dummy@dummy.com";
		this.password = name;
		this.rights = 0;
		this.gold = 0;
		this.activeDeck = -1;
	}

	/**
	 * @param name
	 * @param email
	 * @param password
	 */
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.rights = 0;
		this.gold = 0;
		this.activeDeck = -1;

	}

	/**
	 * @param name
	 * @param email
	 * @param password
	 * @param rights
	 * @param gold
	 * @param activeDeck
	 */
	public User(String name, String email, String password, int rights, int gold, int activeDeck) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.rights = rights;
		this.gold = gold;
		this.activeDeck = activeDeck;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public final String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public final void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the rights
	 */
	public final int getRights() {
		return rights;
	}

	/**
	 * @param rights
	 *            the rights to set
	 */
	public final void setRights(int rights) {
		this.rights = rights;
	}

	/**
	 * @return the gold
	 */
	public final int getGold() {
		return gold;
	}

	/**
	 * @param gold
	 *            the gold to set
	 */
	public final void setGold(int gold) {
		this.gold = gold;
	}

	/**
	 * @return the activeDeck
	 */
	public final int getActiveDeck() {
		return activeDeck;
	}

	/**
	 * @param activeDeck
	 *            the activeDeck to set
	 */
	public final void setActiveDeck(int activeDeck) {
		this.activeDeck = activeDeck;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (!(obj instanceof User)) {
			return false;
		} else if (!((User) obj).name.equals(this.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Username: " + name + " Email: " + email + " Password: " + password + " Rights: " + rights + " Gold: "
				+ gold + " Active Deck: " + activeDeck;
	}

}
