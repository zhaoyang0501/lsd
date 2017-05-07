package lsd.common.dto.json;


public class SuccessResponse implements Response {
	private String code;
	private String msg;
   
	public SuccessResponse(String msg){
		this.code = "1";
		this.msg=msg;
	}
    public SuccessResponse() {
        this.code = "1";
        this.msg = "success";
    }
	@Override
	public String getCode() {
		return code;
	}
	@Override
	public String getMsg() {
		return msg;
	}
}
