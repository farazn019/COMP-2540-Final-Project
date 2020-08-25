import java.io.*;
import java.util.*;

public class Day {
	String day;
	public Event head;
	public int length;
	public Event tail;

	public Day(String name) {
		day= name;
		head = null;
		tail = null;
	}

	public Event getHead() {
		return head;
	}
	public Event Search(String event){
		Event tempEvent = head;
		int position =0;
		while (tempEvent!=null) {
			if (tempEvent.header.equals(event)) {
				
				return tempEvent;
			}
			if (tempEvent.next == null) {
				System.out.print("That product DNE\n");
				return tempEvent;
			}
			tempEvent=tempEvent.next;
			position++;
		}
		return tempEvent;
	}

	public void setHead(Event head) {
		this.head = head;
	}

	public Event getTail() {
		return tail;
	}

	public void setTail(Event tail) {
		this.tail = tail;
	}

	public int inSort(Event e) {
		//we set the key at the element to be added
		//Checks each event with the event that needs to be added
		//Compares its time with the others and picks where to be added to
		Event temp=head;
		int i=1;
		while(temp!=null) {
			if (e.time.compareTo(head.time)==1){
				i++;
				temp=temp.next;
				continue;
			}
			else{
				return i;
			}
		}
			return i;
	}
public void reschedule(Event e, int starth,int startm,int endh, int endm) {
	Event temp=e;
	this.delete(e.header);
	e.time =  new Timeframe(new Timeframe.Time(starth,startm),new Timeframe.Time(endh,endm));
	this.addAt(e, this.inSort(e));
}


	public void addAt(Event e,int pos) {
		Event prev=head;
		int count=1;
		if(pos==1) {
			//if they enter position 1 call method
			insertFirst(e);
			return;
		}
		if(pos==length+1) {//add at end
			insertEnd(e);
			return;
		}
		while(count<pos-1)
		{
			//walker node to get to desired spot
			prev=prev.next;
			count++;
		}
		//put our node in between desired nodes
		e.next=prev.next;
		prev.next=e;
		length++;
	}

	public void insertFirst(Event e){
		if (head == null) {
			//if list is empty set head and tail to set node
			head = e;
			tail=e;

		} 	else {
			//new node point to current head and reset head
			e.next=head;
			head=e;
			tail=e.next;
		}
		length++;
	}
	public void insertEnd(Event e) {
		//add node to end of list
		if (head == null) {
			head = e;
		} else {
			tail.next = e;
		}
		tail = e;
		length++;
	}


	public void delete(String event){
		Event tempEvent = head;
		int position =0;
		while (tempEvent!=null) {
			if (tempEvent.header.equals(event)) {
				deleteAt(position);
				return;
			}
			if (tempEvent.next == null) {
				System.out.print("That product DNE\n");
				return;
			}
			tempEvent=tempEvent.next;
			position++;
		}
	}

	public void deleteFirst() {

		if(length==0)
			return;

		if(length==1){
			setHead(null);
			setTail(null);
			length--;
			return;
		}
		setHead(head.next);
		length--;
//		head.setPrevious(null);
	}
	public void deleteEnd() {
	
		if(length==0)
			return;
		if(length==1){
			setHead(null);
			setTail(null);
			length--;
			return;
		}
		setTail(tail.getPrevious());
		tail.next=null;
	}

	public int size() {
		Event temp = head;
		int len = 0;
		while (temp != null) {
			len ++;
			temp = temp.next;
		}
		return len;
	}

	public void deleteAt(int position){
		//Empty linked list case
		if(size()==0){
			System.out.println("Nothing to delete");
			return;
		}
		//Deleting the head
		if(position==0){
			deleteFirst();
			return;
		}
		//Deleting the tail
		if(position>=size()-1){
			deleteEnd();
			return;
		}

		//Middle deletion case
		//Have a loop seek to the adequate position
		Event current = head;
		for(int i=0;i<position;i++){
			current= current.next;
		}
		//Then make sure that no nodes point to the node that is 'deleted'
		//GC should take of the rest
		current.next.setPrevious(current.getPrevious());
		current.getPrevious().next= current.next;
	}

	public void printDayAsText() throws FileNotFoundException{
		String day = this.day+"_"+this.hashCode();
		PrintWriter out = new PrintWriter(day);
		Event tempEvent = head;
		while(tempEvent!=null){
			out.println(tempEvent);
		}
		out.close();
	}

	//Note: need to fix the insort part because using bad constructor
	public static Day getDayFromText(String fileName) throws FileNotFoundException{
		Scanner day = new Scanner(new File(fileName));
		String dayName = fileName.split(" ")[0];
		Day newDay = new Day(dayName);
		day.useDelimiter("\n");
		while(day.hasNext()){
			String event = day.next();
			String[] eventAs = event.split("\"");
			String header = eventAs[0];
			String details = eventAs[1];
			String time = eventAs[2];
			newDay.inSort(new Event(header,Timeframe.toTimeframe(time),10));
		}
		return newDay;
	}
}
