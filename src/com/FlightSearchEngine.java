package com;

import java.util.Scanner;

public class FlightSearchEngine extends SearchFlight {
	private static int cnt=1;
	
	public static void main(String[] args) {

		while(cnt==1)
		{
			SearchFlight sf = new SearchFlight();
			sf.scanDetails();
		}
	}
}