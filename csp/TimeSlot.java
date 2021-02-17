package csp;

public class TimeSlot{
	private String day;
	private String time;
	private int slotno;

public TimeSlot(int slotno){
	this.slotno=slotno;
}
public TimeSlot(String day,String time,int slotno){
	this.day=day;
	this.time=time;
	this.slotno = slotno;
	
}
public int getSlotno(){
	return slotno;
}
public TimeSlot getCopy(){
	String localday = new String(day);
	String localtime = new String(time);
	int localslotno = slotno;
	TimeSlot localtimeslot = new TimeSlot(localday,localtime,localslotno);
	return localtimeslot;
	 
}
}