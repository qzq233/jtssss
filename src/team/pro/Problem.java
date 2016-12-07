package team.pro;

public class Problem {
	private String description;
	private String testcase;
	private ProblemAbstract pr;
	//statisticInfo info
	public Problem(){
		
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTestcase() {
		return testcase;
	}
	public void setTestcase(String testcase) {
		this.testcase = testcase;
	}
	public ProblemAbstract getPr() {
		return pr;
	}
	public void setPr(ProblemAbstract pr) {
		this.pr = pr;
	}
	
	public Problem chooseProblem(int proID){
		return this;
	}
	
	public void assignProblem(int ID, int couseID, Problem pro){
		
	}
	
	public void modifyProblem(int userID, Problem newPro){
		
	}
	
	public Problem showAllProInfo(int proID){
		 return this;
	}
}
