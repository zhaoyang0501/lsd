package lsd.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@ApiModel(value="用户基本信息")
public class UserDto {
	
	@ApiModelProperty(value="用户名（手机号码）")
	private String username;
	
	@JsonIgnore
	private String password;
	
	@ApiModelProperty(value="email")
	private String email;
	
	private String salt;
	
	@ApiModelProperty(value="备注")
	private String remark;
	
	@ApiModelProperty(value="备用电话号码")
	private String tel;
	
	@ApiModelProperty(value="姓名")
	private String chinesename ="";
	
	@ApiModelProperty(value="性别")
	private String sex;
	
	@ApiModelProperty(value="积分")
	private Integer score = 0;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getChinesename() {
		return chinesename;
	}

	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
}
