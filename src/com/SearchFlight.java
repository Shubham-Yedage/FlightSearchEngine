package com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SearchFlight {
    public static final String STRING_COMMA = ",";
    protected ArrayList<String> listPath = new ArrayList<String>();

    private Map<Integer, Comparator<Flight>> sorter = new HashMap<>();

    public SearchFlight(String[] path , Map<Integer, Comparator<Flight>> extSorter ) {

        for (String p : path) {
            listPath.add(p);
        }

        sorter.put(2, new FareDurationComparator());
        sorter.putAll(extSorter);

    }


    public List<Flight> getFlights(String depLoc, String arrLoc, String flightDate,
                                   int choice) {

        String newLine = "";
        BufferedReader br = null;


        List<Flight> flList = new ArrayList<>();
        try {
            for (String obj : listPath) {

                br = new BufferedReader(new FileReader(obj));

                while ((newLine = br.readLine()) != null) {

                    String[] comp1 = newLine.split(STRING_COMMA);


                    if ((comp1[1].equalsIgnoreCase(depLoc)) && (comp1[2].equalsIgnoreCase(arrLoc))
                            && (comp1[3].equalsIgnoreCase(flightDate))) {
                        flList.add(new Flight(comp1[0], comp1[1], comp1[2], comp1[3], Integer.parseInt(comp1[4]), Float.parseFloat(comp1[5]), Float.parseFloat(comp1[6])));

                    }
                }
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return sortByPreference(flList, choice);

    }

    private List<Flight> sortByPreference(List<Flight> flList, int choice) {

        Comparator<Flight> flightComparator = sorter.get(choice);
        if (flightComparator == null) {
            Collections.sort(flList);
            return flList;
        }
        Collections.sort(flList, flightComparator);
        return flList;


    }


}
