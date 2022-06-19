package com.ty.bootfoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.bootfoodapp.dao.FoodOrderDao;
import com.ty.bootfoodapp.dto.FoodOrder;
import com.ty.bootfoodapp.dto.Item;
@Service
public class FoodOrderService {
	
	@Autowired
	FoodOrderDao foodOrderDao;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		List<Item> items = foodOrder.getItems();
		double cost=0;
		for(Item item : items) {
			item.setFoodOrder(foodOrder);
			cost+=(item.getQty()*item.getCost());
		}
		foodOrder.setCost(cost);
		return foodOrderDao.saveFoodOrder(foodOrder);
	}
	
	public List<FoodOrder> getAllFoodOrders(){
		return foodOrderDao.getAllFoodOrders();
	}
	
	public FoodOrder getFoodOrderById( int id){
		return foodOrderDao.getFoodOrderById(id);
	}
	
	public FoodOrder updateFoodOrderById( FoodOrder foodOrder ,  int id){
		List<Item> items = foodOrder.getItems();
		double cost=0;
		for(Item item : items) {
			item.setFoodOrder(foodOrder);
			cost+=(item.getQty()*item.getCost());
		}
		foodOrder.setCost(cost);
		return foodOrderDao.updateFoodOrderById(foodOrder, id);
	}
	
	public String deleteFoodOrderById( int id){
		return foodOrderDao.deleteFoodOrderById(id);
	}
}
