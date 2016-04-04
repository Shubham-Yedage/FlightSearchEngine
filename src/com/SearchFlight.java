package com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchFlight {
    public static final String STRING_COMMA = ",";
    protected ArrayList<String> listPath = new ArrayList<String>();
    protected List<String> finalList = new ArrayList<String>();

    public SearchFlight(String[] path) {

        for (String p : path) {
            listPath.add(p);
        }

    }

    public String toString(String string, String string2, String string3,
                           String string4, String string5, String string6, String string7) {
        return "|" + string + "|" + string2 + "|" + string3 + "|" + string4
                + "|" + string5 + "|" + string6 + "|" + string7 + "|";
    }

    public List<String> getFlights(String depLoc, String arrLoc, String flightDate,
                                   int choice) {

        String newLine = "";
        BufferedReader br = null;
        int flag = 0;
        int selCol = 5;

        if (choice == 1)
            selCol = 6;
        else
            selCol = 5;


        Map<String, String> flList = new HashMap<String, String>();
        try {
            for (String obj : listPath) {

                br = new BufferedReader(new FileReader(obj));

                while ((newLine = br.readLine()) != null) {

                    String[] comp1 = newLine.split(STRING_COMMA);

                    if ((comp1[1].equalsIgnoreCase(depLoc)) && (comp1[2].equalsIgnoreCase(arrLoc))
                            && (comp1[3].equalsIgnoreCase(flightDate))) {
                        String line1 = toString(comp1[0], comp1[1], comp1[2],
                                comp1[3], comp1[4], comp1[5], comp1[6]);
                        flList.put(comp1[selCol], line1);
                        flag = 1;

                    }
                }
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

        if (flag == 1) {
            finalList = sortByPreference(flList, selCol);
            try {
                br.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
            return finalList;

        } else {
            finalList.add("Sorry, We dont have flight for your search!\nTry again!");
            return finalList;
        }
    }

    private List<String> sortByPreference(Map<String, String> flList, int choice) {

        Set<String> keyset = flList.keySet();
        List<Double> DuraList = new ArrayList<Double>();
        List<Long> fareList = new ArrayList<Long>();

        for (Object cnt : keyset) {
            if (choice == 5) {
                Double val = Double.parseDouble(toString(cnt));
                DuraList.add(val);

            } else {
                Long val = Long.parseLong(toString(cnt), 10);
                fareList.add(val);
            }
        }

        if (choice == 5) {
            Collections.sort(DuraList);
            for (Object cnt : DuraList) {
                finalList.add(flList.get(cnt.toString()));

            }
        } else {
            Collections.sort(fareList);
            for (Object cnt : fareList) {
                finalList.add(flList.get(cnt.toString()));

            }
        }
        return finalList;
    }

    private String toString(Object cnt) {

        return "" + cnt;
    }
}
