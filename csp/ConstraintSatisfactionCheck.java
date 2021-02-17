package csp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

public class ConstraintSatisfactionCheck {


	private Constraint constraints;

	private List<String> variables;

	private Domain domains;
	
	ArcConsistency ac = new ArcConsistency(this);

	public ConstraintSatisfactionCheck(List<String> variables, Constraint constraints) {
		this.variables = variables;
		
		this.domains = new Domain(variables);
		this.constraints = constraints;
	}

	public ConstraintSatisfactionCheck(List<String> variables, Constraint constraints, Domain domains) {
		this.variables = variables;
		
		this.domains = domains;
		this.constraints = constraints;
	}

	

	public List least_constrainting_value(Selection previousSelection,String variable){
		boolean atleastoneneighbor = false;
  
		List<Object> variabledomain=this.domains.getDomainOf(variable); 
		  
		  
		  
		  Vector<Integer> sum = new Vector<Integer>();
		  for(int a=0;a<variabledomain.size();a++){
			  sum.add(new Integer(0));
		  }
		  
		  List variableNeighbors = (List)((CourseConstraint)this.getConstraints()).getNeighbors().get(variable);
			if(variableNeighbors!=null){
		 
				for (int i = 0; i < variableNeighbors.size(); i++) {
				String neighbor = (String) variableNeighbors.get(i);
				
				if (!previousSelection.isAlloted(neighbor)){
					 atleastoneneighbor = true;
				List<Object> neighbordomain=this.domains.getDomainOf(neighbor);
				
				
				for(int k=0;k<variabledomain.size();k++){
					int leftvalues=0 ;
					if(neighbordomain.contains(variabledomain.get(k))){
						leftvalues=neighbordomain.size()-1;
						leftvalues+=sum.get(k).intValue();
					    sum.setElementAt(new Integer(leftvalues),k);
					}else{
						leftvalues=neighbordomain.size();
						leftvalues+=sum.get(k).intValue();
					    sum.setElementAt(new Integer(leftvalues),k);
					}
						
						
						
				}
						
						
			}
				
	}
		  }else{
			  return this.domains.getDomainOf(variable);
		  }
		  if((variableNeighbors.size()==0) ||(!atleastoneneighbor)){
			  
			  return this.domains.getDomainOf(variable);
		  }
			
		  
		  
			if(atleastoneneighbor){
				LCVsupport l[] = new LCVsupport[variabledomain.size()];
				for(int q=0;q<variabledomain.size();q++){
					l[q]= new LCVsupport(variabledomain.get(q),sum.get(q));
				}
				Arrays.sort(l,new Comparator(){
		        	public int compare(Object o1, Object o2)
		            {
		        		int id1=((LCVsupport) o1).sum;
		        		int id2=((LCVsupport) o2).sum;
		        		
		        		if(id1 > id2)
		        			return -1;
		        		else if(id1 <id2)
		        			return 1;
		        		else return (((LCVsupport) o1).sum- ((LCVsupport) o2).sum);
		            }		 
		                
		            
		        });
				List<Object> finaldomainvalues = new ArrayList<Object>(); 
		    	   for(int g=0;g<sum.size();g++){
		    		    finaldomainvalues.add(l[g].value);
		    		 
		    	   }
		    	   
		        return finaldomainvalues;
			}
			
	return this.domains.getDomainOf(variable);
	}
	
	public Selection backTrack() {
		return recursiveBackTracking(new Selection(variables));
	}

	private Selection recursiveBackTracking(Selection previousSelection) {
		
		if (previousSelection.isComplete()) {
			return previousSelection;
		}
		String variable = previousSelection.variableSelection(this);
		
		List setOfDomain =  least_constrainting_value(previousSelection,variable);
		for (int i = 0; i < setOfDomain.size(); i++) {
			Object value = setOfDomain.get(i);
          
			if (constraints.constraintCheck(previousSelection, variable, value)) {
				previousSelection.setSelection(variable, value);
				
				List variableNeighbors = (List) ((CourseConstraint)constraints).getNeighbors().get(variable);
				if(variableNeighbors!=null){
				this.domains=ac.fcCheck(variable,value).getDomain();
				this.domains=ac.acCheck().getDomain();
				
				}
				
				CourseDomain	selecteddvalue=(CourseDomain)setOfDomain.get(i);
				  selecteddvalue.getInstructor().setAssignToTeachTimeSlot(selecteddvalue.getTime().getSlotno());
				   selecteddvalue.getInstructor().setAssignCourse(variable);

				Selection result = recursiveBackTracking(previousSelection);
				if (result != null) {
					return result;
				}

				previousSelection.remove(variable);
				selecteddvalue.getInstructor().removeAssigntoTeachTimeSlot(selecteddvalue.getTime().getSlotno());
			    selecteddvalue.getInstructor().removeAssignCourse(variable);
			}
		}
		return null;
	}
	



	public Constraint getConstraints(){
	  return constraints;
	}
    public List<String> getVariables(){
    	return variables;
    }
   public Domain getDomain(){
	   return domains;
   }



}