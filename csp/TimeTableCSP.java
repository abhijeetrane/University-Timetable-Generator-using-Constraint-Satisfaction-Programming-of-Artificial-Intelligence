package csp;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.*;


public class TimeTableCSP extends ConstraintSatisfactionCheck {
	
	private TimeTableCSP(List<String> variables, Constraint constraints) {
		super(variables, constraints);
		
		
	}

	public static ConstraintSatisfactionCheck getMap(List<String> variables,List<Instructor>instructors,List<Room> rooms,List<TimeSlot>TimeSlots) {
		
		/*
		 * 
		 * Adds domains to the variables
		 */
		 
	
		 
		 
	Domain domains = new Domain(variables);
	
	for(int i=0;i<variables.size();i++){
		Vector<CourseDomain> preparedomain = new Vector<CourseDomain>();
		 
		 int domainsize = TimeSlots.size()*rooms.size();
		
		 for(int p=0;p<domainsize/TimeSlots.size();p++){
			 for(int h=0;h<TimeSlots.size();h++){
				 CourseDomain coursedomain = new CourseDomain();
				 coursedomain.setTime(TimeSlots.get(h));
				 coursedomain.setRoom(rooms.get(p));
			     preparedomain.add(coursedomain);
			 }
	
		 }
		
			String variable = (String) variables.get(i);
			Vector<Instructor> instructorsqualified = new Vector();	
			
			for(int j=0;j< instructors.size();j++){
				
				
			Vector instructorEligibleTeach =instructors.get(j).getEligibleToTeach();
			
			
			   if(instructorEligibleTeach.contains(variable)){	
			       
					
				   
				    instructorsqualified.add(instructors.get(j)); 
			    }//end of if statement
			
			
			
			}//end of instructors for loop
			
			for(int hope=0;hope< instructorsqualified.size();hope++){
				
			}
			
			int finaldomainsize = domainsize*instructorsqualified.size();
			
			
			Vector<CourseDomain> finaldomain = new Vector<CourseDomain>();
			for(int p=0;p<finaldomainsize/domainsize;p++){
				 for(int h=0;h<domainsize;h++){
					 CourseDomain coursedomainlast = preparedomain.get(h).getCopy();					 
					
					 coursedomainlast.setInstructor(instructorsqualified.get(p));
				     finaldomain.add(coursedomainlast);
				 }
			
			}
			
			domains.addToDomain(variable, finaldomain);
	    	
		}
	
	 
	 
	 
	 /*
		 * Adds neighbours to the hashtable
		 */
		Hashtable<String,List<String>> neighbors = new Hashtable<String,List<String>>();
		
		
		
        List<String>variablecopy = new ArrayList<String>();
		
		for(int m=0;m<variables.size();m++){
			
			variablecopy.clear();
			for(int k=0;k< variables.size();k++){
				if(k==m){}
				else
					addToNeighbors(neighbors, variables.get(m),variables.get(k));
			}
			
		    
		}
		
		
		Constraint mapConstraints = new CourseConstraint(neighbors);

		return new ConstraintSatisfactionCheck(variables, mapConstraints, domains);
	}

	
	public static void addToNeighbors(Hashtable<String,List<String>> neighbors, String whose,
			String one) {
		if(neighbors.get(whose)==null){
		List<String> l = new ArrayList<String>();
		l.add(one);
		neighbors.put(whose, l);
		}else{
			List<String> l=neighbors.get(whose);
			l.add(one);
			neighbors.put(whose, l);
		}
			
	}
	
}