package lsd.admin.dto;

import java.util.List;

import lsd.sys.entity.FoodItem;

public class FormDto {
	private Long id;
	
	private List<FoodItem> foodItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}
	
	
}
