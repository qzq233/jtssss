package database;

public class ProblemAbstract {
	private String proName;
	private int proID;
	private int courseID;
	private String startTime;
	private String endTime;
	
	public ProblemAbstract(int proID,
    String proName,
	int courseID,
	String startTime,
	String endTime){
		this.proName = proName;
		this.proID = proID;
		this.courseID = courseID;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public int getProID() {
		return proID;
	}

	public void setProID(int proID) {
		this.proID = proID;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
