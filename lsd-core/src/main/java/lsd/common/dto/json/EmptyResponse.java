package lsd.common.dto.json;
public class EmptyResponse implements Response {
	private String code;
	private String msg;
    /**
     * 无参构造方法，初始化数据
     */
    public EmptyResponse() {
        this.code = "-1";
        this.msg = "empty";
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
