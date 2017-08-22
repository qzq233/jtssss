package team.pro;

import team.database.database;
import team.io.*;

public class Problem {
//	private String description;
//	private String testcase;
	private ProblemAbstract pr;
	private database dta;
	//statisticInfo info
	public Problem(ProblemAbstract pr,database db){
		this.pr = pr;
		this.dta =db;
	}

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
	
	public void assignProblem(String rootPath,String description, String exampleInput,String exampleOutput,
			String input, String output, String testcaseInput,String testcaseOutput){
			
			int proID = dta.proInsert(pr);
			
			System.out.println("proID:"+proID);
			rootPath += proID +"";
			ProFileIO pfo= new ProFileIO(rootPath, description, exampleInput, exampleOutput, 
				input, output, testcaseInput, testcaseOutput);
			pfo.createProblem();
	}
	
	public void modifyProblem(String proID,String rootPath,String description, String exampleInput,String exampleOutput,
			String input, String output, String testcaseInput,String testcaseOutput){
		//if abstract is changed
		dta.proUpdate(pr);
		rootPath += proID;
		ProFileIO pfo= new ProFileIO(rootPath, description, exampleInput, exampleOutput, 
			input, output, testcaseInput, testcaseOutput);
		pfo.createProblem();
	}
	
	public Problem showAllProInfo(int proID){
		 return this;
	}
}

