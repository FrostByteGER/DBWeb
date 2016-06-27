/**
 * 
 */
package de.hsb.frostbyteger.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		int success = 0;
		try{
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Deck (Name, Playable, UserName) VALUES (?,?,(SELECT Name FROM User WHERE Name = ?))");
			stmt.setString(1, d.getName());
			stmt.setBoolean(2, d.isPlayable());
			stmt.setString(3, d.getUser());
			success = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			success = 0;
		}
		return success > 0 ? true : false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#updateDeck(de.hsb.frostbyteger.core.Deck)
	 */
	@Override
	public boolean updateDeck(Deck d) {
		int success = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE Deck SET Name = ?, Playable = ?, UserName = (SELECT Name FROM User WHERE Name = ?) LIMIT 1");
			stmt.setString(1, d.getName());
			stmt.setBoolean(2, d.isPlayable());
			stmt.setString(3, d.getUser());
			success = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			success = 0;
		}
		return success > 0 ? true : false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#removeDeck(java.lang.String)
	 */
	@Override
	public boolean removeDeck(int id) {
		int success = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM Deck WHERE ID = ? LIMIT 1");
			stmt.setInt(1, id);
			success = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			success = 0;
		}
		
		return success > 0 ? true : false;
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
	public Card getCard(String name) {
		ResultSet resultData = null;
		Card c = null;
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Card WHERE Name = ? LIMIT 1");
			resultData = stmt.executeQuery();
			while(resultData.next()){
				c = new Card(resultData.getString(1), resultData.getInt(2), resultData.getInt(3), resultData.getInt(4), resultData.getString(5), resultData.getInt(6));
				System.out.println("REQUESTED CARD DATA: " + c.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//
		return c;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#getDeck(java.lang.String)
	 */
	@Override
	public Deck getDeck(int id) {
		ResultSet resultData = null;
		Deck d = null;
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Deck WHERE Deck.ID = ? LIMIT 1");
			stmt.setInt(1, id);
			resultData = stmt.executeQuery();
			while(resultData.next()){
				d = new Deck(resultData.getString(2), resultData.getInt(1), null, null, resultData.getString(4), resultData.getBoolean(3));
				System.out.println("REQUESTED DECK DATA: " + d.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return d;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#addCardToUser(java.lang.String, java.lang.String, int)
	 */
	@Override
	public boolean addCardToUser(String name, String cardName, int amount) {
		int success = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO User_has_Card (User_Name, Card_Name, Amount) VALUES(?,?,?)");
			stmt.setString(1, name);
			stmt.setString(2, cardName);
			stmt.setInt(3, amount);
			success = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			success = 0;
		}
		return success > 0 ? true : false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#addCardToDeck(int, java.lang.String, int)
	 */
	@Override
	public boolean addCardToDeck(int deckID, String cardName, int amount) {
		int success = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Deck_has_Card (Deck_ID, Card_Name, Amount) VALUES(?,?,?)");
			stmt.setInt(1, deckID);
			stmt.setString(2, cardName);
			stmt.setInt(3, amount);
			success = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			success = 0;
		}
		return success > 0 ? true : false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#setActiveDeck(int)
	 */
	@Override
	public boolean setActiveDeck(String name, int deckID) {
		int success = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE User SET ActiveDeck = ? WHERE Name = ? LIMIT 1");
			stmt.setInt(1, deckID);
			stmt.setString(2, name);
			success = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			success = 0;
		}
		return success > 0 ? true : false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#getPlayerCard(java.lang.String)
	 */
	@Override
	public ArrayList<Card> getPlayerCards(String username) {
		ResultSet resultData = null;
		ArrayList<Card> cards = new ArrayList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Card INNER JOIN User_has_Card ON User_has_Card.User_Name= ? GROUP BY Name");
			stmt.setString(1, username);
			resultData = stmt.executeQuery();
			while(resultData.next()){
				Card c = new Card(resultData.getString(1), resultData.getInt(2), resultData.getInt(3), resultData.getInt(4), resultData.getString(5), resultData.getInt(6));
				cards.add(c);
				System.out.println("REQUESTED CARD DATA: " + c.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//
		return cards;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#getActivePlayerDeck(java.lang.String)
	 */
	@Override
	public Deck getActivePlayerDeck(String username) {
		return null;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.DAOInterface#getPlayerDecks(java.lang.String)
	 */
	@Override
	public ArrayList<Deck> getPlayerDecks(String username) {
		ResultSet resultData = null;
		ArrayList<Deck> decks = new ArrayList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Deck WHERE Deck.UserName = ?");
			stmt.setString(1, username);
			resultData = stmt.executeQuery();
			while(resultData.next()){
				Deck d = new Deck(resultData.getString(2), resultData.getInt(1), null, null, resultData.getString(4), resultData.getBoolean(3));
				decks.add(d);
				System.out.println("REQUESTED CARD DATA: " + d.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//
		return decks;
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
