package lsd.common.dto.json;

import java.util.List;

public class DataTableResponse<T> implements Response {
	private String code;
	private String msg;
	private Integer recordsTotal;
	private Integer recordsFiltered;
	
    public Integer getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public Integer getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	private List<T> datas;

    public DataTableResponse(List<T> datas,Integer recordsTotal) {
        this.code = "1";
        msg = "success";
        this.datas = datas;
        this.recordsTotal=recordsTotal;
        this.recordsFiltered=recordsTotal;
    }

    public DataTableResponse(String code, String msg, List<T> datas) {
        this.code = code;
        this.msg = msg;
        this.datas = datas;
    }
    
    public List<T> getDatas() {
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
