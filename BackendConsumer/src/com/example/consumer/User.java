package com.example.consumer;

import org.json.JSONObject;

public class User {
	public int Id;
	public String Name;
	public String Proffesion;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getProffesion() {
		return Proffesion;
	}
	public void setProffesion(String proffesion) {
		this.Proffesion = proffesion;
	}
	public String toJsonString(boolean includeID) {
		JSONObject jsonO = new JSONObject();
		if(includeID) 
			jsonO.put("id", Id);
		jsonO.put("name", this.Name);
		jsonO.put("proffesion", this.Proffesion);
		return jsonO.toString();
		
	}
	
}
