package com.springmvc.pojo;

import java.util.List;

public class QueryVo {

	private Items items;
	
	private String[] ids;
	
	private List<Items> itemList;
	
	public Items getItems() {
		return this.items;
	}
	
	public void setItems(Items items) {
		this.items = items;
	}
	
	public String[] getIds() {
		return this.ids;
	}
	
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	
	public List<Items> getItemList(){
		return this.itemList;
	}
	
	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}
}
