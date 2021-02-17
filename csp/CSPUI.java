
package csp;
import javax.swing.border.Border;
import javax.swing.*;

import csp.*;

import java.awt.*;
import java.util.*;
import java.util.List;


public class CSPUI extends JFrame {
	public JTextField instructorbox;
	public JButton add;
	
   public JLabel instructorlabel;
    
   	public JTextField roombox;
	public JButton addroom;
	public JLabel roomlabel;
	
	public JTextField timeslotbox;
	public JButton addtimeslot;
	public JLabel timeslotlabel;
	
	public JTextField eligiblebox;
	public JButton eligiblebutton;
	public JLabel eligiblelabel;
	
	public JTextField coursebox;
	public JButton addcourse;

   public JLabel courseslabel;
    
   public JButton done;
   public JButton exit;
public List<Instructor>instructors  = new ArrayList<Instructor>();

public List<String> variables = new ArrayList<String>();

public List<Room> rooms = new ArrayList<Room>();

public List<TimeSlot>TimeSlots = new ArrayList<TimeSlot>();
/**
 * Constructor.
 *
 */
public CSPUI(){
	super("Time-Table Scheduling Problem");
	GriddedPanel topPanel = new GriddedPanel();

	instructorlabel =new JLabel("Instructor Name");
     topPanel.addComponent(instructorlabel,0,0);
      instructorbox =new JTextField(10);
	 topPanel.addComponent(instructorbox,0,1);
	 add=new JButton("  Add Instructors ");
	 topPanel.addComponent(add,0,2);
	 add.addActionListener(new AddInstructorListener(this));
	 
	 roomlabel =new JLabel("Room no");
     topPanel.addComponent(roomlabel,1,0);
      roombox =new JTextField(10);
	 topPanel.addComponent(roombox,1,1);
	 addroom=new JButton("     Add Rooms      ");
	 topPanel.addComponent(addroom,1,2);
	 addroom.addActionListener(new AddRoomListener(this));
	 timeslotlabel =new JLabel("Time Slot");
     topPanel.addComponent(timeslotlabel,2,0);
	 timeslotbox =new JTextField(10);
	 topPanel.addComponent(timeslotbox,2,1);
	 addtimeslot=new JButton("     Add TimeSlots");
	 topPanel.addComponent(addtimeslot,2,2);
	 addtimeslot.addActionListener(new AddTimeSlotListener(this));
	 
	 courseslabel =new JLabel("Course Name");
     topPanel.addComponent(courseslabel,3,0);
      coursebox =new JTextField(10);
	 topPanel.addComponent(coursebox,3,1);
	 addcourse=new JButton("     Add Courses   ");
	 topPanel.addComponent(addcourse,3,2);
	 addcourse.addActionListener(new AddCourseListener(this));
	 
	 eligiblelabel =new JLabel("Add courses to an Instructor");
     topPanel.addComponent(eligiblelabel,4,0);
	 eligiblebox =new JTextField(10);
	 topPanel.addComponent(eligiblebox,4,1);
	 eligiblebutton=new JButton("Add Eligible Course to Instructor  ");
	 topPanel.addComponent(eligiblebutton,4,2);
	 eligiblebutton.addActionListener(new EligibleCourseListener(this));
	 
	 
	 
	 
	 
	 done=new JButton("Done");
	 done.addActionListener(new DoneActionListener(this));
	 topPanel.addComponent(done,9,1);
	 
	 exit=new JButton("Exit");
	 exit.addActionListener(new ExitActionListener());
	 topPanel.addComponent(exit,9,2);
	 
	 
	 
	 JPanel mainPanel = new JPanel();
	 mainPanel.add(topPanel);
//	BorderFactory.createLineBorder(Color.blue,10);
     Border etchedBorder = BorderFactory.createEtchedBorder();
	 Border titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Input Screen");
	 Border emptyBorder  = BorderFactory.createEmptyBorder(10,10,10,10);
	 Border compoundBorder=BorderFactory.createCompoundBorder(titledBorder, emptyBorder);
	 mainPanel.setBorder(compoundBorder);
	 
	 //Add the top panel to the content pane and size it
    getContentPane().add(mainPanel, BorderLayout.CENTER);


    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(600,280);
	this.setBackground(java.awt.Color.GRAY);
	this.setVisible(true);
	}
	
	/** Returns the frame of the UI.
    @return JFrame of the UI.
    */
    public JFrame getFrame() {
       return this;
    }
    
  
   
   
	
	public void setInstructor(Instructor inst){
		instructors.add(inst);
	}
	public void setRooms(Room room){
		rooms.add(room);
	}
	public void setTimeSlot(TimeSlot timeslot){
		TimeSlots.add(timeslot);
	}
   public Instructor nameCheck(String variable){
	   
	   
	   //if(instructors.contains())
	for(int i=0;i<instructors.size();i++){
		
		if((instructors.get(i).getName().compareTo( variable)) == 0)
          	return instructors.get(i);
	
	}
	return null;
	}

   /**
    * It is invoked when the application starts
    * @param args  no arguments.
    */
   public static void main(String[] args) {
	   // Set the look and feel.
	    try {
	      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	    } catch(Exception lfe) {}
       //Put up the GUI
	    CSPUI cspUI = new CSPUI();
       cspUI.setVisible(true);
       
	   
   }
}
