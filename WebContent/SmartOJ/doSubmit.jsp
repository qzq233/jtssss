<%@ page language="java" contentType="text/html; charset=UTF-8" 
import="java.util.List, java.io.InputStreamReader, java.io.BufferedReader,
java.util.ArrayList,java.io.File,java.io.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="fo"  class = "team.io.FileIO" scope = "page"/>
	<jsp:setProperty name="fo" property = "code"  />
	<jsp:setProperty name="fo" property = "codeFilePath"  value = "/home/dazenhom/Desktop/MYJSP/source_code.cpp" />
	<jsp:setProperty name="fo" property = "reportFilePath" value =  "/home/dazenhom/Desktop/MYJSP/report.res" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>This is the handle Page222</h2>
<%
fo.createCodeFile();
List<String>processList = new ArrayList<String>();
String str = "";
try{
	Process process;	
	process = Runtime.getRuntime().exec("bash  /home/dazenhom/Desktop/MYJSP/shell.sh");
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
out.print(fo.readReportFile());
%>

</body>
</html>