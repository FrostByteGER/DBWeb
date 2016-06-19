/**
 * 
 */
package de.hsb.frostbyteger.core;

/**
 * @author kevin Kuegler
 * @version 1.00
 */
public class BackendManager implements BusinessInterface{

	private DBManager dbm;
	
	/**
	 * 
	 */
	public BackendManager() {
		dbm = new DBManager();
	}
	
	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.BusinessInterface#registerUser(de.hsb.frostbyteger.core.User)
	 */
	@Override
	public boolean registerUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.BusinessInterface#deleteUser(java.lang.String)
	 */
	@Override
	public boolean deleteUser(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.BusinessInterface#updateUser(de.hsb.frostbyteger.core.User)
	 */
	@Override
	public boolean updateUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.BusinessInterface#loginUser(de.hsb.frostbyteger.core.User)
	 */
	@Override
	public boolean loginUser(User u) {
		if(u == null){
			return false;
		}
		User user = dbm.getUser(u.getName());
		// Return false if the user was not found or the password is incorrect
		if(user == null || !user.getPassword().equals(u.getPassword())){
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.BusinessInterface#logoutUser(de.hsb.frostbyteger.core.User)
	 */
	@Override
	public boolean logoutUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.BusinessInterface#buyCard(java.lang.String, de.hsb.frostbyteger.core.User, int)
	 */
	@Override
	public boolean buyCard(String id, User u, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.BusinessInterface#sellCard(java.lang.String, de.hsb.frostbyteger.core.User, int)
	 */
	@Override
	public boolean sellCard(String id, User u, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see de.hsb.frostbyteger.core.BusinessInterface#getCard(java.lang.String)
	 */
	@Override
	public Card getCard(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
