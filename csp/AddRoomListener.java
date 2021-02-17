

package csp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

import csp.*;


public class AddRoomListener implements ActionListener {


private CSPUI cspui;

public AddRoomListener(CSPUI cspui ) {

 this.cspui=cspui;
}

public void actionPerformed(ActionEvent e) {
    try{
    	Integer timeint = new Integer(cspui.roombox.getText());
       
    	Room room = new Room(timeint.intValue());
	   
         cspui.setRooms(room);
	   
	    cspui.roombox.setText("");
    }catch(Exception exp){
       	System.out.println("Invalid format");
    
    }
 }
 
}

