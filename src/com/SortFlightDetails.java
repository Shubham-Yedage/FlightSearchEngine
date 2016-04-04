package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SortFlightDetails extends SearchFlight {
		
	protected  List list=new ArrayList();

	SortFlightDetails(){
		super();
	}
	
	protected void sortByPreference(HashMap fl_list,int cnt1) {
		// TODO Auto-generated method stub
		Set keyset=fl_list.keySet();
		
		for(Object cnt:keyset)
		{

			if(cnt1==5)
			{
				Double val=Double.parseDouble(toString(cnt));
				list.add(val);
			}
			else
			{
				Long val=Long.parseLong(toString(cnt),10);
				list.add(val);
			}
		}
		Collections.sort(list);
		
		for(Object cnt:list)
		{
			System.out.println(""+fl_list.get(cnt.toString()));
		}
	}

	private String toString(Object cnt) {
		// TODO Auto-generated method stub
		return ""+cnt;
	}

}
