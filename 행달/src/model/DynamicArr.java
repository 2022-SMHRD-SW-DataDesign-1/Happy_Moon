package model;

public class DynamicArr {
	int size;
	int capacity;
	int growthFactor = 2;
	int[] arrPointer = null;

	DynamicArr() {
		// 현재는 아무 원소도 없으므로 0, capacity는 2로 잡음
		this.size = 0;
		this.capacity = this.growthFactor * 1;
		this.arrPointer = new int[this.capacity];
	}

	public void add(int newElement) {
		/*
		 * @newElement: 현재 array의 끝에 추가될 원소
		 */
		if (this.size < this.capacity) {
			// Size가 capacity보다 작을 때는 뭘 더 할 필요가 없음
			arrPointer[this.size] = newElement;
		} else {
			// Size가 capacity와 같아지므로, array의 크기를 더 크게 만들어서 잡아줘야 함.
			this.capacity = this.size * this.growthFactor;
			int[] newArrPointer = new int[this.capacity];
			for (int i = 0; i < this.size; i++) {
				newArrPointer[i] = this.arrPointer[i];
			}
			this.arrPointer = newArrPointer;
			this.arrPointer[this.size] = newElement;
		}
		this.size += 1;
	}

	void print() {
		// 그냥 현재 size, capacity와 원소들의 값을 출력함.
		System.out.printf("Size: %d Capacity: %d\n", this.size, this.capacity);
		for (int i = 0; i < this.arrPointer.length; i++) {
			System.out.printf("%d ", this.arrPointer[i]);
		}
		System.out.println("");
		System.out.println("===========================");
	}
}
