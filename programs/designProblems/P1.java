import java.util.Map;
import java.util.HashMap;

class Customer{
	String name;
	String carSize;
	String ticket;

	Customer(String name, String carSize){
		this.name = name;
		this.carSize = carSize;
	}

	public String getTicket(){
		ticket = ParkingSpot.generateTicket(name,carSize);
		return ticket;
	}

	public void removeTicket(){
		ParkingSpot.removeTicket(ticket);
	}
}

class ParkingSpot{
	static Map<String,String> small = new HashMap<String,String>();
	static Map<String,String> medium = new HashMap<String,String>();
	static Map<String,String> large = new HashMap<String,String>();

	static int smallCount = 0;
	static int mediumCount = 0;
	static int largeCount = 0;

	static int maxSmall = 2;
	static int maxMedium = 2;
	static int maxLarge = 2;

	public static String generateTicket(String customerName, String carSize){
		String ticket = "";
		if(carSize.equals("small")){
			if(smallCount < maxSmall){
				small.put(customerName,"booked");
				smallCount++;
				ticket = customerName+"=>"+"booked small";
			}
			else if(mediumCount < maxMedium){
				medium.put(customerName,"booked");
				mediumCount++;
				ticket = customerName+"=>"+"booked medium";
			}
			else if(largeCount < maxLarge){
				large.put(customerName,"booked");
				largeCount++;
				ticket = customerName+"=>"+"booked large";
			}
			else{
				ticket = customerName+"=>"+"Not Available";
			}
		}
		else if(carSize.equals("medium")){
			if(mediumCount < maxMedium){
				medium.put(customerName,"booked");
				mediumCount++;
				ticket = customerName+"=>"+"booked medium";
			}
			else if(largeCount < maxLarge){
				large.put(customerName,"booked");
				largeCount++;
				ticket = customerName+"=>"+"booked large";
			}
			else{
				ticket = customerName+"=>"+"Not Available";
			}
		}
		else{
			if(largeCount < maxLarge){
				large.put(customerName,"booked");
				largeCount++;
				ticket = customerName+"=>"+"booked large";
			}
			else{
				ticket = customerName+"=>"+"Not Available";
			}
		}
		return ticket;
	}

	public static void removeTicket(String ticket){
		String customerName = ticket.split("=>")[0];
		String carSize = ticket.split("=>")[1];
		if(carSize.equals("small")){
			smallCount--;
			small.remove(customerName);
		}
		else if(carSize.equals("medium")){
			mediumCount--;
			medium.remove(customerName);
		}
		else{
			largeCount--;
			large.remove(customerName);
		}
	}
}

class P1{
	public static void main(String args[]){
		Customer c1 = new Customer("avishek","medium");
		System.out.println(c1.getTicket());

		Customer c2 = new Customer("sandhya","medium");
		System.out.println(c2.getTicket());		

		Customer c3 = new Customer("bidhya","medium");
		System.out.println(c3.getTicket());

		Customer c4 = new Customer("amar","medium");
		System.out.println(c4.getTicket());

		c4.removeTicket();

		Customer c5 = new Customer("Kiran","medium");
		System.out.println(c5.getTicket());

	}
}

/*

We create two classes as shown above
Customer and ParkingSpot

ParkingSpot will contain all the information if the parking areas.
Whereas customer will contain all the information of customer

They are connected to one another with the help of ticket.

*/