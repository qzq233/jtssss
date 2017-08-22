package database;

public class Problem {
//	private String description;
//	private String testcase;
	private ProblemAbstract pr;
	//statisticInfo info
	public Problem(){
		
	}
	database dta;
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public String getTestcase() {
//		return testcase;
//	}
//	public void setTestcase(String testcase) {
//		this.testcase = testcase;
//	}
	public ProblemAbstract getPr() {
		return pr;
	}
	public void setPr(ProblemAbstract pr) {
		this.pr = pr;
	}
	
	public Problem chooseProblem(int proID){
		return this;
	}
	
	public void assignProblem(){
	dta.proInsert(pr);
		//to do : 将description与 test case 存入本地
	}
	
	public void modifyProblem(){
		//if abstract is changed
	//	database.proUpdate(pr);
		//to do 将改变的description与 test case 存入本地
	}
	
	public Problem showAllProInfo(int proID){
		 return this;
	}
}

