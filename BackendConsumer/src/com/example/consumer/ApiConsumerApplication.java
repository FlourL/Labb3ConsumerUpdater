package com.example.consumer;

import java.util.Scanner;

public class ApiConsumerApplication {
	
	public static void main(String[] args) {
		String choice = "";
		MyRequestHandler mrh = new MyRequestHandler("https://tom-backend2020.herokuapp.com");
		Scanner read = new Scanner(System.in);
		while(!choice.equals("END")) {
			System.out.println("do you want to: 1. add a new user, 2. clear the database, 3. display current users, END: to stop the application");
			choice = read.nextLine();
			switch(choice) {
				case "1":
					User user = new User();
					System.out.println("--ADDING NEW USER--");
					System.out.print("FULL NAME:");
					user.setName(read.nextLine());
					System.out.print("PROFFESION:");
					user.setProffesion(read.nextLine());
					mrh.sendAddUserRequest(user, "/addUser");
					break;
				case "2":
					mrh.sendGETRequest("/clearUsers");
					break;
				case "3":
					mrh.sendGETRequest("/userList");
					break;
			};
		}
	}
}
