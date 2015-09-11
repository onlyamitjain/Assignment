package com.test;

import java.util.List;

public class TheaterTicketSystem {

	public static void main(String[] args) {
		Theater theater = new Theater();
		List<TicketRequest> ticketRequest = TheaterLayOutParser.parseAndPopuateTheater(theater,"TestFile.txt");
		RequestHandler handler = new RequestHandler(theater);
		for(TicketRequest request : ticketRequest){
			handler.handleRequest(request );
		}
		
		for(TicketRequest request : ticketRequest){
			System.out.println(request.getMessage());
		}
	}
}
