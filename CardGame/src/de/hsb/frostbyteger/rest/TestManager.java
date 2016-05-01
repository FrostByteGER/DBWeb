/**
 * 
 */
package de.hsb.frostbyteger.rest;

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
@Path("/TestManager")
public class TestManager{

	@DELETE
	public boolean removeUser() {
		return true;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getUserPLAIN() {
		return "TESTUSER_PLAIN";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getUserHTML() {
		return "TESTUSER_HTML";
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String getUserXML() {
		return "TESTUSER_XML";
	}
}
