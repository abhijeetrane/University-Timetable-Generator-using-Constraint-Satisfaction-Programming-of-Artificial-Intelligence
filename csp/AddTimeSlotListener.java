

package csp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

import csp.*;


public class AddTimeSlotListener implements ActionListener {


private CSPUI cspui;

public AddTimeSlotListener(CSPUI cspui ) {

 this.cspui=cspui;
}

public void actionPerformed(ActionEvent e) {
    try{
    	
	    Integer timeint = new Integer(cspui.timeslotbox.getText());
         TimeSlot time = new TimeSlot(timeint.intValue());
	    cspui.setTimeSlot(time);
	    cspui.timeslotbox.setText("");
    }catch(NumberFormatException exp){
    	System.out.println("Invalid format");
    }
 }
 
}

