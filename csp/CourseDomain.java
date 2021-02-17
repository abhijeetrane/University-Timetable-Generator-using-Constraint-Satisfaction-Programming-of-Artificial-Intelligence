package csp;
import java.util.*;
public class CourseDomain{
	
	private TimeSlot time;
	private Instructor instructor;
	private Room room;
	public CourseDomain(){
	
	}
	
	public TimeSlot getTime(){
		return time;
		}
	public Instructor getInstructor(){
		return this.instructor;
		}
	public Room getRoom(){
		return room;
		}
   public void setInstructor(Instructor instructor){
	   this.instructor = instructor;
   }
	public void setTime(TimeSlot timeslot){
		this.time=timeslot;
	}
    public void setRoom(Room room){
    	this.room=room;
    }
    public CourseDomain getCopy(){
    	CourseDomain localcopy = new CourseDomain();
    	localcopy.time=this.time;
    	localcopy.room=this.room;
    
    	return localcopy;
    
    }

}