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

	public void choice(int choice) {
		
		sequence++;
		if (choice == 1) {
			setNext((sequence)*10);
//			dto.setSave((sequence)*10) // 여기에 이걸 저장하는데 성공만하면 그냥 불러올 수있어
		} else if (choice == 2) {
			setNext((sequence));
		}

		
	}
	

	

}
