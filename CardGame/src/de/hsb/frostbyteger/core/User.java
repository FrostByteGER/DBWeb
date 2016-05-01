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
	
	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
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
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
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
	 * @param password the password to set
	 */
	public final void setPassword(String password) {
		this.password = password;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}else if(!(obj instanceof User)){
			return false;
		}else if(!((User)obj).name.equals(this.name)){
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Username: " + name + " Email: " + email + " Password: " + password; 
	}

}
