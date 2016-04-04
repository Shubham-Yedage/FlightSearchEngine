package com;

import java.util.Scanner;

public class FlightSearchEngineClient {
	private static SearchFlight sf;

	public static void main(String[] args) {

		String[] paths = new String[] {
				"/home/synerzip/workspace/FlightSearchEngine/csv_Files/AIR_FRANCE.csv",
				"/home/synerzip/workspace/FlightSearchEngine/csv_Files/BRITISH_AIRWAYS.csv",
				"/home/synerzip/workspace/FlightSearchEngine/csv_Files/LUFTHANSA_AIRWAYS.csv",
				"/home/synerzip/workspace/AirIndia.csv"};
		sf = new SearchFlight(paths);
		scanDetails();

	}

	public static void scanDetails() {
		// TODO Auto-generated method stub
		int selCol;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Departure Location:");
		String depLoc = sc.next();
		System.out.println("Enter Arrival Location:");
		String arrLoc = sc.next();
		System.out.println("Enter Flight Date:");
		String flightDate = sc.next();
		System.out
				.println("Enter\n 1 To sort According To Fare\n 2 To sort According To Duration");
		int choice = sc.nextInt();
		if (choice == 1)
			selCol = 6;
		else
			selCol = 5;

		sf.getFlights(depLoc, arrLoc, flightDate, selCol);
		sc.close();

	}
}