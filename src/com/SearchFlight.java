package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SearchFlight {
	protected String dep_loc;
	protected String arr_loc;
	protected String flight_date;
	private String fare;
	private int op_prf;
	protected ArrayList<String> list1=new ArrayList<String>();
	protected String line="";
	protected BufferedReader br=null;
	protected String splitby=",";
	private int choice=1;
	private HashMap fl_list=new HashMap();
	protected int flag=0;

	SearchFlight()
	{
		list1.add("/home/synerzip/workspace/FlightSearchEngine/csv_Files/AIR_FRANCE.csv");
		list1.add("/home/synerzip/workspace/FlightSearchEngine/csv_Files/BRITISH_AIRWAYS.csv");
		list1.add("/home/synerzip/workspace/FlightSearchEngine/csv_Files/LUFTHANSA_AIRWAYS.csv");
	}


	protected void scanDetails() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Departure Location:");
		dep_loc=sc.next();
		System.out.println("Enter Arrival Location:");
		arr_loc=sc.next();
		System.out.println("Enter Flight Date:");
		flight_date=sc.next();
		System.out.println("Enter\n 1 To sort According To Fare\n 2 To sort According To Duration");
		choice=sc.nextInt();

		if(choice==1)
			showDetails(6);
		else
			showDetails(5);
	}

	protected void showDetails(int cnt) {
		// TODO Auto-generated method stub

		try {
			for(String obj:list1)
			{

				br=new BufferedReader(new FileReader(obj));

				while((line=br.readLine())!=null)
				{

					String[] comp1=line.split(splitby);

					if((comp1[1].equals(dep_loc))&&(comp1[2].equals(arr_loc))&&(comp1[3].equals(flight_date)))
					{
						flag=1;
						String line1=toString(comp1[0],comp1[1],comp1[2],comp1[3],comp1[4],comp1[5],comp1[6]);
						fl_list.put(comp1[cnt],line1);
					}
					else {
						flag=0;
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

		if (flag==1) {
			SortFlightDetails sfd=new SortFlightDetails();
			sfd.sortByPreference(fl_list,cnt);

		} else {
			System.out.println("Sorry, We dont have flight for your search!\nTry again!");
			scanDetails();
		}
	}


	private String toString(String string, String string2, String string3,
			String string4, String string5, String string6, String string7) {
		// TODO Auto-generated method stub
		return "|"+string+"|"+string2+"|"+string3+"|"+string4+"|"+string5+"|"+string6+"|"+string7+"|";
	}
}