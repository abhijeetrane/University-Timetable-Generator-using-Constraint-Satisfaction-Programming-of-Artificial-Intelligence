

package csp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

import csp.*;


public class AddInstructorListener implements ActionListener {


private CSPUI cspui;
public AddInstructorListener(CSPUI cspui ) {

 this.cspui=cspui;
}

public void actionPerformed(ActionEvent e) {
    
       Instructor instructor = new Instructor (cspui.instructorbox.getText());
	    cspui.setInstructor(instructor);
	    cspui.instructorbox.setText("");
	
 }
 
}

