

package csp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

import csp.*;


public class AddEligibleListener implements ActionListener {

private CoursesDialog cs;
private CSPUI cspui;
private Instructor is;

public AddEligibleListener(Instructor is,CoursesDialog cs,CSPUI cspui ) {
 
 this.cspui=cspui;
 this.cs=cs;
 this.is=is;
}

public void actionPerformed(ActionEvent e) {
	is.setEligibleCourse(cs.coursename.getText());
	
	cs.coursename.setText("");
 }
 
}

