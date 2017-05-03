package fr.imie.spring.model;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class AjaxResponseModel<T> {
	
	private List<T> data;
	private String message;
	
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> list) {
		this.data = list;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isError(){
		return StringUtils.isNotBlank(message);
	}
}
