package controller;

import model.DynamicArr;
import model.UserDAO;

public class Choice {

	private int sequence = 1;
	private int choice;
	private DynamicArr summary;
	private int next = 10;

	public int getSequence() {
		return sequence;
	}

	public int getChoice() {
		return choice;
	}

	public DynamicArr getSummary() {
		return summary;
	}

	public int getNext() {
		return next;
	}

	public void choice(int choice) {
		
		sequence++;
		if (choice == 1) {
			this.next = (sequence)*10;
		} else if (choice == 2) {
			this.next = sequence;
		}

		
	}

	

}
