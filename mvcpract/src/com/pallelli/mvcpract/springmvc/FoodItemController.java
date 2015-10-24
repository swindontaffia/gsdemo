package com.pallelli.mvcpract.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pallelli.hibpract.dietlog.DietLogDao;
import com.pallelli.hibpract.dietlog.beans.FoodItem;


@Controller
@RequestMapping("/getAllFoodItems")
public class FoodItemController {

	@Autowired 
	private DietLogDao dietLogDao;
	
   @RequestMapping(method = RequestMethod.GET)
   public ModelAndView printHello(ModelMap model) {
	  List<FoodItem> foodItems = dietLogDao.getAllFoodItems(); 
	  ModelAndView modelAndView = new ModelAndView("foodItemList");
	  modelAndView.addObject("foodItems", foodItems);
	  
      return modelAndView;
   }

}