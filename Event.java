import java.util.Scanner;




public class Event {
	String header;
	//String details;

	Timeframe time;
	//Event previous;
	Event next;
	Event previous;
	int priority;

	//The starting hour and ending hour.
	int startingHour, endingHour;


	public Event() {
		int x,y,w,z;
		
		Scanner sc= new Scanner(System.in);
		System.out.println("\n Enter Event name");
		this.header = sc.nextLine();
		
		//this.details = details;
		System.out.println("\n Enter Event start hour");
		x=sc.nextInt();
		this.startingHour = x;
		System.out.println("\n Enter Event start minute");
		y=sc.nextInt();
		System.out.println("\n Enter Event end hour");
		w=sc.nextInt();
		this.endingHour = w;
		System.out.println("\n Enter Event end minute");
		z=sc.nextInt();
		this.time =  new Timeframe(new Timeframe.Time(x,y),new Timeframe.Time(w,z));
		//this.previous = previous;
		this.next = null;
		System.out.println("\n Enter Event priority");
		this.priority = sc.nextInt();
		
		
	}
	public Event(String header, String details, Timeframe time, Event next, int priority) {
		this.header = header;
	//	this.details = details;
		this.time = time;
		//this.previous = previous;
		this.next = next;
		this.priority = priority;
	}
	
	public Event(String header, String details, Timeframe time, int priority) {
		this.header = header;
	//	this.details = details;
		this.time = time;
		this.priority = priority;
	}
	
	public Event getPrevious() {
		return previous;
	}

	public void setPrevious(Event previous) {
		this.previous = previous;
	}
	
		
	
	

}