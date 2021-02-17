

package csp;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import csp.*;



public class DoneActionListener implements ActionListener {

private String instructorname;
private CSPUI cspui;
private JTextArea output;
private JScrollPane jsp;

public DoneActionListener(CSPUI cspui ) {
	 
 this.cspui=cspui;
}

public void actionPerformed(ActionEvent e) {
  
     
	   String Message1="Number of Instructor:  "+cspui.instructors.size()+"\n";
	   
	   String Message2="Room Number: "+ cspui.rooms.size()+"\n";
	   String Message3="Number of Time Slots: "+ cspui.TimeSlots.size()+"\n";
	   
	   String Message6=null;
	 
	   
	  
	   
	   
	   ConstraintSatisfactionCheck csp = TimeTableCSP.getMap(cspui.variables,cspui.instructors,cspui.rooms,cspui.TimeSlots);
		ArcConsistency ac = new ArcConsistency(csp);
		
		//System.out.println("TimeTable Scheduling - Backtracking ");
		
		
		Iterator iter = csp.getVariables().iterator();
		
		String Message7="";
		
		Hashtable<String,Object> hash=null;
			try{
		 hash = csp.backTrack().getAllotment();
				
			
		while (iter.hasNext()) {
			String variable = (String) iter.next();
			CourseDomain cd = (CourseDomain)hash.get(variable);
			Message7+=variable+"\n";
			Message7+="Instructor "+cd.getInstructor().getName()+" Room no"+ cd.getRoom().getRoomno()+" Time Slot "+cd.getTime().getSlotno()+"\n";
		   
		}
			}catch(Exception e1){
				//System.out.println(" no solution");
				

			}
		
			if(hash==null)
			{
				String Message8="\n No Solution Found ";
				String outputmessage =Message1+Message2+Message3+Message8;
				   OutputDialog cs = new OutputDialog(cspui,outputmessage);
				   cs.setTitle("Final Allotment");
				   cs.setSize(300,300);
				   cs.setVisible(true);

			}else{
			String outputmessage =Message1+Message2+Message3+Message7;
			   OutputDialog cs = new OutputDialog(cspui,outputmessage);
			   cs.setTitle("Final Allotment");
			   cs.setSize(300,300);
			   cs.setVisible(true);
			}

}






}
 


