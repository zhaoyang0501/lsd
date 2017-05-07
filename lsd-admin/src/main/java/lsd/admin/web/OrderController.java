package lsd.admin.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lsd.common.dto.json.DataTableResponse;
import lsd.common.dto.json.FailedResponse;
import lsd.common.dto.json.ObjectResponse;
import lsd.common.dto.json.Response;
import lsd.common.dto.json.SuccessResponse;
import lsd.common.web.AbstractBaseCURDController;
import lsd.sys.entity.Food;
import lsd.sys.entity.FoodItem;
import lsd.sys.entity.Form;
import lsd.sys.entity.FrontUser;
import lsd.sys.entity.Order;
import lsd.sys.entity.Seat;
import lsd.sys.service.FoodService;
import lsd.sys.service.FormService;
import lsd.sys.service.FrontUserService;
import lsd.sys.service.OrderService;

@Controller
@RequestMapping("sys/order")

public class OrderController extends AbstractBaseCURDController<Order,Long>{
	@Autowired
	private FrontUserService FrontUserService;
	
	@Autowired
	private FormService formService;
	
	@Autowired
	private FoodService foodService;
	@InitBinder  
	protected void initBinder(HttpServletRequest request,  
	            ServletRequestDataBinder binder) throws Exception {   
	      binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));  
	} 
	
	@RequestMapping("neworder")
	public String index(Model model) {
		model.addAttribute("foods", this.foodService.findAll());
		return this.getBasePath()+"/neworder";
	}
	/***
	 * 下订单
	 * @param userName
	 * @param seatName
	 * @return
	 */
	@RequestMapping("open")
	@ResponseBody
	public Response open(String userName) {
		
		
		FrontUser user = FrontUserService.findByUserName(userName);
		if(user==null){
			return new FailedResponse("会员不存在");
		}
		Form form = new Form();
		form.setUser(user);
		formService.save(form);
		
		return new ObjectResponse<Form>(form);
	}
	

	/***
	 * 加入购物车
	 * @param model
	 * @param formid
	 * @param foodid
	 * @return
	 */
	@RequestMapping("additem")
	@ResponseBody
	public Response additem(Model model,Long formid,Long foodid) {
		
		Form form = formService.find(formid);
		Food food = foodService.find(foodid);
		if(isFoodInForm(form,food)){
			for(FoodItem foodItem:form.getFoodItem()){
				if(foodItem.getFood().getId().equals(food.getId())){
					foodItem.setNum(foodItem.getNum()+1);
				}
			}
		}else{
			FoodItem item = new FoodItem();
			item.setFood(food);
			item.setForm(form);
			item.setNum(1);
			item.setPrice(food.getPrice());
			form.getFoodItem().add(item);
		}
		Double totalprice=0d;
		for(FoodItem item: form.getFoodItem()){
			totalprice+=item.getNum()*item.getPrice();
		}
		form.setPrice(totalprice);
		formService.save(form);
		return new SuccessResponse();
	}
	
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
	public String check(Model model,Long formid) {
		
		Form form = formService.find(formid);
		form.setEndTime(new Date());
		Double totalprice=0d;
		for(FoodItem item: form.getFoodItem()){
			totalprice+=item.getNum()*item.getPrice();
		}
		form.setPrice(totalprice);
		form.setState("2");
		
		formService.save(form);
		model.addAttribute("response",new SuccessResponse("付款成功！"));
		model.addAttribute("foods", this.foodService.findAll());
		return this.getBasePath()+"/neworder";
	}
	@Override
	public OrderService getSimpleCurdService() {
		return (OrderService)super.getSimpleCurdService();
	}
	
	@RequestMapping("pass")
	@ResponseBody
	public Response pass(Long id) {
		Order order = this.simpleCurdService.find(id);
		order.setState("2");
		simpleCurdService.save(order);
		return new SuccessResponse();
	}
	
	@RequestMapping("nopass")
	@ResponseBody
	public Response nopass(Long id) {
		Order order = this.simpleCurdService.find(id);
		order.setState("4");
		simpleCurdService.save(order);
		return new SuccessResponse();
	}
	
	@Override
	protected String getBasePath() {
		return "sys/order";
	}
	
	@RequestMapping("listall")
	@ResponseBody
	public Response listall(Integer start, Integer length, Date orderDate) {
		int pageNumber = (int) (start / length) + 1;
		int pageSize = length;
		Page<Order> m = getSimpleCurdService().findAll(pageNumber, pageSize, orderDate);
		return new DataTableResponse<Order>( m.getContent(),(int) m.getTotalElements() );
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
