package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FlightSearchEngineClient {
	private static SearchFlight sf;
	private static String header;
	public static Scanner sc = new Scanner(System.in);

	public FlightSearchEngineClient(String header) {
		FlightSearchEngineClient.header = header;
	}

	public static void main(String[] args) {

		System.out.println("Enter number of .csv fils:");
		int totalFiles = sc.nextInt();
		System.out.println("Enter path for .csv file:");
		List<String> path = new ArrayList<>();
		for (int cnt = 0; cnt < totalFiles; cnt++) {
			path.add(sc.next());
		}

		sf = new SearchFlight(path, new HashMap<Integer, Comparator<Flight>>());
		scanDetails();
	}

	public static void scanDetails() {

		System.out.println("Enter Departure Location:");
		String depLoc = sc.next();
		System.out.println("Enter Arrival Location:");
		String arrLoc = sc.next();
		System.out.println("Enter Flight Date:");
		String flightDate = sc.next();
		System.out
				.println("Enter\n 1 To sort According To Fare\n 2 To sort According To Fare-Duration");
		int choice = sc.nextInt();
		List<Flight> finalList = sf.getFlights(depLoc, arrLoc, flightDate,
				choice);
		sc.close();

		System.out.println(header);
		for (Flight obj : finalList) {
			System.out.println(obj);
		}

	}
}