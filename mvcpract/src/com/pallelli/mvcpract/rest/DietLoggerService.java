package com.pallelli.mvcpract.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pallelli.hibpract.dietlog.DietLogDao;
import com.pallelli.hibpract.dietlog.beans.FoodItem;


@Path("fooditem")
@Component
public class DietLoggerService {
	
	Logger log = Logger.getLogger(DietLoggerService.class);
	
	@Autowired
	private DietLogDao dietLogDao;
	

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFoodItem(FoodItem foodItem) {
		
		dietLogDao.addFoodItem(foodItem);
		log.debug("Added food item " + foodItem.getName());
		foodItem.setName(foodItem.getName()+" : processed");
		return Response.ok(foodItem).status(200).build();
	}
	
	@GET
	@Path("list")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response listFoodItems() {
		
		List<FoodItem> foodItems = dietLogDao.listFoodItems();
		return Response.ok(foodItems).status(200).build();
	}
}	

