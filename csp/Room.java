package csp;

public class Room{
	private int roomno;
	private String nameOfTeacher;
	private String coursesAssigned[];
	public Room(int roomno){
		this.roomno=roomno;
	}
	
	public int getRoomno(){
		return roomno;
	}
}