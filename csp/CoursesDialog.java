package csp;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import csp.*;


public class CoursesDialog extends JDialog implements ActionListener{
	JTextField coursename ;
	JLabel courselabel;
	JButton addcourse;
	JButton donecourse;
	
	public CoursesDialog(Instructor is,CSPUI cspui){
		super(cspui);
		
		JPanel topPanel = new JPanel();
		
        courselabel=new JLabel("Course Name");
        
		
		coursename = new JTextField(10);
		addcourse = new JButton("Add");
		
		donecourse=new JButton("Done");
		
		donecourse.addActionListener(this);
		
		topPanel.add(courselabel);
		topPanel.add(coursename);
		topPanel.add(addcourse);
		topPanel.add(donecourse);
		
		addcourse.addActionListener(new AddEligibleListener(is,this,cspui));
		donecourse.addActionListener(this);
		setContentPane(topPanel);
		
		}

	public void actionPerformed(ActionEvent e) {
           this.setVisible(false);
		

}

	
	
    }

