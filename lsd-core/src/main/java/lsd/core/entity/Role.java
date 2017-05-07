package lsd.core.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lsd.common.entity.BaseEntity;

@Entity
@Table(name = "t_sys_role")
public class Role extends BaseEntity<Long>{
	
	private String code;
	
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
