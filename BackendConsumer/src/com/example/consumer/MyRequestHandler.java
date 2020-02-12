package com.example.consumer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class MyRequestHandler {
	private URL url;
	private HttpURLConnection con;
	public MyRequestHandler(String urlS) {
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
			String jsonString = user.toJsonString(false);
			
			OutputStream os = con.getOutputStream();
			byte[] sendData = jsonString.getBytes("utf-8");
			os.write(sendData,0,sendData.length);
			
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("IOEXCEPTION REACHED");
			}
	}
}
