package database;

public class Solution {
//	private int userID;
//	private String sourcCode;
//	private String comment;
//	private String teacherJudge;
	database dta;
	private JudgeResult result;
	
	public JudgeResult getResult(){
		return result;
	}
	
	public void setResult(JudgeResult result){
		this.result = result;
	}
	
	public void submit(){
		Autojudge();
		dta.solInsert(result);
		//to do : save source code , comment and teacherJudge to local file
	}
	
	public void Autojudge(){
		//to do : judge and set solution
	}
	
	public void JudgeSolution(String comments, int grade, int userID){
		// to do
	}
}
