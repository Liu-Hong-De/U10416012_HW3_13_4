//U10416012 劉宏德

public class PrintCalendar {
		
	//load the calendar class which defined in api
	static Calendar calendar = new calendar();
	
	public static void main(String[] args) {
		
		//define month and year wich calendar
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		
		
		//set the user first input is month, the second is year
		if (args.length == 2) {
			
			year = Integer.parseInt(args[1]);
			month = Integer.parseInt(args[0]);

			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month - 1);
		}
		
		//if the user only input month, print the year now 
		else if (args.length == 1) {
      
			month = Integer.parseInt(args[0]);
			calendar.set(Calendar.MONTH, month-1);
		}
		
		//print the calendar for a month in a year
		printMonth(year, month);
	}
	
	//Print the calendar for a month in a year
	public static void printMonth(int year, int month){
		
		int startDay = getStartDay();
		int numberOfDaysInMonth = calendar.daysInMonth();
		
		//print the headings of the calendar
		printMonthTitle(year, month);
		
		//Print the body of the calendar
		printMonthBody(startDay, numberOfDaysInMonth);
	}
	
	//Print the month title
	public static void printMonthTitle(int year, int month){
		System.out.println("        " + calendar.getMonthName() + "   " + calendar.get(Calendar.YEAR));
		System.out.println("---------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}
	
	//Print month body
	public static void printMonthBody(int startDay, int numberOfDaysInMonth){
		
		//Pad space before the first day of the month
		for(int i = 0; i < (startDay - 1); i++) {
			System.out.print("    ");
		}
		for(int i = 1; i <= numberOfDaysInMonth; i++) {
			System.out.printf("%4d", i);
			
			if((i + startDay - 1) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}
	
	// Get the start day
	static int getStartDay(){
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
}

	
class Calendar extends GregorianCalendar{
	//Get the number of days in a month
	public int daysInMonth(){
		
		int month = get(MONTH) + 1;
		
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;
		}
		
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}
		
		if (month == 2) {
			return isLeapYear(get(YEAR)) ? 29 : 28;
		}	
		
		return 0; 
	}

	//Get the English name for the month
	public String getMonthName() {
		
		String monthName = "";
		
		switch (get(MONTH) + 1) {
			case 1: monthName = "January"; 		break;
			case 2: monthName = "February"; 	break;
			case 3: monthName = "March"; 		break;
			case 4: monthName = "April"; 		break;
			case 5: monthName = "May"; 			break;
			case 6: monthName = "June"; 		break;
			case 7: monthName = "July"; 		break;
			case 8: monthName = "August"; 		break;
			case 9: monthName = "September"; 	break;
			case 10: monthName = "October"; 	break;
			case 11: monthName = "November"; 	break;
			case 12: monthName = "December";
		}
		
		return monthName;
	}
}
