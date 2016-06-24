/**
 * 
 */
package de.hsb.frostbyteger.core;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author kevin Kuegler
 * @version 1.00
 */
@WebListener
public class AppContextListener implements ServletContextListener {

	
	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		
		DBManager dbm = new DBManager();
		ctx.setAttribute("DBManager", dbm);
		System.out.println("Database connection successfully initialized for Application");

	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		DBManager dbm = (DBManager) ctx.getAttribute("DBManager");
		boolean result = dbm.closeConnection();
		System.out.println("Closing Database connection: " + result);
	}



}
