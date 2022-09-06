package controller;

import java.util.Scanner;

public class Choice {
	Scanner sc= new Scanner(System.in);
	private int choice;

	public Choice(int choice) {
		super();
		this.choice = choice;
	}
	
	public int user_choice() {
		choice = sc.nextInt();
		
		return choice;
	}
	
	
	
}
