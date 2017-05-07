package lsd.sys.service;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import lsd.common.service.SimpleCurdService;
import lsd.sys.entity.Food;
import lsd.sys.entity.FoodCategory;
import lsd.sys.repository.FoodCategoryRepository;
import lsd.sys.repository.FoodRepository;

@Service
public class FoodService extends SimpleCurdService<Food, Long> {
	
	@Autowired
	private FoodCategoryRepository foodCategoryRepository;
	
	@Autowired
	private FoodRepository foodRepository;
	
	public List<Food> findAll(){
		return (List<Food>) this.simpleCurdRepository.findAll();
	}
	
	public List<Food> findByCategory(Long categoryid){
		return foodRepository.findByFoodCategoryId(categoryid);
	}
	public List<FoodCategory> findAllCategory(){
		return (List<FoodCategory>)this.foodCategoryRepository.findAll();
	}
	
	
}
