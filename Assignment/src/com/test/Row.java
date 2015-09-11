package com.test;

import java.util.ArrayList;
import java.util.List;

public class Row {
	
	int rowNumber = -1;
	public List<Section> sections = new ArrayList<Section> ();
	private int totalAvaliable = 0;
	private Theater theater;
	
	public Row(int rowNumber,Theater theater){
		this.rowNumber = rowNumber;
		this.theater = theater;
	}
	
	public Section addAndReturnSection(int sectionNumber, int totalSeats){
		Section rowSection = new Section(sectionNumber,this);
		addSections(rowSection);
		rowSection.addSeats(totalSeats);
		return rowSection;
	}
	
	public void addSections(Section section){
		sections.add(section);
	}

	public int getTotalAvaliable() {
		return totalAvaliable;
	}

	public void setTotalAvaliable(int totalAvaliable) {
		this.totalAvaliable = totalAvaliable;
	}
	
	public ReturnResultWrapper canFit(int requestSeatNumbers){
		if(requestSeatNumbers > totalAvaliable){
			return new ReturnResultWrapper(ReturnTypeEnum.CANNOT_FIT_ROW);
		}
		boolean alreadyset = false;
		ReturnResultWrapper returnResultWrapper = null;
		int tempTotalAvaliable = 0;
		for(Section section : sections){
			ReturnTypeEnum returnTypeEnum = section.canFit(requestSeatNumbers);
			if(returnTypeEnum == ReturnTypeEnum.BEST_FIT){
				return new ReturnResultWrapper(this,section,ReturnTypeEnum.BEST_FIT);
			}
			if(returnTypeEnum == ReturnTypeEnum.CAN_FIT && !alreadyset){
				returnResultWrapper = new ReturnResultWrapper(this,section,ReturnTypeEnum.CAN_FIT);
				alreadyset = true;
			}
			tempTotalAvaliable = tempTotalAvaliable + section.getTotalAvaliable();
		}
		
		if(returnResultWrapper == null && tempTotalAvaliable == requestSeatNumbers){
			returnResultWrapper =  new ReturnResultWrapper(ReturnTypeEnum.FIT_WITH_SPLIT);
		}
		
		return returnResultWrapper;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public Theater getTheater() {
		return theater;
	}
	
 }
