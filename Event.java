

public class Event {
String name;
int prio;
int hour;
int minute;
Event next;

public Event (String name, int prio,int hour, int minute) {
	this.name=name;
	this.prio=prio;
	this.hour = hour;
	this.minute=minute;
}

}