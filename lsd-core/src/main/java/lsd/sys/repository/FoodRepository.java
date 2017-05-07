package lsd.sys.repository;
import java.util.List;

import lsd.common.repository.SimpleCurdRepository;
import lsd.sys.entity.Food;
public interface FoodRepository   extends SimpleCurdRepository<Food ,Long>{
	public List<Food> findByFoodCategoryId(Long id);
}
