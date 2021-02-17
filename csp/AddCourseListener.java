

package csp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

import csp.*;


public class AddCourseListener implements ActionListener {

private String instructorname;
private CSPUI cspui;

public AddCourseListener(CSPUI cspui ) {
 this.instructorname = instructorname;
 this.cspui=cspui;
}

public void actionPerformed(ActionEvent e) {
    
       
	    cspui.variables.add(cspui.coursebox.getText());
	    cspui.coursebox.setText("");
	
 }
 
}

