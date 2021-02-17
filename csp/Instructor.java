package csp;
import java.util.*;
public class Instructor{
	private String nameOfTeacher;
	private Vector<String>  eligibleToTeach= new Vector();
	private Vector<String>   assignedtoTeachCourse= new Vector();
	private Vector<Integer>  assignToTeachTimeSlot = new Vector();
	
	public Instructor(String nameOfTeacher){
		this.nameOfTeacher= nameOfTeacher;
		
	}
	public Instructor(String nameOfTeacher,Vector eligibleToTeach){
		this.nameOfTeacher= nameOfTeacher;
		this.eligibleToTeach=eligibleToTeach;
	}
	
	public Vector<String> getEligibleToTeach(){
		return eligibleToTeach;
	}
	
	public int getAssignedsize(){
		return assignedtoTeachCourse.size();
	}
	public void setAssignCourse(String variable){
		assignedtoTeachCourse.add(variable);
		
	}
	public void setEligibleCourse(String variable){
		eligibleToTeach.add(variable);
		
	}
	
	public void removeAssignCourse(String variable){
		assignedtoTeachCourse.remove(variable);
	}
	public void setAssignToTeachTimeSlot(int timeslot){
		Integer TimeSlot = new Integer(timeslot);
		assignToTeachTimeSlot.add(TimeSlot);
		
	}
	
	public void removeAssigntoTeachTimeSlot(int timeslot){
		Integer TimeSlot = new Integer(timeslot);
		assignToTeachTimeSlot.remove(TimeSlot);
	}
	
	public boolean isConsecutiveTimeSlot(int timeslot){
		if(assignToTeachTimeSlot.size()<2)
		      return false;
		else{
			if((assignToTeachTimeSlot.get(1) == timeslot+1) &&(assignToTeachTimeSlot.get(0) == timeslot+2))
				return true;
			if((assignToTeachTimeSlot.get(1) == timeslot+2) &&(assignToTeachTimeSlot.get(0) == timeslot+1))
				return true;
			if((assignToTeachTimeSlot.get(1) == timeslot-1) && (assignToTeachTimeSlot.get(0) == timeslot-2)) 	
		         return true;
			if((assignToTeachTimeSlot.get(1) == timeslot-2) && (assignToTeachTimeSlot.get(0) == timeslot-1)) 	
		         return true;
			if((assignToTeachTimeSlot.get(1) == timeslot+1) &&(assignToTeachTimeSlot.get(0) == timeslot-1))
				return true;
			if((assignToTeachTimeSlot.get(1) == timeslot-1) &&(assignToTeachTimeSlot.get(0) == timeslot+1))
				return true; 	
		}
		return false;  
	}
	public String getName(){
		return nameOfTeacher;
	}
	
	
}