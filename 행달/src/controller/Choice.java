package controller;

import model.DynamicArr;
import model.UserDTO;

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

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public void setSummary(DynamicArr summary) {
		this.summary = summary;
	}

	public int getNext() {
		return next;
	}

	
	public void setNext(int next) {
		this.next = next;
	}

	public int choice(int choice) {
		
		sequence++;
		if (choice == 1) {
			setNext((sequence)*10);
			return (sequence)*10;
		} else if (choice == 2) {
			setNext((sequence));
			return (sequence);
		}else {
			return sequence;
		}

		
	}
	

	

}
