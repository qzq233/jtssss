package team.io;
import java.io.BufferedReader;
import java.io.File;
import java.io.*;
public class ProFileIO {
	private String rootPath;

	private String output;
	private String outputFilePath;
	
	private String input;
	private String inputFilePath;
	
	private String description;
	private String descriptionFilePath;
	
	private String exampleInput;
	private String exampleInputFilePath;
	
	private String exampleOutput;
	private String exampleOutputFilePath;
	
	private String testcaseInput;
	private String testcaseInputFilePath;

	private String testcaseOutput;
	private String testcaseOutputFilePath;
	
	public String getTestcaseInputPath() {
		return testcaseInputFilePath;
	}

	public void setTestcaseInputPath(String testcaseInputPath) {
		this.testcaseInputFilePath = testcaseInputPath;
	}

	public String getTestcaseOutputPath() {
		return testcaseOutputFilePath;
	}

	public void setTestcaseOutputPath(String testcaseOutputPath) {
		this.testcaseOutputFilePath = testcaseOutputPath;
	}

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getOutputFilePath() {
		return outputFilePath;
	}

	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getInputFilePath() {
		return inputFilePath;
	}

	public void setInputFilePath(String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionFilePath() {
		return descriptionFilePath;
	}

	public void setDescriptionFilePath(String descriptionFilePath) {
		this.descriptionFilePath = descriptionFilePath;
	}

	public String getExampleInput() {
		return exampleInput;
	}

	public void setExampleInput(String exampleInput) {
		this.exampleInput = exampleInput;
	}

	public String getExampleInputFilePath() {
		return exampleInputFilePath;
	}

	public void setExampleInputFilePath(String exampleInputFilePath) {
		this.exampleInputFilePath = exampleInputFilePath;
	}

	public String getExampleOutput() {
		return exampleOutput;
	}

	public void setExampleOutput(String exampleOutput) {
		this.exampleOutput = exampleOutput;
	}

	public String getExampleOutputFilePath() {
		return exampleOutputFilePath;
	}

	public void setExampleOutputFilePath(String exampleOutputFilePath) {
		this.exampleOutputFilePath = exampleOutputFilePath;
	}

	//for read 
	public ProFileIO(String rootPath){
		this.descriptionFilePath = rootPath + "/description.txt";
		this.inputFilePath = rootPath + "/input.txt";
		this.outputFilePath = rootPath + "/output.txt";
		this.exampleInputFilePath = rootPath + "/exampleInput.txt";
		this.exampleOutputFilePath = rootPath + "/exampleOutput.txt";
		this.testcaseInputFilePath = rootPath + "/testcaseInput.txt";
		this.testcaseOutputFilePath = rootPath + "/testcaseOutput.txt";
	
	}
	
	//for write
	public ProFileIO(String rootPath, String description, String exampleInput, String exampleOutput, 
			String input, String output, String testcaseInput, String testcaseOutput){
		this.rootPath = rootPath;
		this.descriptionFilePath = rootPath + "/description.txt";
		this.inputFilePath = rootPath + "/input.txt";
		this.outputFilePath = rootPath + "/output.txt";
		this.exampleInputFilePath = rootPath + "/exampleInput.txt";
		this.exampleOutputFilePath = rootPath + "/exampleOutput.txt";
		this.testcaseInputFilePath = rootPath+"/testcaseInput.txt";
		this.testcaseOutputFilePath = rootPath+"/testcaseOutput.txt";
		
		this.exampleInput = exampleInput;
		this.exampleOutput = exampleOutput;
		this.description = description;
		this.input = input;
		this.output = output;
		this.testcaseInput = testcaseInput;
		this.testcaseOutput = testcaseOutput;
		
	}
	public boolean createDir(String destDirName){
		File dir = new File(destDirName );
		if(dir.exists()){
			System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");  
		}
		if (!destDirName.endsWith(File.separator)) {  
            destDirName = destDirName + File.separator;  
        } 
		//创建目录  
        if (dir.mkdirs()) {  
            System.out.println("创建目录" + destDirName + "成功！");  
            return true;  
        } else {  
            System.out.println("创建目录" + destDirName + "失败！");  
            return false;  
        }
	}
	
	public  boolean createFile(File fileName)throws Exception{
		//System.out.println(fileName);
		boolean flag = false;
		try{
			if(!fileName.exists()){
				fileName.createNewFile();
				flag=true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
		 
		 /**
		  * 读TXT文件内容
		  * @param fileName
		  * @return
		  *//*
		 public  String readTxtFile(File fileName)throws Exception{
		  String result="";
		  FileReader fileReader=null;
		  BufferedReader bufferedReader=null;
		  try{
		   fileReader=new FileReader(fileName);
		   bufferedReader=new BufferedReader(fileReader);
		   try{
		    String read=null;
		    while((read=bufferedReader.readLine())!=null){
		     result=result+read;
		    }
		   }catch(Exception e){
		    e.printStackTrace();
		   }
		  }catch(Exception e){
		   e.printStackTrace();
		  }finally{
		   if(bufferedReader!=null){
		    bufferedReader.close();
		   }
		   if(fileReader!=null){
		    fileReader.close();
		   }
		  }
		  System.out.println("读取出来的文件内容是："+"\r\n"+result);
		  return result;
		 }
		 */
	    public String readTxtFile(File file) {  
	        String encoding = "UTF-8";  
	        Long filelength = file.length();  
	        byte[] filecontent = new byte[filelength.intValue()];  
	        try {  
	            FileInputStream in = new FileInputStream(file);  
	            in.read(filecontent);  
	            in.close();  
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        try {  
	            return new String(filecontent, encoding);  
	        } catch (UnsupportedEncodingException e) {  
	            System.err.println("The OS does not support " + encoding);  
	            e.printStackTrace();  
	            return null;  
	        }  
	    }  
		
		 
		 public boolean writeTxtFile(String content,File  fileName)throws Exception{
		  RandomAccessFile mm=null;
		  boolean flag=false;
		  FileOutputStream o=null;
		  try {
		   o = new FileOutputStream(fileName);
		      o.write(content.getBytes("GBK"));
		      o.close();
		//   mm=new RandomAccessFile(fileName,"rw");
		//   mm.writeBytes(content);
		   flag=true;
		  } catch (Exception e) {
		   // TODO: handle exception
		   e.printStackTrace();
		  }finally{
		   if(mm!=null){
		    mm.close();
		   }
		  }
		  return flag;
		 }

		public void contentToTxt(String filePath, String content) {
		        String str = new String(); //原有txt内容
		        String s1 = new String();//内容更新
		        try {
		            File f = new File(filePath);
		            if (f.exists()) {
		                System.out.println("文件存在");
		            } else {
		                System.out.println("文件不存在");
		                System.out.println("file:"+filePath);
		                //createFile(f);
		                f.createNewFile();// 不存在则创建
		            }
		            s1 = content;

		            BufferedWriter output = new BufferedWriter(new FileWriter(f));
		            output.write(s1);
		            output.close();
		        } catch (Exception e) {
		            e.printStackTrace();

		        }
		    }
		
		public String readDescription() throws Exception{
			File f = new File(descriptionFilePath);
			return  this.readTxtFile(f);
		}
		
		public String readInput() throws Exception{
			File f = new File(inputFilePath);
			return  this.readTxtFile(f);
		}
		
		public String readOutput() throws Exception{
			File f = new File(outputFilePath);
			return  this.readTxtFile(f);
		}
		
		public String readExampleOutput() throws Exception{
			File f = new File(exampleOutputFilePath);
			return  this.readTxtFile(f);
		}
		
		public String readExampleIntput() throws Exception{
			File f = new File(exampleInputFilePath);
			return  this.readTxtFile(f);
		}
		
		public void createProblem(){
			this.createDir(rootPath);
			this.contentToTxt(descriptionFilePath, description);
			this.contentToTxt(inputFilePath, input);
			this.contentToTxt(outputFilePath, output);
			this.contentToTxt(exampleInputFilePath, exampleInput);
			this.contentToTxt(exampleOutputFilePath, exampleOutput);
			this.contentToTxt(testcaseInputFilePath, testcaseInput);
			this.contentToTxt(testcaseOutputFilePath, testcaseOutput);
		}
		
		/*
		public void createCodeFile(){
			this.contentToTxt(codeFilePath,code);
		}
		*/
		public String readReportFile(String file) throws Exception{
			String report="";
			File f = new File(file);
			report = this.readTxtFile(f);
			return report;
		}
		
		
}

