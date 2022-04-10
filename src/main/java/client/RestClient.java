package client;

import app.Book;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

public class RestClient {
    private static final String REST_URI = "http://localhost:8080/rest/dish/1";

    private Client client = ClientBuilder.newClient();

    public Book getMenu(int id) {
        return client.target(REST_URI).path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).get(Book.class);
    }
}
