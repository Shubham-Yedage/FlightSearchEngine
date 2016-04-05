package com;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FlightSearchEngineClient {
    private static SearchFlight sf;
    public static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        URL resource = FlightSearchEngineClient.class.getClassLoader().getResource("resources");
        File dir = new File(resource.getPath());
        List<String> path = new ArrayList<>();
        for (File f : dir.listFiles()) {
            path.add(f.getAbsolutePath());
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

        System.out.println(sf.getHeaders());
        for (Flight obj : finalList) {
            System.out.println(obj);
        }

    }
}