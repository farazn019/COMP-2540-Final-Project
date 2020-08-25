import java.util.*;


public class Tester{

	static Week w;
	static String[][] weeklyScheduleArray;
	static String[] days;
	static int choice;
	static schedule gui = new schedule();


	public static void main(String[] args) {
		//scheduleWindow baseWindow;
		w= new Week();
		Scanner sc= new Scanner(System.in);
		gui.closeOnExit();
    	gui.setSize(1000, 1000); //sets the size of the gui to 1000 by 1000 pixels.

		weeklyScheduleArray = new String[25][7];
		days = new String[7];

		days[0] = "Sunday";
		days[1] = "Monday";
		days[2] = "Tuesday";
		days[3] = "Wednesday";
		days[4] = "Thursday";
		days[5] = "Friday";
		days[6] = "Saturday";

		for(int i = 0; i < 7; i++){
			weeklyScheduleArray[0][i] = days[i];
		}

			while (true) {
	
				System.out.print("Enter the day you wish to edit\n1) Sunday\n2) Monday\n3) Tuesday");
				System.out.print("\n4) Wednesday\n 5)Thursday\n6) Friday\n 7) Saturday \n8)Display Entire week\n)exit");
				choice=onlyGetGoodInput();
				if (choice>=1&&choice <=7) {
					runOp(w.Week[choice-1]);
				}else if (choice ==8) {
					gui.setVisible(true);					
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

	static int startingHour, endingHour;

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
			startingHour = startingTime[0];
			int[] endingTime = onlyGetGoodInputs(2);
			endingHour = endingTime[0];
			timeblock = new Timeframe(new Timeframe.Time(startingTime),new Timeframe.Time(endingTime));
		}
		return new Event(header,details,timeblock,priority);





	}



	public static void runOp(Day day) {
		//Prompts the user to choose between: adding an event, deleting an event, displaying the table, and rescheduling events.
		System.out.println("What would you like to do\n1) add\n2) delete\n3)display\n4) Reschedule\n");
		Scanner sc = new Scanner(System.in);
		int chosenOption;
		while((chosenOption = onlyGetGoodInput())<1||chosenOption>4){
			System.out.println("Choose a number between 1-4");
		}

		switch (chosenOption){
			//The first case adds an event to a specific day of the week.
			case 1://Add an event

				Event e= addEvent();
				day.addAt(e, day.inSort(e));
				weeklyScheduleArray[e.startingHour][choice - 1] = e.header;

				if(gui.scheduleTable.getValueAt(startingHour, choice) == null){
					System.out.println("Starting hour: " + startingHour);
					System.out.println("Ending Hour: " + endingHour);
					for(int i = startingHour; i < endingHour; i++){
						//gui.scheduleTable.setValueAt(e.header, i, choice);		
						gui.addEvent(i, choice, e.header);			
					}
				}

				//breaks from the switch statement.
				break;

			case 2:
				//The second case will delete an event from the linked list of Days, and thus from the GUI.

				//The user is prompted to enter the name of the event that they want to delete.
				System.out.println("\nEnter name of event you want to delete");
				String name=sc.nextLine();

				//The column of the specific day is traversed to search for a name string, and removes it.
				for(int j = 0; j < 24; j++){
					//If the gui at the specified value isn't null and the gui at the schedule table is equivalent to the name string, then it is removed.
					if((gui.scheduleTable.getValueAt(j, choice) != null) && (gui.scheduleTable.getValueAt(j, choice).equals(name))){
						gui.scheduleTable.setValueAt("", j, choice);
					}
				}
				
				//Deletes the day from the Day linked list.
				day.delete(name);
				//breaks from the swirch statement.
				break;
			

			case 3:
				//Displays the GUI to the user, which will allow them to see all the events for the day.
				gui.setVisible(true);
				//breaks from the while loop.
				break;
			case 4:
				//The fourth case will reschedule an event.
				String originalEvent = "";


				System.out.println("Enter name of event you want to reschedule\n");
				originalEvent = sc.nextLine();

				for(int i = 0; i < 24; i++){
					if((gui.scheduleTable.getValueAt(i, choice) != null) && (gui.scheduleTable.getValueAt(i, choice).equals(originalEvent))){
						gui.scheduleTable.setValueAt("", i, choice);
					}
				}


				Event New=day.Search(originalEvent);

				if(New==null) {
					System.out.println("You cant reschedule an event that DNE!\n");
					return;
				}

				//Prompts the user for important information.
				System.out.println("\n Enter new Event start hour");
				int x=onlyGetGoodInput();
				System.out.println("\n Enter new Event start minute");
				int y=onlyGetGoodInput();
				System.out.println("\n Enter new Event end hour");
				int w=onlyGetGoodInput();
				System.out.println("\n Enter new Event end minute");
				int z=onlyGetGoodInput();
				day.reschedule(New, x, y, w, z);


				System.out.println("Please enter the information for the new event: ");

				//The newDay variable will store the new day of the week.
				String newDay = "";
				//The newIntDat will convert the day format to the integer array format.
				int newIntDay = 1;

				//Prompts the user to enter the new day.
				System.out.println("Now, please enter the day that you would like to reschedule this event (make the first letter an uppercase): ");
				newDay = sc.nextLine();

				//This will search for the specific date in the columns of the schedule table.
				for(int i = 1; i  <= 7; i++){
					if(gui.columns[i].equals(newDay)){
						newIntDay = i;
					}
				}

				//This will copy all the previous events to the new event date and corresponding hour span.
				for(int i = x; i < w; i++){
					gui.scheduleTable.setValueAt(originalEvent, i, newIntDay);
				}
				
				//breaks from the switch statement.
				break;
		}

	}
}
