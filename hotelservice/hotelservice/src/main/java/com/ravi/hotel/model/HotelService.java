package com.ravi.hotel.model;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/hotelservice")
public interface HotelService {

	@GET
	@Path("/hotels")
//	@Produces("application/json")
	List<Hotel> getHotels();

	@POST
	@Path("/hotels")
	Response addHotel(Hotel hotel);

	@GET
	@Path("/hotels/{id}")
	Response getHotelById(@PathParam("id") int id);

	@PUT
	@Path("/hotels")
	Response updateHotel(Hotel hotel);

	@DELETE
	@Path("/hotels/{id}")
	Response deleteHotel(@PathParam("id") int id);

	@GET
	@Path("/login/{username}/{password}")
	Status validateUser(@PathParam("username") String username, @PathParam("password") String password);

	@POST
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	Response addUser(String content);

}
