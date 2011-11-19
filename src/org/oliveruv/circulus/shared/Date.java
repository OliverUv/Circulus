package org.oliveruv.circulus.shared;

public class Date {
	
	public int year;
	public int month;
	public int day;
	
	public Date(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String getTimeString() {
		return day + dateSuffix(day) + " " + monthToMonthName(month) + ", " + year;
	}
	
	private String dateSuffix(int date) {
		String suffix = "";
		int lastDigit = date % 10;
		switch(lastDigit) {
			case 1: suffix = "st"; break;
			case 2: suffix = "nd"; break;
			case 3: suffix = "rd"; break;
			default: suffix = "th"; break;
		}
		return suffix;
	}

	private String monthToMonthName(int monthNumber) {
		String name = "";
		switch (monthNumber) {
			case 1:  name = "Januar";       break;
	        case 2:  name = "Februari";      break;
	        case 3:  name = "of March";         break;
	        case 4:  name = "Aprilya";         break;
	        case 5:  name = "of May";           break;
	        case 6:  name = "Jubilee";          break;
	        case 7:  name = "Julye";          break;
	        case 8:  name = "Augastu";        break;
	        case 9:  name = "Septimb";     break;
	        case 10: name = "Octobir";       break;
	        case 11: name = "Cold Novus";      break;
	        case 12: name = "Decymbris";      break;
	        default: name = "What"; 		 break;
		}
		
		return name;
	}
	
}
