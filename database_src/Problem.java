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
		//to do : ��description�� test case ���뱾��
	}
	
	public void modifyProblem(){
		//if abstract is changed
	//	database.proUpdate(pr);
		//to do ���ı��description�� test case ���뱾��
	}
	
	public Problem showAllProInfo(int proID){
		 return this;
	}
}

