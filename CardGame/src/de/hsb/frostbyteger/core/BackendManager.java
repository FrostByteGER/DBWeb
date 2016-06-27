/**
 * 
 */
package de.hsb.frostbyteger.core;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * @author kevin Kuegler
 * @version 1.00
 */
@Path("/BDManager")
public class BackendManager implements BusinessInterface {

	/**
	 * 
	 */
	public BackendManager() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hsb.frostbyteger.core.BusinessInterface#registerUser(de.hsb.
	 * frostbyteger.core.User)
	 */
	@POST
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public boolean registerUser(@Context HttpServletRequest req, User u) {
		DBManager dbm = getDBManager(req);
		return dbm.addUser(u);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hsb.frostbyteger.core.BusinessInterface#deleteUser(java.lang.String)
	 */
	@DELETE
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public boolean deleteUser(@Context HttpServletRequest req, @QueryParam("name") String name) {
		DBManager dbm = getDBManager(req);
		req.getSession().getAttribute("");
		return dbm.removeUser(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hsb.frostbyteger.core.BusinessInterface#updateUser(de.hsb.frostbyteger
	 * .core.User)
	 */
	@PUT
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public boolean updateUser(@Context HttpServletRequest req, User u, @QueryParam("name") String currentName) {
		DBManager dbm = getDBManager(req);
		return dbm.updateUser(u, currentName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hsb.frostbyteger.core.BusinessInterface#loginUser(de.hsb.frostbyteger.
	 * core.User)
	 */
	public boolean loginUser(HttpServletRequest req, User u) {
		DBManager dbm = getDBManager(req);
		if (u == null) {
			return false;
		}
		User user = dbm.getUser(u.getName());
		// Return false if the user was not found or the password is incorrect
		if (user == null || !user.getPassword().equals(u.getPassword())) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hsb.frostbyteger.core.BusinessInterface#logoutUser(de.hsb.frostbyteger
	 * .core.User)
	 */
	@Override
	public boolean logoutUser(@Context HttpServletRequest req, User u) {
		// TODO: Remove or use, currently handled by LogoutServlet
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hsb.frostbyteger.core.BusinessInterface#buyCard(java.lang.String,
	 * de.hsb.frostbyteger.core.User, int)
	 */
	@Override
	public boolean buyCard(HttpServletRequest req, String id, User u, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hsb.frostbyteger.core.BusinessInterface#sellCard(java.lang.String,
	 * de.hsb.frostbyteger.core.User, int)
	 */
	@Override
	public boolean sellCard(HttpServletRequest req, String id, User u, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hsb.frostbyteger.core.BusinessInterface#getCard(java.lang.String)
	 */
	@Override
	public Card getCard(HttpServletRequest req, String id) {
		DBManager dbm = getDBManager(req);
		return dbm.getCard(id);
	}

	private DBManager getDBManager(HttpServletRequest req) {
		return (DBManager) req.getServletContext().getAttribute("DBManager");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hsb.frostbyteger.core.BusinessInterface#createDeck(de.hsb.frostbyteger
	 * .core.Deck)
	 */
	@Override
	public boolean createDeck(HttpServletRequest req, Deck d) {
		DBManager dbm = getDBManager(req);
		return dbm.addDeck(d);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hsb.frostbyteger.core.BusinessInterface#updateDeck(de.hsb.frostbyteger
	 * .core.Deck)
	 */
	@Override
	public boolean updateDeck(HttpServletRequest req, Deck d) {
		DBManager dbm = getDBManager(req);
		return dbm.updateDeck(d);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hsb.frostbyteger.core.BusinessInterface#removeDeck(de.hsb.frostbyteger
	 * .core.Deck)
	 */
	@Override
	public boolean removeDeck(HttpServletRequest req, Deck d) {
		DBManager dbm = getDBManager(req);
		return dbm.removeDeck(d.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hsb.frostbyteger.core.BusinessInterface#removeDeck(int)
	 */
	@Override
	public boolean removeDeck(HttpServletRequest req, int id) {
		DBManager dbm = getDBManager(req);
		return dbm.removeDeck(id);
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.BusinessInterface#getPlayerCard(java.lang.String)
	 */
	@Override
	public ArrayList<Card> getPlayerCards(HttpServletRequest req, String username) {
		DBManager dbm = getDBManager(req);
		return dbm.getPlayerCards(username);
	}

}
