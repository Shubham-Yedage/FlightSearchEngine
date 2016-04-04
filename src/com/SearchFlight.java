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
	protected ArrayList<String> listPath = new ArrayList<String>();

	public SearchFlight(String[] path) {

		for (String p : path) {
			listPath.add(p);
		}

	}

	public String toString(String string, String string2, String string3,
			String string4, String string5, String string6, String string7) {
		// TODO Auto-generated method stub
		return "|" + string + "|" + string2 + "|" + string3 + "|" + string4
				+ "|" + string5 + "|" + string6 + "|" + string7 + "|";
	}

	public void getFlights(String depLoc, String arrLoc, String flightDate,
			int choice) {
		// TODO Auto-generated method stub
		String newLine = "";
		BufferedReader br = null;
		String splitBy = ",";
		int flag=0;

		Map<String, String> flList = new HashMap<String, String>();
		try {
			for (String obj : listPath) {

				br = new BufferedReader(new FileReader(obj));

				while ((newLine = br.readLine()) != null) {

					String[] comp1 = newLine.split(splitBy);

					if ((comp1[1].equalsIgnoreCase(depLoc)) && (comp1[2].equalsIgnoreCase(arrLoc))
							&& (comp1[3].equalsIgnoreCase(flightDate))) {
						String line1 = toString(comp1[0], comp1[1], comp1[2],
								comp1[3], comp1[4], comp1[5], comp1[6]);
						flList.put(comp1[choice], line1);
						flag=1;
						
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (flag == 1) {
			sortByPreference(flList, choice);
			

		} else {
			System.out
			.println("Sorry, We dont have flight for your search!\nTry again!");
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	private void sortByPreference(Map<String, String> flList, int choice) {
		// TODO Auto-generated method stub
		
		Set<String> keyset=flList.keySet();
		List<Double> DuraList=new ArrayList<Double>();
		List<Long> fareList=new ArrayList<Long>();

		for(Object cnt:keyset)
		{
			
			if(choice==5)
			{
				Double val=Double.parseDouble(toString(cnt));
				DuraList.add(val);
				
			}
			else
			{
				Long val=Long.parseLong(toString(cnt),10);
				fareList.add(val);
			}
		}

		if(choice==5)
		{
			Collections.sort(DuraList);
			for(Object cnt:DuraList)
			{
				System.out.println(""+flList.get(cnt.toString()));
			}
		}
		else
		{
			Collections.sort(fareList);
			for(Object cnt:fareList)
			{
				System.out.println(""+flList.get(cnt.toString()));
			}
		}
	}

	private String toString(Object cnt) {
		// TODO Auto-generated method stub
		return ""+cnt;
	}
}
