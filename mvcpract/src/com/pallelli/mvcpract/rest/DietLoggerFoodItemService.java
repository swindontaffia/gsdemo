package com.pallelli.mvcpract.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pallelli.hibpract.dietlog.DietLogDao;
import com.pallelli.hibpract.dietlog.beans.FoodItem;


@Path("fooditem")
@Component
public class DietLoggerFoodItemService {
	
	Logger log = Logger.getLogger(DietLoggerFoodItemService.class);
	
	@Autowired
	private DietLogDao dietLogDao;
	

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFoodItem(FoodItem foodItem) {
		
		dietLogDao.addFoodItem(foodItem);
		log.debug("Added food item " + foodItem.getName());
		return Response.ok(foodItem).status(200).build();
	}
	
	@GET
	@Path("getall")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllFoodItems() {
		
		List<FoodItem> foodItems = dietLogDao.getAllFoodItems();
		return Response.ok(foodItems).status(200).build();
	}
	
	@GET
	@Path("getnamed")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFoodItem(@QueryParam("name") String name) {
		
		FoodItem foodItem = dietLogDao.getNamedFoodItem(name);
		return Response.ok(foodItem).status(200).build();
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateFoodItems(FoodItem foodItem) {
		
		dietLogDao.updateFoodItem(foodItem);
		return Response.ok(foodItem).status(200).build();
	}
	
	@DELETE
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFoodItem(@QueryParam("name") String name) {
		
		dietLogDao.deleteFoodItem(name);
		return Response.ok("deleted food item " + name).status(200).build();
	}
	

}	

