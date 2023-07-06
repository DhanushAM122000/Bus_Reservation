package busrev;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
public class Booking {
	String passengerName;
	int busNo;
	Date date;

	
	
	Booking(){
		Scanner scanne=new Scanner(System.in);
		
		System.out.println("Enter name of passenger");
		 passengerName=scanne.next();
		
		System.out.println("Enter bus no");
		 busNo=scanne.nextInt();
		
		System.out.println("Enter Date dd-mm-yyy");
		String dateInput=scanne.next();
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			date= dateFormat.parse(dateInput);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
	}
	public boolean isAvailable(ArrayList<Booking> bookings,ArrayList<Bus>buses) {
		int capacity=0;
		for(Bus bus:buses) {
			if(bus.getBusno() ==busNo) 
				capacity=bus.getCapacity();
			
		}
		int booked=0;
		for(Booking b:bookings) {
			if(b.busNo == busNo && b.date.equals(date)) {
				booked++;
			}
		}
		return booked<capacity?true:false;
	}
}
