package lsd.admin.web;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lsd.admin.dto.FormDto;
import lsd.common.dto.json.FailedResponse;
import lsd.common.dto.json.ObjectResponse;
import lsd.common.dto.json.Response;
import lsd.common.dto.json.SuccessResponse;
import lsd.common.web.AbstractBaseCURDController;
import lsd.sys.entity.Food;
import lsd.sys.entity.FoodItem;
import lsd.sys.entity.Form;
import lsd.sys.entity.FrontUser;
import lsd.sys.entity.Seat;
import lsd.sys.service.FoodService;
import lsd.sys.service.FormService;
import lsd.sys.service.FrontUserService;
import lsd.sys.service.SeatService;



@Controller
@RequestMapping("sys/seat")
public class SeatController extends AbstractBaseCURDController<Seat,Long>  {
	
	@Autowired
	private FrontUserService FrontUserService;
	
	@Autowired
	private FormService formService;
	
	@Autowired
	private FoodService foodService;
	
	@Override
	public SeatService getSimpleCurdService() {
		return (SeatService)super.getSimpleCurdService();
	}
	
	@Override
	public String getBasePath() {
		return "sys/seat";
	}
	/****
	 * 开台
	 * @param userName
	 * @param seatName
	 * @return
	 */
	@RequestMapping("open")
	@ResponseBody
	public Response open(String userName,String seatName) {
		
		Seat seat = getSimpleCurdService().findByName(seatName);
		
		FrontUser user = FrontUserService.findByUserName(userName);
		if(user==null){
			return new FailedResponse("会员不存在");
		}
		Form form = new Form();
		form.setSeatName(seatName);
		form.setUser(user);
		formService.save(form);
		
		seat.setState("1");
		seat.setForm(form);
		this.simpleCurdService.save(seat);
		return new SuccessResponse();
	}
	
	@RequestMapping("prechoose")
	@ResponseBody
	public Response choose(Model model,Long formid) {
		return new ObjectResponse<Form>(formService.find(formid));
	}
	/***
	 * 点击结账连接 查账单
	 * @param model
	 * @param formid
	 * @return
	 */
	@RequestMapping("precheck")
	@ResponseBody
	public Response precheck(Model model,Long formid) {
		Form form = formService.find(formid);
		Double totalprice=0d;
		for(FoodItem item: form.getFoodItem()){
			totalprice+=item.getNum()*item.getPrice();
		}
		form.setPrice(totalprice);
		
		return new ObjectResponse<Form>(formService.find(formid));
	}
	
	/***
	 * 执行付款动作
	 * @param model
	 * @param formid
	 * @return
	 */
	@RequestMapping("check")
	@ResponseBody
	public Response check(Model model,Long formid) {
		
		Form form = formService.find(formid);
		form.setEndTime(new Date());
		Double totalprice=0d;
		for(FoodItem item: form.getFoodItem()){
			totalprice+=item.getNum()*item.getPrice();
		}
		form.setPrice(totalprice);
		form.setState("2");
		Seat seat = getSimpleCurdService().findByName(form.getSeatName());
		seat.setState("2");
		seat.setForm(null);
		formService.save(form);
		this.getSimpleCurdService().save(seat);
		
		return new ObjectResponse<Form>(formService.find(formid));
	}
	@RequestMapping("choose")
	@ResponseBody
	public Response choose(Model model,FormDto formdto) {
		Form form = formService.find(formdto.getId());
		Set<FoodItem> foodItem = new HashSet<FoodItem>();
		if(formdto.getFoodItems()!=null){
			for(FoodItem item:formdto.getFoodItems()){
				FoodItem newitem = new FoodItem();
				newitem.setFood(foodService.find(item.getFood().getId()));
				newitem.setForm(form);
				newitem.setNum(item.getNum());
				newitem.setPrice(newitem.getNum()*newitem.getFood().getPrice());
				foodItem.add(newitem);
			}
		}
		Double totalprice=0d;
		for(FoodItem item: form.getFoodItem()){
			totalprice+=item.getNum()*item.getPrice();
		}
		form.setPrice(totalprice);
		form.setFoodItem(foodItem);
		formService.save(form);
		return new SuccessResponse();
	}
	
	@Override
	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("seats", this.getSimpleCurdService().findAll());
		model.addAttribute("foods", this.foodService.findAll());
		return this.getBasePath()+"/index";
	}
	
	@RequestMapping("formtodo")
	public String formtodo(Model model) {
		model.addAttribute("dones",formService.findByState("2"));
		return this.getBasePath()+"/formtodo";
	}
	
	
	private Boolean isFoodInForm(Form form,Food food){
		if(form.getFoodItem()!=null){
			for(FoodItem foodItem:form.getFoodItem()){
				if(foodItem.getFood().getId().equals(food.getId())){
					return true;
				}
			}
		}
		
		 return false;
	}
}
