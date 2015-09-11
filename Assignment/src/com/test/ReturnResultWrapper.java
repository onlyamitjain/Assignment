package com.test;

public class ReturnResultWrapper {

	public ReturnTypeEnum returnTypeEnum;
	public Row row;
	public Section section;
	
	public ReturnResultWrapper(){
		
	}
	
    public ReturnResultWrapper(ReturnTypeEnum returnTypeEnum){
		this.returnTypeEnum = returnTypeEnum;
	}
    
    public ReturnResultWrapper(Row row,Section section,ReturnTypeEnum returnTypeEnum){
		this.returnTypeEnum = returnTypeEnum;
		this.row = row;
		this.section = section;
	}

	public ReturnTypeEnum getReturnTypeEnum() {
		return returnTypeEnum;
	}
	public void setReturnTypeEnum(ReturnTypeEnum returnTypeEnum) {
		returnTypeEnum = returnTypeEnum;
	}
	public Row getRow() {
		return row;
	}
	public void setRow(Row row) {
		this.row = row;
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	
}
