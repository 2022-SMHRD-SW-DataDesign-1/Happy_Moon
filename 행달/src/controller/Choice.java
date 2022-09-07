package controller;

import model.DynamicArr;
import model.UserDAO;

public class Choice {

	private int sequence;
	private int choice;
	private DynamicArr summary;
	private int next;

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

	public Choice() {
		if (choice == 1) {
			this.next = (sequence + 1) * 10;
		} else if (choice == 2) {
			this.next = sequence + 1;
		}

		this.choice = choice;
		summary.add(sequence);

	}

	public int user_choice(int choice) {
		summary.add(choice);
		return choice;
	}

}
