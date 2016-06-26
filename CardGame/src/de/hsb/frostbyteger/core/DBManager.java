/**
 * 
 */
package de.hsb.frostbyteger.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
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
	
	private static String DB_TYPE = "mysql";
	private static String DB_IP = "195.37.176.178";
	private static String DB_PORT = "11336";
	private static String DB_SCHEMA = "dbwebanw_sose16_09";
	private static String DB_USER = "dbweb_user_09";
	private static String DB_PW = "CntsPF";
	
	private Connection conn = null;
	
	/**
	 * 
	 */
	public DBManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:" + DB_TYPE + "://" + DB_IP + ":" + DB_PORT + "/" + DB_SCHEMA, DB_USER, DB_PW);
			System.out.println(conn.getMetaData().getURL());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#addUser()
	 */
	@Override
	public boolean addUser(User u) {
		int success = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO User (Name, Email, Password) VALUES (?,?,?)");
			stmt.setString(1, u.getName()); // Check for null
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getPassword());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			success = 0;
		}
		return success > 0 ? true : false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#updateUser()
	 */
	@Override
	public boolean updateUser(User u, String currentUser) {
		int success = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE User SET Name = ?, Email = ?, Password = ?, Rights = ?, Gold = ?, ActiveDeck = ? WHERE Name = ? LIMIT 1");
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getPassword());
			stmt.setInt(4, u.getRights());
			stmt.setInt(5, u.getGold());
			stmt.setInt(6, u.getActiveDeck());
			stmt.setString(7, currentUser);
			success = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			success = 0;
		}
		return success > 0 ? true : false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#removeUser()
	 */
	@Override
	public boolean removeUser(String name) {
		int success = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM User WHERE Name = ? LIMIT 1");
			stmt.setString(1, name);
			success = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			success = 0;
		}
		
		return success > 0 ? true : false;
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
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_XML)
	@Override
	public User getUser(@QueryParam("name")String name) {
		ResultSet resultData = null;
		User u = null;
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User WHERE Name = ? LIMIT 1");
			stmt.setString(1, name);
			resultData = stmt.executeQuery();
			while(resultData.next()){
				u = new User(resultData.getString(1), resultData.getString(2), resultData.getString(3), 
							 resultData.getInt(4), resultData.getInt(5), resultData.getInt(6));
				System.out.println("REQUESTED USER DATA: " + u.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return u;
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
	
	public boolean closeConnection(){
		try {
			conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		closeConnection();
	}	
}
