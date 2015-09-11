package com.test;

import java.util.ArrayList;
import java.util.List;

public class Section {

	public List<Seat> seats = new ArrayList<Seat> ();
	private int totalAvaliable =0;
	private int totalSeats = 0;
	 private int sectionNumber;
	 private Row row;
	
	 public Section(int sectionNumber,Row row){
			this.sectionNumber = sectionNumber;
			this.row = row;
	}
	 
	 
	 
	public void addSeats(int totalSeats){
		for(int i= 0;i< totalSeats;i++){
			seats.add(new Seat(i+1));
		}
		totalAvaliable = totalAvaliable + totalSeats;
		this.row.setTotalAvaliable(this.row.getTotalAvaliable() + totalSeats);
		this.row.getTheater().setTotalAvaliable(this.row.getTheater().getTotalAvaliable() + totalSeats);
		this.totalSeats  = this.totalSeats + totalSeats;
		
		
	}
	
	public boolean isSeatAvaliables(int requestSeatNumbers){
		if(requestSeatNumbers > totalAvaliable){
			return false;
		}
		return true;
	}
	
	public void alloteSeats(int requestSeatNumbers){
		int tempRequestNumber = requestSeatNumbers;
		for(int i= 0;i< seats.size();i++){
			if(requestSeatNumbers >0 && !seats.get(i).isAllotted()){
				seats.get(i).setAllotted(true);
				requestSeatNumbers--;
				totalAvaliable = totalAvaliable - 1;
			}
		}
		row.setTotalAvaliable(row.getTotalAvaliable() - tempRequestNumber);
		row.getTheater().setTotalAvaliable(row.getTheater().getTotalAvaliable() - tempRequestNumber);
	}
	
	public ReturnTypeEnum canFit(int requestSeatNumbers){
		if(requestSeatNumbers > totalAvaliable){
			return ReturnTypeEnum.CANNOT_FIT_SECTION;
		} else if (requestSeatNumbers == totalAvaliable){
			return ReturnTypeEnum.BEST_FIT;
		}else {
			return ReturnTypeEnum.CAN_FIT;
		}
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public int getSectionNumber() {
		return sectionNumber;
	}

	public int getTotalAvaliable() {
		return totalAvaliable;
	}
	
}
