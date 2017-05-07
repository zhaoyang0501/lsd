package lsd.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lsd.common.web.AbstractBaseCURDController;
import lsd.sys.entity.Food;
import lsd.sys.service.FoodService;

@Controller
@RequestMapping("sys/food")
public class FoodController extends AbstractBaseCURDController<Food,Long>{
	
	@Override
	public FoodService getSimpleCurdService() {
		return (FoodService)super.getSimpleCurdService();
	}
	
	@Override
	protected String getBasePath() {
		return "sys/food";
	}
	
	@Override
	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("categorys", this.getSimpleCurdService().findAllCategory());
		return this.getBasePath()+"/index";
	}
	
}
