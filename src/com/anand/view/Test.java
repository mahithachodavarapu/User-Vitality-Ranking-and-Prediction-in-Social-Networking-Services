package com.anand.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
public static void main(String[] args) {
	String sd="2017-07-03 00:00:00.0";

	try {
		Date date1 = new SimpleDateFormat("dd-MMM-yyyy").parse(sd.substring(0,11).trim());
		
		 System.out.println(sd+"\t"+date1);  
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	   
}
}
