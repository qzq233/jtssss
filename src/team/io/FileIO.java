package team.io;
import java.io.BufferedReader;
import java.io.File;
import java.io.*;
public class FileIO {
	private String code;
	private String codeFilePath;	 
	private String reportFilePath;
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeFilePath() {
		return codeFilePath;
	}

	public void setCodeFilePath(String codeFilePath) {
		this.codeFilePath = codeFilePath;
	}
	
	public String getReportFilePath() {
		return reportFilePath;
	}

	public void setReportFilePath(String reportFilePath) {
		this.reportFilePath = reportFilePath;
	}

	public  boolean createFile(File fileName)throws Exception{
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
		  */
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
		     result=result+read+"\r\n";
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
		                System.out.print("文件存在");
		            } else {
		                System.out.print("文件不存在");
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
		public void createCodeFile(){
			this.contentToTxt(codeFilePath,code);
		}
		
		public String readReportFile() throws Exception{
			String report="";
			File f = new File(reportFilePath);
			report = this.readTxtFile(f);
			return report;
		}
}

