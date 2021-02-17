
package csp;

import java.awt.event.*;
import javax.swing.JOptionPane;



public class ExitActionListener implements ActionListener {

public void actionPerformed(ActionEvent e) {
	int value = JOptionPane.showConfirmDialog(null, "Are you sure to Exit ?","Exit Dialog", JOptionPane.YES_NO_OPTION);
	   if (value == JOptionPane.YES_OPTION) 
		 System.exit(0);

          }

    }
 
