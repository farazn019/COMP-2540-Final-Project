import java.util.*;


public class Tester {

	public static void main(String[] args) {
		Week w= new Week();
		int choice;
		Scanner sc= new Scanner(System.in);
			while (true) {
	
				System.out.print("Enter the day you wish to edit\n1) Sunday\n2) Monday\n3) Tuesday");
				System.out.print("\n4) Wednesday\n 5)Thursday\n6) Friday\n 7) Saturday \n8)Display Entire week\n)exit");
			choice=onlyGetGoodInput();
				if (choice>=1&&choice <=7) {
					runOp(w.Week[choice+1]);
				}else if (choice ==8) {
					//display week
				}else if (choice ==9) {
					return;
				}else {
					System.out.println("\n Please enter valid integer");
				}
				
	
				}
	}
	public static int onlyGetGoodInput(){
		Scanner in = new Scanner(System.in);
		int getChoice=0;
		Label:
		while(true) {
			try {
				getChoice = Integer.parseInt(in.next());
				break Label;
			} catch (NumberFormatException e) {
				System.out.println("Not an integer");
			}
		}
		return getChoice;
	}
	public static int[] onlyGetGoodInputs(int n){
		Scanner in = new Scanner(System.in);
		int getChoices[]  = new int[n];
		for (int i=0;i<n;i++)
			getChoices[i]=onlyGetGoodInput();
		return getChoices;
	}

	public static Event addEvent(){
		String header;
		String details;
		Timeframe timeblock =null;
		int priority;
		Scanner in = new Scanner(System.in);
		System.out.print("Give header >> ");
		header = in.next();
		System.out.print("\nGive details >> ");
		details = in.next();
		System.out.print("\nGive prio >> ");
		priority = onlyGetGoodInput();

		while(timeblock==null){
			System.out.print("Give starting point in hour minute format >> ");
			int[] startingTime = onlyGetGoodInputs(2);
			int[] endingTime = onlyGetGoodInputs(2);
			timeblock = new Timeframe(new Timeframe.Time(startingTime),new Timeframe.Time(endingTime));
		}
		return new Event(header,details,timeblock,priority);




	}
	public static void runOp(Day day) {
		System.out.println("What would you like to do\n1) add\n2) delete\n3)display\n4) Reschedule\n");
		Scanner sc = new Scanner(System.in);
		int chosenOption;
		while((chosenOption = onlyGetGoodInput())<1||chosenOption>4){
			System.out.println("Choose a number between 1-4");
		}
		switch (chosenOption){
			case 1://Add an event
				Event e= addEvent();
				day.addAt(e, day.inSort(e));
				
				break;
			case 2://Delete an event
				System.out.println("\nEnter name of event you want to delete");
				String name=sc.nextLine();
				day.delete(name);
				break;
			case 3://Display an element- GUI should cover this
				scheduleWindow baseWindow = new scheduleWindow();
				baseWindow.addWindow(900, 900);
				baseWindow.setWindowName("Weekly Schedule");
				baseWindow.addDay();
				break;
			case 4://Reschedule an event
				System.out.println("Enter name of event you want to reschedule\n");
				Event New=day.Search(sc.nextLine());
				if(New==null) {
					System.out.println("You cant reschedule an event that DNE!\n");
					return;
				}
				System.out.println("\n Enter new Event start hour");
				int x=onlyGetGoodInput();
				System.out.println("\n Enter new Event start minute");
				int y=onlyGetGoodInput();
				System.out.println("\n Enter new Event end hour");
				int w=onlyGetGoodInput();
				System.out.println("\n Enter new Event end minute");
				int z=onlyGetGoodInput();
				day.reschedule(New, x, y, w, z);
				break;
		}

	}
}
