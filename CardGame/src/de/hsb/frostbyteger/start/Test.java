package de.hsb.frostbyteger.start;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;

import de.hsb.frostbyteger.core.User;

public class Test {

	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();

		Client client = ClientBuilder.newClient(config);

		WebTarget target = client.target(getBaseURI());
		String response = "NULL";
		User responseUser = null;
		boolean useGET    = true;
		boolean useINSERT = true;
		boolean useUPDATE = false;
		boolean useDELETE = false;
		
		// GET REQUESTS
		if (useGET) {
			System.out.println(">>>GET REQUEST<<<");
			response = target.path("rest/DBManager").request(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_XML)
					.get(Response.class).toString();
			responseUser = target.path("rest/DBManager").queryParam("name", "deleteDummy").request(MediaType.TEXT_PLAIN)
					.accept(MediaType.TEXT_XML).get(User.class);
			System.out.println(response);
			System.out.println(responseUser);
		}
		
		// INSERT REQUESTS
		if (useINSERT) {
			System.out.println("\n>>>INSERT REQUEST<<<");
			User insertUser = new User("deleteDummy", "delete@dummy.com", "deleteDummy");
			response = target.path("rest/DBManager").request(MediaType.TEXT_XML).accept(MediaType.TEXT_PLAIN)
					.post(Entity.entity(insertUser, MediaType.TEXT_XML), Response.class).toString();
			responseUser = target.path("rest/DBManager").queryParam("name", "deleteDummy").request()
					.accept(MediaType.TEXT_XML).get(User.class);
			System.out.println(response);
			System.out.println(responseUser);
		}
		
		// UPDATE REQUESTS
		if (useUPDATE) {
			System.out.println("\n>>>UPDATE REQUEST<<<");
			User updateUser = new User("deleteDummy", "update@dummy.com", "UpdatedDummy");
			response = target.path("rest/DBManager").request().accept(MediaType.TEXT_PLAIN)
					.put(Entity.entity(updateUser, MediaType.TEXT_XML), Response.class).toString();
			responseUser = target.path("rest/DBManager").queryParam("name", "deleteDummy").request()
					.accept(MediaType.TEXT_XML).get(User.class);
			System.out.println(response);
			System.out.println(responseUser);
		}
		
		// DELETE REQUESTS
		if (useDELETE) {
			System.out.println("\n>>>DELETE REQUEST<<<");
			response = target.path("rest/DBManager").queryParam("name", "deleteDummy").request()
					.accept(MediaType.TEXT_PLAIN).delete().toString();
			responseUser = target.path("rest/DBManager").queryParam("name", "deleteDummy").request()
					.accept(MediaType.TEXT_XML).get(User.class);
			System.out.println(response);
			System.out.println(responseUser);
		}

	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/CardGame/").build();
	}
}
