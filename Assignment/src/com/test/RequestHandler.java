package com.test;

public class RequestHandler {
	
	private Theater theater;
	
	
	public RequestHandler(Theater theater){
		this.theater = theater;
	}
	
	public void handleRequest(TicketRequest request ){
		ReturnResultWrapper wrapper = theater.canFit(request.getRequestSeat());
		if(wrapper == null){
			request.setMessage(request.getName() +" Sorry, we can't handle your party.");
		}else if(wrapper.getReturnTypeEnum() == ReturnTypeEnum.CANNOT_FIT_ENTIRE){
			request.setMessage(request.getName() +" Sorry, we can't handle your party.");
		}else if(wrapper.getReturnTypeEnum() == ReturnTypeEnum.FIT_WITH_SPLIT){
			request.setMessage(request.getName() +" Call to split party.");
		}else{
			wrapper.getSection().alloteSeats(request.getRequestSeat());
			request.setMessage(request.getName() +  " Row " + wrapper.getRow().getRowNumber() + " Section " + wrapper.getSection().getSectionNumber());
		}
	}
	
}
