package lsd.common.dto.json;

import io.swagger.annotations.ApiModelProperty;

public interface Response {
 	public static final String CODE_FAILED = "-1"; 
    public static final String MSG_FAILED = "failed"; 
    public static final String CODE_SUCCESS = "1"; 
    public static final String MSG_SUCCESS = "success";
    public static final String CODE_EMPTY = "0";
    public static final String MSG_EMPTY = "empty";
    
    @ApiModelProperty(name="状态码",value="状态码")
    String getCode();
    
    @ApiModelProperty(name="结果描述",value="结果描述")
	String getMsg();
}
