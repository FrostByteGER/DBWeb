package de.hsb.frostbyteger.start;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
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
		String plainAnswer = "NULL";
		String htmlAnswer = "NULL";
		String xmlAnswer = "NULL";
		String jsonAnswer = "NULL";

		// GET REQUESTS
		response  = target.path("rest/DBManager").request().accept(MediaType.TEXT_PLAIN).get(Response.class).toString();
		xmlAnswer = target.path("rest/DBManager").queryParam("name", "admin").request().accept(MediaType.TEXT_XML).get(User.class).toString();

		System.out.println(response);
		System.out.println(plainAnswer);
		System.out.println(htmlAnswer);
		System.out.println(xmlAnswer);
		System.out.println(jsonAnswer);

		// DELETE REQUESTS
		response = target.path("rest/DBManager").queryParam("name", "admin").request().accept(MediaType.TEXT_PLAIN).delete().toString();

		System.out.println(response);

	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/CardGame/").build();
	}
}
