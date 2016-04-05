package com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchFlight {
	public static final String STRING_COMMA = ",";
	protected ArrayList<String> listPath = new ArrayList<String>();

	private Map<Integer, Comparator<Flight>> sorter = new HashMap<>();

	public SearchFlight(List<String> path,
			Map<Integer, Comparator<Flight>> extSorter) {

		for (String p : path) {
			listPath.add(p);
		}
		
		sorter.put(2, new FareDurationComparator());
		sorter.putAll(extSorter);

	}

	public List<Flight> getFlights(String depLoc, String arrLoc,
			String flightDate, int choice) {

		String newLine = "";
		BufferedReader br = null;
		List<Flight> flList = new ArrayList<>();

		try {
			for (String obj : listPath) {
				br = new BufferedReader(new FileReader(obj));
				new FlightSearchEngineClient(br.readLine());
				while ((newLine = br.readLine()) != null) {

					String[] readColumn = newLine.split(STRING_COMMA);

					if ((readColumn[1].equalsIgnoreCase(depLoc))
							&& (readColumn[2].equalsIgnoreCase(arrLoc))
							&& (readColumn[3].equalsIgnoreCase(flightDate))) {
						flList.add(new Flight(readColumn[0], readColumn[1],
								readColumn[2], readColumn[3], Integer
										.parseInt(readColumn[4]), Float
										.parseFloat(readColumn[5]), Float
										.parseFloat(readColumn[6])));
					}
				}
				br.close();
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
