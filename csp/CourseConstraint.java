package csp;

import java.util.Hashtable;
import java.util.List;

public class CourseConstraint implements Constraint{
	private Hashtable neighbors;

	CourseConstraint(Hashtable neighbors) {
		this.neighbors = neighbors;
	}

	public boolean constraintCheck(Selection assignment, String variable,
			Object value) {
		
		List variableNeighbors = (List)neighbors.get(variable);
		if(variableNeighbors!=null){
		for (int i = 0; i < variableNeighbors.size(); i++) {
			String neighbor = (String) variableNeighbors.get(i);
			if (assignment.isAlloted(neighbor)) {
				CourseDomain neighborDomain = (CourseDomain) assignment.getSelection(neighbor);
				try{
				CourseDomain coursevalue =(CourseDomain)value;
				
				
				
				if(neighborDomain!=null){
					/*
					 * No teacher can teach two courses in the same time slots.
					 */
   if((coursevalue.getInstructor().getName().compareTo(neighborDomain.getInstructor().getName())==0)&&((coursevalue.getTime().getSlotno()==neighborDomain.getTime().getSlotno()))){
	        
	  return false;
				}	
				
					
		/*No Classrooms can have two different courses assigned to them  in the same time slot 	
			    		    
			    */
		
	
					
		if ((coursevalue.getRoom().getRoomno()==neighborDomain.getRoom().getRoomno()) &&(coursevalue.getTime().getSlotno()==neighborDomain.getTime().getSlotno())) {
				
			return false;
			
				}
				
/*No teacher can be assigned three consecutive slots*/				
	
		if(coursevalue.getInstructor().isConsecutiveTimeSlot(coursevalue.getTime().getSlotno())){
				 
			return false;
  }
		
		/* A teacher can be assigned at the most three courses*/
         if(coursevalue.getInstructor().getAssignedsize()==3){
        	 
	          return false;
         }
				}
				
				
				
				}catch(Exception e){
					System.out.println("Neighbor domain is empty");
				}
				}
		}
		
		
		return true;
		}else{

			
			return true;
		}
	

	}
	public Hashtable getNeighbors(){
		 return neighbors;   
	   }
}