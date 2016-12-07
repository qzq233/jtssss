package team.jr;
enum Res{AC,WA,TLE,MLE,RE,PE,CE};
public class JudgeResult {
	Res runResult;
	float runtime;
	float memory;
	int grade;
	int  submitTime;
	String errorType;
	int solutionID;
	int problemID;
	int userID;
	
	
	public JudgeResult(Res runResult,
	float runtime,
	float memory,
	int grade,
	int  submitTime,
	String errorType,
	int solutionID,
	int problemID,
	int userID){
		this.runResult = runResult;
		this.runtime = runtime;
		this.memory = memory;
		this.grade = grade;
		this.submitTime = submitTime;
		this.errorType = errorType;
		this.solutionID = solutionID;
		this.problemID = problemID;
		this.userID = userID;
	}
	
	
}
