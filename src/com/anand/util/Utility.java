package com.anand.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class Utility {

	private SimpleDateFormat simpleDateFormat;

	public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
		this.simpleDateFormat = simpleDateFormat;
	}

	public String generateSerialNumber() {
		return UUID.randomUUID().toString();
	}

	public String getCurrentDate() throws ParseException {
		return simpleDateFormat.format(new Date());
	}	
}
