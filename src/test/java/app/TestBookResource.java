package app;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.glassfish.jersey.test.jdkhttp.JdkHttpServerTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestBookResource extends JerseyTest {

    @BeforeEach
    void init() throws Exception {
        super.setUp();
    }


    @Override
    protected Application configure() {
        //to start a new container in s different port
        forceSet(TestProperties.CONTAINER_PORT, "0");
        return new ResourceConfig(BookResource.class);
    }

    @Test
    public void get_one() throws Exception {
        Response response = target("/rest/menus/1").request().get();
        System.out.println("sd " + response.getStatus());
        assertEquals(response.getStatus(), 200);
        assertEquals(response.readEntity(Book.class).getName(), "Menu One");
    }

    protected TestContainerFactory getTestContainerFactory() {
        return new JdkHttpServerTestContainerFactory();
    }
}
