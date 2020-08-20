
public class Day {
String Day;
public Event head;
public int length;
public Event tail;

public Day(String name) {
	Day= name;
}
	public int inSort(Event e) {
	 
	//we set the key at the element to be added
	//Checks each event with the event that needs to be added
	//Compares its time with the others and picks where to be added to
	int i=1;
	while(head!=null) {
		if (head.hour<e.hour||(head.hour==e.hour&&head.minute<e.minute)){
			i++;
			continue;
		}
		else{
			return i;
	
		}
	}
	return i;
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
         
        
       } 	else { 
    	   //new node point to current head and reset head 
    	   e.next=head;
    	   head=e;
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
}
