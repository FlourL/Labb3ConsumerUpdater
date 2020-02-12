package com.example.consumer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class MyRequest {
	protected ArrayList<User> user;
	protected URL url;
	protected HttpURLConnection con;
	public MyRequest(String urlS) {
		try {
			url = new URL(urlS);
			con = (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("URL MALFORMED");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("CONNECTION TO API FAILED");
		}
	}public void sendPOSTRequest(User user) {
		try {
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			
			
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
	}
}
