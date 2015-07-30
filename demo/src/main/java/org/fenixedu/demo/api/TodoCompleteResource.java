package org.fenixedu.demo.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.fenixedu.bennu.core.domain.Bennu;
import org.fenixedu.bennu.core.rest.BennuRestResource;
import org.fenixedu.demo.domain.Todo;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Path("/todos")
public class TodoCompleteResource extends BennuRestResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonElement view() {
        accessControl("anyone");

        return view(Bennu.getInstance().getTodoSet(), "todos");

    }

    @GET
    @Path("{todoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject view(@PathParam("todoId") Todo todo) {

        accessControl("anyone");

        return view(todo);

    }

    @PUT
    @Path("{todoId}")
    public JsonElement update(@PathParam("todoId") Todo todo, @FormParam("todoJson") JsonElement todoJson) {

        accessControl("anyone");

        return view(update(todoJson, todo));

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject create(@FormParam("todoJson") JsonObject todoJson) {

        accessControl("anyone");

        return view(create(todoJson, Todo.class));

    }

    @DELETE
    @Path("{todoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("todoId") Todo todo) {
        todo.delete();
        return ok();
    }

}