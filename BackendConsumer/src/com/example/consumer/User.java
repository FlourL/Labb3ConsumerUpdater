package com.example.consumer;

import org.json.JSONObject;

public class User {
	int id;
	String name;
	String proffesion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProffesion() {
		return proffesion;
	}
	public void setProffesion(String proffesion) {
		this.proffesion = proffesion;
	}
	public String toJsonString(boolean includeID) {
		JSONObject jsonO = new JSONObject();
		if(includeID) 
			jsonO.put("id", id);
		jsonO.put("name", name);
		jsonO.put("proffesion", proffesion);
		return jsonO.toString();
		
	}
	
}
