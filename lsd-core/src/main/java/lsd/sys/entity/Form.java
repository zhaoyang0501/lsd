package lsd.sys.entity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lsd.common.entity.BaseEntity;
@Entity
@Table(name = "t_form")
public class Form extends BaseEntity<Long>{
	
	private Date endTime;
	
	@ManyToOne
	private FrontUser user;
	
	private Double price;
	
	private String payType;
	
	private String seatName;
	
	/**1新建 2完成 */
	private String state="1";
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "form")
	private Set<FoodItem> foodItem = new HashSet<FoodItem>();
	
	
	public Set<FoodItem> getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(Set<FoodItem> foodItem) {
		this.foodItem = foodItem;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public FrontUser getUser() {
		return user;
	}

	public void setUser(FrontUser user) {
		this.user = user;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	
	
}
