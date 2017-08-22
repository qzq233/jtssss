package databaseqzq;

public class JudgeResult {
	String runResult;
	double runtime;
	double memory;
	int grade;
	String  submitTime;
	int solutionID;
	int problemID;
	int userID;
	
	
	public JudgeResult(int solutionID,
		int userID,
		int problemID,
		String runResult,
		double runtime,
		double memory,
		int grade,
		String submitTime){
		this.runResult = runResult;
		this.runtime = runtime;
		this.memory = memory;
		this.grade = grade;
		this.submitTime = submitTime;
		this.solutionID = solutionID;
		this.problemID = problemID;
		this.userID = userID;
	}
	public int getSolutionID(){
		return solutionID;
	}
	public void setSolutionID(int solutionID){
		this.solutionID = solutionID;
	}
	public int getUserID(){
		return userID;
	}
	public void setUserID(int userID){
		this.userID = userID;
	}
	public int getProblemID(){
		return problemID;
	}
	public void setProblemID(int problemID){
		this.problemID = problemID;
	}
	public String getRunResult(){
		return runResult;
	}
	public void setRunResult(String runResult){
		this.runResult = runResult;
	}
	public double getRunTime(){
		return runtime;
	}
	public void setRunTime(double runtime){
		this.runtime = runtime;
	}
	public double getMemory(){
		return memory;
	}
	public void setMemory(double memory){
		this.memory = memory;
	}
	public int getGrade(){
		return grade;
	}
	public void setGrade(int grade){
		this.grade = grade;
	}
	public String getSubmitTime(){
		return submitTime;
	}
	public void setSubmitTime(String submitTime){
		this.submitTime = submitTime;
	}
}
