package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightSearchEngineClient {
    private static SearchFlight sf;

    public static void main(String[] args) {
        String[] paths = new String[]{
                "/home/synerzip/workspace/FlightSearchEngine/csv_Files/AIR_FRANCE.csv",
                "/home/synerzip/workspace/FlightSearchEngine/csv_Files/BRITISH_AIRWAYS.csv",
                "/home/synerzip/workspace/FlightSearchEngine/csv_Files/LUFTHANSA_AIRWAYS.csv",
                "/home/synerzip/workspace/FlightSearchEngine/AirIndia.csv"};
        sf = new SearchFlight(paths);
        scanDetails();
    }

    public static void scanDetails() {

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
        List<String> finalList = sf.getFlights(depLoc, arrLoc, flightDate, choice);
        sc.close();
        for (String obj : finalList) {
            System.out.println(obj);
        }

    }
}