package com.test;

public class Seat {
	private boolean allotted;
	private int seatNumber;

	public Seat(int seatNumber){
		this.seatNumber = seatNumber;
	}
	public boolean isAllotted() {
		return allotted;
	}

	public void setAllotted(boolean allotted) {
		this.allotted = allotted;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

}
