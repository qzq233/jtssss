<%@ page language="java" contentType="text/html; charset=UTF-8" 
import="java.util.List, java.io.InputStreamReader, java.io.BufferedReader,
java.util.ArrayList,java.io.File,java.io.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>This is the handle Page</h2>
<%
String filePath="/home/dazenhom/Desktop/MYJSP/source_code.cpp";
String code = request.getParameter("code");
FileOperation fo=new  FileOperation();
fo.contentToTxt(filePath,code);
List<String>processList = new ArrayList<String>();
String str = "";
try{
	Process process;	
	process = Runtime.getRuntime().exec("bash  /home/dazenhom/Desktop/MYJSP/shell.sh");
	//process = Runtime.getRuntime().exec("");
	int exitValue = process.waitFor(); 
	//out.print(exitValue);
	if(0!= exitValue)
		process.destroy();
	/*BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
	String line = "";
	while((line = input.readLine()) != null){
		processList.add(line);
	}
	input.close();*/
} catch(Exception e){
	e.printStackTrace();	
}
/*for(String line:processList)
	str+=line;
out.print(str+"");
*/
String reportPath = "/home/dazenhom/Desktop/MYJSP/report.res";
String report="";
FileOperation foo=new  FileOperation();
File f = new File(reportPath);
report = foo.readTxtFile(f);
out.print(report);
%>
<%!
public class FileOperation {
 
 /**
  * 创建文件
  * @param fileName
  * @return
  */
 public  boolean createFile(File fileName)throws Exception{
  boolean flag=false;
  try{
   if(!fileName.exists()){
    fileName.createNewFile();
    flag=true;
   }
  }catch(Exception e){
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

}
%>
</body>
</html>