package csp;

import java.util.*;
import java.lang.reflect.*;

public class ArcConsistency{
	private ConstraintSatisfactionCheck csp;
	int testcount;
  public ArcConsistency(ConstraintSatisfactionCheck csp){
  this.csp=csp;
}
public ConstraintSatisfactionCheck acCheck(){
     Hashtable neighbors =((CourseConstraint)csp.getConstraints()).getNeighbors();

     TupleQueue qu = new TupleQueue();
     
     List<String> variables=csp.getVariables();
     
     for(int i=0;i<variables.size();i++){
    	 List<String>neighborsList =(List <String>)neighbors.get(variables.get(i));
    	 
    	 for(int j=0;j<neighborsList.size();j++){
        	 
    		 List <String> tuple = new ArrayList<String>();  
    		 tuple.add(variables.get(i));
    		 
        	 tuple.add(neighborsList.get(j));
        	
        	 qu.addToBack(tuple);   
         }
    	 
    	 	 
     }
     
     for(int k=0;k <qu.size();k++){
    	  List <String> templist = qu.get(k);
              	  if(remove_inconsistent_values(templist.get(0),templist.get(1))){
              		  
              		 List<String>neighborsList =(List <String>)neighbors.get(variables.get(0));
              		for( int j=0;j<neighborsList.size();j++){
                   	if(!((neighborsList.get(j)).equals(templist.get(1)))){ 
               		 List <String> tuple = new ArrayList<String>();  
               		             		 
                   	 tuple.add(neighborsList.get(j));
                   	 tuple.add(templist.get(0));
                   	 qu.addToBack(tuple);   
                   	}
                   	}
              	  }
              		  
          
      
     }
    
     
     return csp;
     

}
public boolean remove_inconsistent_values(String xi,String yi){
	boolean removed=false;
	
    List<Object> domain_xi=csp.getDomain().getDomainOf(xi);
    List<Object> domain_yi=csp.getDomain().getDomainOf(yi);  
    
    for(int z=0;z<domain_xi.size();z++){
        	  for(int m=0; m <domain_yi.size();m++){
        		  if (domain_xi.get(z).equals(domain_yi.get(m)) && domain_yi.size()==1){
        			  csp.getDomain().removeFromDomain(xi,domain_xi.get(z));
        			  removed=true;
        			  
        		  }
        			  
        		  
        	  }
         }

  return removed;
}

public ConstraintSatisfactionCheck fcCheck(String variable,Object value){
	
	Hashtable neighbors =((CourseConstraint)csp.getConstraints()).getNeighbors();
	Hashtable newmap = new Hashtable();
	List<Object> fclist= new ArrayList(); 
	List<String>neighborsList =(List <String>)neighbors.get(variable);
	
	
	for(int i=0; i<neighborsList.size();i++){
	String neighbor=neighborsList.get(i);
	List<Object> domainOfneighbor=csp.getDomain().getDomainOf(neighborsList.get(i));
	 for(int j=0;j<domainOfneighbor.size();j++){
		 if(domainOfneighbor.get(j).equals(value)){
			 testcount++;
			 
			 this.csp.getDomain().removeFromDomain(neighbor,value);
		 }
		
		 
		 
	 }
	 

	}
	return csp;
	}

}