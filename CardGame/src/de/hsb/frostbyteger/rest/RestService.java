/**
 * 
 */
package de.hsb.frostbyteger.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import de.hsb.frostbyteger.core.BackendManager;

/**
 * @author kevin Kuegler
 * @version 1.00
 */
@ApplicationPath("rest")
public class RestService extends Application {

	
	/**
	 * 
	 */
	public RestService() {
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see javax.ws.rs.core.Application#getClasses()
	 */
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> returnValue = new HashSet<Class<?>>( );
		returnValue.add( BackendManager.class );
		return returnValue;
	}
}
