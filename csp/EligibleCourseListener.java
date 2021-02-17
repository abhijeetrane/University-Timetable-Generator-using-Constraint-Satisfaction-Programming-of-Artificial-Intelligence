

package csp;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import csp.*;



public class EligibleCourseListener implements ActionListener {

private String instructorname;
private CSPUI cspui;




public EligibleCourseListener(CSPUI cspui ) {
   
   this.cspui=cspui;
 }

 public void actionPerformed(ActionEvent e) {
    
       
			
		             
	
	
	
	CoursesDialog cd = new CoursesDialog(cspui.nameCheck(cspui.eligiblebox.getText()),cspui);
	cd.setSize(400,100);
	cd.setTitle("Course Dialog");
	cd.setVisible(true);
 }
 
}

