package app;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.grizzly.http.util.HttpStatus;

import java.util.List;

@Path("/rest")
public class BookResource {

    MenuService service = MenuService.getInstance();

    @GET
    @Path("/books")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks(){
        return service.getAll();
    }


    @GET
    @Path("/books/{id}")
    @Produces("application/json")
    public Response getBook(@PathParam("id") Long bookId) {
        try {
            return Response.ok(service.get(bookId)).build();
        } catch (Exception e) {
            return Response.serverError().status(HttpStatus.BAD_REQUEST_400.getStatusCode(), e.getMessage()).build();
        }
    }

    @POST
    @Path("/books")
    @Produces("application/json")
    public Response add(Book c) {
        service.add(c);
        return Response.ok(c).status(HttpStatus.CREATED_201.getStatusCode(), "Created").build();
    }

    @PUT
    @Path("/books/{id}")
    @Produces("application/json")
    public Response update(@PathParam("id") Long bookId, Book c) {
        try {
            return Response.ok(service.update(bookId,c.getName())).build();
        } catch (Exception e) {
            return Response.serverError().status(HttpStatus.BAD_REQUEST_400.getStatusCode(), e.getMessage()).build();
        }
    }

    @PATCH
    @Path("/menus/{id}")
    @Produces("application/json")
    public Response update2(@PathParam("id") Long bookId, @QueryParam("name") String name) {
        try {
            return Response.ok(service.update(bookId,name)).build();
        } catch (Exception e) {
            return Response.serverError().status(HttpStatus.BAD_REQUEST_400.getStatusCode(), e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/menus/{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") Long bookId) {
        try {
            service.delete(bookId);
            return Response.ok().status(HttpStatus.OK_200.getStatusCode()).build();
        } catch (Exception e) {
            return Response.serverError().status(HttpStatus.BAD_REQUEST_400.getStatusCode(), e.getMessage()).build();
        }
    }


}
