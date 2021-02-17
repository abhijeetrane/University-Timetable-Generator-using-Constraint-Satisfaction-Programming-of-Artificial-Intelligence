package csp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JDialog;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import csp.*;


public class OutputDialog extends JDialog {
	JTextArea output = new JTextArea();
	JScrollPane jsp;
	

	public OutputDialog(CSPUI cspui,String outputmessage){
		super(cspui);
		
	
		output.setText(outputmessage);
		jsp = new JScrollPane(output);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		setContentPane(jsp);
		this.setSize(400,400);
		
	}

	
}
