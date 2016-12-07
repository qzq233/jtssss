package team.acc;

import team.pro.*;
import team.jr.*;

public class Teacher extends Account {
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
