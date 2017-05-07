package lsd.sys.entity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lsd.common.entity.BaseEntity;
@Entity
@Table(name = "t_Seat")
public class Seat extends BaseEntity<Long>{
	
	private String name;
	/**1 使用中 空闲*/
	private String state;
	
	@ManyToOne
	private Form form;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
	
}
