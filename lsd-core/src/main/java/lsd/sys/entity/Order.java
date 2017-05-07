package lsd.sys.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lsd.common.entity.BaseEntity;


@Entity
@Table(name = "t_order")
public class Order extends BaseEntity<Long>{
	private Date orderDate;
	@ManyToOne
	private FrontUser frontUser;
	private Integer num;
	private String remark;
	/**1 待审核 2预定成功 3客户取消 4 预定失败*/
	private String state="1";
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")  
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")  
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public FrontUser getFrontUser() {
		return frontUser;
	}
	public void setFrontUser(FrontUser frontUser) {
		this.frontUser = frontUser;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
