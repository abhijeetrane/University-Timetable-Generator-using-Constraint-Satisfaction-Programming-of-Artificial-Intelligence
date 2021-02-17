
package csp;
import java.util.Random;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;


public class Selection {
	Hashtable<String,Object> finalallotment;
	List<String> variables;
	ConstraintSatisfactionCheck csp;
	public Selection() {
		this(new ArrayList<String>());
  
	}

	public Selection(List<String> variables) {
		finalallotment = new Hashtable<String,Object> ();
		this.variables = variables;
	}

	

	private boolean isVariableFilled() {

		Iterator iter = variables.iterator();
		while (iter.hasNext()) {
			String variable = (String) iter.next();
			if (!finalallotment.keySet().contains(variable)) {
				return false;
			} else {
				if (finalallotment.get(variable) == null) {
					return false;
				}
			}
		}
		return true;
	}

	public void remove(String variable) {
		if (finalallotment.keySet().contains(variable)) {
			finalallotment.remove(variable);
		}
	}
	
	public String variableSelection(ConstraintSatisfactionCheck csp) {
		Iterator iter = variables.iterator();
		List<String > mrvlist= new ArrayList();	
		while (iter.hasNext()) {
			String variable = (String) iter.next();
		if (!(finalallotment.keySet().contains(variable))) {
			   
		       mrvlist.add(variable);
		      
			}
		}
		
		
		
		if(mrvlist.size()>1){
			
			List<String> mcvlist =minimumRemainingValues(mrvlist,csp);//Gets the minimum remaining value variables
			List<String>finallist =most_constraining_variable(mcvlist ,csp);//Gets the most constraining varaibles.
		
		//Selects a variable at random
		Random randomgenerator = new Random();
		int randomvalue = randomgenerator.nextInt(mcvlist.size());
					return finallist.get(randomvalue);
		}else{
			
			return mrvlist.get(0);
			}
        
	 
	}
	  public List<String> minimumRemainingValues(List<String> mrvlist,ConstraintSatisfactionCheck csp){
	  
	  String min=mrvlist.get(0);
	  int minsize=csp.getDomain().getSizeofDomain(mrvlist.get(0));
	  
	 
	  List<String> testlist = new ArrayList();
	  for(int h=0;h<mrvlist.size();h++){
		  String variable = mrvlist.get(h);
		  
		  
	        int size= csp.getDomain().getSizeofDomain(variable);
		    if (size > minsize){
		    	//Ignore the variable since its MRV value is more than minimum value we have.
		    	
		  }  else {
			  if(size < minsize){
			  	     
		     //clear the previous arraylist and add the new variable to the arraylist
		     minsize=size;
		     testlist.clear();
		     testlist.add(variable);
		     
		  }else//add this variable to arraylist
			  testlist.add(variable);
	     }
	  }//end of for loop
	
	
    return testlist;
  }
  public List<String> most_constraining_variable(List<String> mcvlist,ConstraintSatisfactionCheck csp){
	  Hashtable neighbors=((CourseConstraint)csp.getConstraints()).getNeighbors();
        int maxconstraint =((List<String>)neighbors.get(mcvlist.get(0))).size();
      
        List<String> templist= new ArrayList();
       
       
        String max=mcvlist.get(0);
           
        for(int h=0;h<mcvlist.size();h++){
        	String variable = mcvlist.get(h);
            	   int noconstraint= ((List<String>)neighbors.get(variable)).size();
        	    
        	   
        	   if (noconstraint < maxconstraint){
//        		 Ignore the variable since its MCV value is more than maximum size we have
     		        
     		     
     		    }else{ if(noconstraint > maxconstraint){
//     		    	clear the previous arraylist and add the new variable to the arraylist    	
     			     
     			     maxconstraint=noconstraint;
     		         templist.clear();
     			     templist.add(variable);      
     		    }else//add this variable to arraylist 
     		    	templist.add(variable);
  	           }
        }//End of For loop  
        
	return templist;  
  }
 
  
  
	public boolean isAlloted(String variable) {
		return finalallotment.keySet().contains(variable);
	}

	public String toString() {

		return finalallotment.toString();
	}

	public List<String> getVariables() {
		return variables;
	}
	
	public Hashtable<String,Object> getAllotment(){
		return finalallotment;
	}
    public void setSelection(String variable, Object value) {
		
		finalallotment.put(variable, value);
	}

	public Object getSelection(String variable) {
		return finalallotment.get(variable);
	}

	public boolean isComplete() {

		return isVariableFilled();
	}
	
}