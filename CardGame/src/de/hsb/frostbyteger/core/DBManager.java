/**
 * 
 */
package de.hsb.frostbyteger.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author kevin Kuegler
 * @version 1.00
 */
@Path("/DBManager")
public class DBManager implements DAOInterface{
	
	/** TODO: Change to database so it is persistent. 
	 *  Everytime a REQUEST is executed
	 *  it will create a new instance of this class
	 *  rendering the add and delete methods useless
	 *  as they will only modify their local user arrays.
	 *  The static statement makes the array globally known across
	 *  all instances, actually making the delete and get methods useable.
	*/
	public static ArrayList<User> users;
	
	private static String DB_TYPE = "mysql";
	private static String DB_IP = "195.37.176.178";
	private static String DB_PORT = "11336";
	private static String DB_USER = "dbweb_user_09";
	private static String DB_PW = "CntsPF";
	
	/**
	 * 
	 */
	public DBManager() {
		users = new ArrayList<>();
		users.add(new User("admin","admin@server.de", "admin"));
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:" + DB_TYPE + "://" + DB_IP + ":" + DB_PORT, DB_USER, DB_PW);
			System.out.println(conn.getMetaData().getURL());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#addUser()
	 */
	@Override
	public boolean addUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#updateUser()
	 */
	@Override
	public boolean updateUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#removeUser()
	 */
	@DELETE
	@Override
	public boolean removeUser(@QueryParam("name")String name) {
		
		boolean success = users.remove(this.getUser(name));
		System.out.println("DELETED USER");
		System.out.println("USER SIZE: " + users.size() + "\n");
		return success;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#addDeck(de.hsb.frostbyteger.core.Deck)
	 */
	@Override
	public boolean addDeck(Deck d) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#updateDeck(de.hsb.frostbyteger.core.Deck)
	 */
	@Override
	public boolean updateDeck(Deck d) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#removeDeck(java.lang.String)
	 */
	@Override
	public boolean removeDeck(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#getUser(java.lang.String)
	 */
	@GET
	@Produces(MediaType.TEXT_XML)
	@Override
	public User getUser(@QueryParam("name")String name) {
		if(name.isEmpty()){
			return null;
		}
		User user = null;
		System.out.println("USER SIZE: " + users.size());
		for(User u : users){
			if(u.getName().equals(name)){
				System.out.println("FOUND USER\n");
				user = u;
				break;
			}
		}
		return user;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#getCard(java.lang.String)
	 */
	@Override
	public Card getCard(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#getDeck(java.lang.String)
	 */
	@Override
	public Deck getDeck(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
