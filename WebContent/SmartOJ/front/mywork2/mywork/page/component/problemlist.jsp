<%@ page language="java" pageEncoding="UTF-8"
import = "team.pro.*"
import = "team.database.*"
import ="java.util.ArrayList"
%>

<%! 
//database db2 = new database("jdbc:mysql://172.26.67.120:3306/usr","root","123");
static database db2 = new database("jdbc:mysql://172.28.51.26:3306/usr", "root", "123");%>
<%
String m_proID = request.getParameter("proID4d");
String m_proName = request.getParameter("proName4d");

if(m_proID != null && m_proName != null && m_proName.equals("-1")){
	db2.proDelete(Integer.parseInt(m_proID));
}
%>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<div>	
	<form action = "problemlist.jsp" method = "post">
	<label>Search questions
		<input name = "s_proID" type="text"  placeholder="Search...">
	</label>
	<input type = "button" class = "btn btn-primary  btn-sm"  value = "Search" onclick = "this.form.submit()">
	</form>
	</div>
	<!--<h1 class="page-header">问题列表</h1>-->
	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Start Time</th>
					<th>End Time</th>
					<th>Acceptance</th>
				</tr>
			</thead>
			<tbody>
			<% 
	
			String s_proID = request.getParameter("s_proID");
			if(s_proID != null){		
				ProblemAbstract s_pro = db2.proSearch(Integer.parseInt(s_proID));
				if(s_pro == null);
				else{
					int proID = s_pro.getProID();
					String proName = s_pro.getProName();
					String StartTime = s_pro.getStartTime();
					String EndTime = s_pro.getEndTime();
					%>
					<tr>
					<td><%=proID%></td>
					<td><a href ="problem.jsp?proID=<%=proID%>&proName=<%=proName%>"><%out.print(proName); 
					%></a></td>
					<td><%=StartTime %></td>
					<td><%=EndTime %></td>
					<td><%= "0" %></td>
					<td><a href ="releaseproblem.jsp?proID4m=<%=proID%>&proName4m=<%=proName%>">modify</a> | 
					<a href="problemlist.jsp?proID4d=<%=proID%>&proName4d=<%="-1"%>">delete</a></td>
				</tr>
				<%
				}
			} else{
			ArrayList<ProblemAbstract>  allPro = db2.showAllProblem();
			for(int i = 0; i < allPro.size();i++){
					ProblemAbstract pa = allPro.get(i);//db2.proSearch(i);
					int proID = pa.getProID();
					String proName = pa.getProName();
					String EndTime = pa.getEndTime();
					String StartTime = pa.getStartTime();
			
			%>
			<tr>
					<td><%=proID%></td>
					<td><a href ="problem.jsp?proID=<%=proID%>&proName=<%=proName%>"><%out.print(proName); 
					%></a></td>
					<td><%=StartTime %></td>
					<td><%=EndTime %></td>
					<td><%= "0" %></td>
					<td><a href ="releaseproblem.jsp?proID4m=<%=proID%>&proName4m=<%=proName%>">modify</a> | 
					<a href="problemlist.jsp?proID4d=<%=proID%>&proName4d=<%="-1"%>">delete</a></td>
				</tr>
				<%
				}
			}%>
			</tbody>
		</table>
	</div>
</div>