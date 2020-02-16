package com.example.consumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class MyRequestHandler {
	private String url;
	private HttpURLConnection con;
	public MyRequestHandler(String url) {
			this.url = url;
	}public void sendAddUserRequest(User user, String urlMapping) {
		try {
			URL connectTo = new URL(url + urlMapping);
			con = (HttpURLConnection) connectTo.openConnection();
			System.out.println("Connected");
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			String jsonString = user.toJsonString(false);
			try(OutputStream os = con.getOutputStream()) {
				OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
				osw.write(jsonString);
				osw.flush();
				osw.close();
				System.out.println(jsonString + " --SENT TO DATABASE");
			}
		
			System.out.println("Flushed it all");
			try(BufferedReader br = new BufferedReader(
					  new InputStreamReader(con.getInputStream(), "utf-8"))) {
					    StringBuilder response = new StringBuilder();
					    String responseLine = null;
					    while ((responseLine = br.readLine()) != null) {
					        response.append(responseLine.trim());
					    }
					    System.out.println(response.toString());
					}
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("IOEXCEPTION REACHED");
			}
	}public void sendGETRequest(String urlMapping) {
		System.out.println("Reached");
		try {
			URL connectTo = new URL(url + urlMapping);
			con = (HttpURLConnection) connectTo.openConnection();
			System.out.println("Connected");
			con.setDoOutput(true);
			con.setRequestMethod("GET");
			try(BufferedReader br = new BufferedReader(
					  new InputStreamReader(con.getInputStream(), "utf-8"))) {
					    StringBuilder response = new StringBuilder();
					    String responseLine = null;
					    while ((responseLine = br.readLine()) != null) {
					        response.append(responseLine.trim());
					    }
					    System.out.println("RESPONSE FROM API: " + response.toString());
					    System.out.println("");
					}
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("IOEXCEPTION REACHED");
			}
	}
}
