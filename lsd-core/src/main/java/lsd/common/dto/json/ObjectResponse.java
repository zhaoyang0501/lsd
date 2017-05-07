package lsd.common.dto.json;

public class ObjectResponse<T> implements Response {
	private String code;
	private String msg;
    private T datas;
   
    public ObjectResponse(T datas) {
        this.code = "1";
        this.msg = "success";
        this.datas = datas;
    }

    public ObjectResponse(String code, String msg, T datas) {
        this.code = code;
        this.msg = msg;
        this.datas = datas;
    }
    
    public T getDatas() {
        return datas;
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
