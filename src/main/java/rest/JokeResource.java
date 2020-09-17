/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.JokeFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author Christoffer
 */
@Path("joke")
public class JokeResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final JokeFacade FACADE = JokeFacade.getJokeFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJokeByID(@PathParam("id") Long id) {
        return Response.ok().entity(GSON.toJson(FACADE.getJokeByID(id))).build();
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJokes() {
        return Response.ok().entity(GSON.toJson(FACADE.getAllJokes())).build();
    }

    @Path("/type/{type}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJokesByType(@PathParam("type") String type) {
        return Response.ok().entity(GSON.toJson(FACADE.getAllJokesByType(type))).build();
    }
 @Path("/random")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRandomJoke() {
       return Response.ok().entity(GSON.toJson(FACADE.getRandomJoke())).build();
    }
    @Path("/count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getJokeCount() {
        long count = FACADE.getJokeCount();
        return "{\"count\":"+count+"}";  //Done manually so no need for a DTO
    }

    /**
     * PUT method for updating or creating an instance of JokeResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
