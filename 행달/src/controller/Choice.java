package controller;

import java.util.Scanner;

import model.DynamicArr;

public class Choice {
	Scanner sc= new Scanner(System.in);
	private int choice;
	private DynamicArr summary;
	
	
	public Choice(int choice, DynamicArr summary) {
		super();
		this.choice = choice;
		summary.add(10);
		this.summary = summary;
	}
	
	
	public int user_choice(int choice) {
		summary.add(choice);
		return choice;
	}
	
	
	
}
