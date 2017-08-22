package team.acc;

import team.pro.*;
import team.jr.*;

public class Teacher extends Account {
	public Teacher(int id, String username, String password, Level level, State state) {
		super(id, username, password, level, state);
		// TODO Auto-generated constructor stub
	}

	private String course[];
	private int courseID[];
	
	public String[] getCourse() {
		return course;
	}
	public void setCourse(String[] course) {
		this.course = course;
	}
	public int[] getCourseID() {
		return courseID;
	}
	public void setCourseID(int[] courseID) {
		this.courseID = courseID;
	}
	
	public ProblemAbstract searchAssignedProblem(){
		//TODO
		return null;
	}
	
	public JudgeResult showAllSolution(int proID){
		return null;
	}
	
}
