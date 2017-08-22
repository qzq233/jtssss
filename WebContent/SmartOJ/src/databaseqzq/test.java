package databaseqzq;

import java.sql.*;
import java.util.ArrayList;
public class test {

	private static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://172.26.67.120:3306/usr";
	    String username = "root";
	    String password = "123";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	private static int proInsert(String proname,int course_id,Timestamp start_time,Timestamp end_time) {
	    Connection conn = getConn();
	    System.out.println("insert problem");
	    int i = 0, pro_id = 0;
	    String sql1 = "select MAX(pro_id) from problem";
	    PreparedStatement pstmt1;
	    try {
	        pstmt1 = conn.prepareStatement(sql1);
	        ResultSet rs = pstmt1.executeQuery();
	        if(rs.next()){
	        	pro_id = rs.getInt(1) + 1;  	
	        }
	//        System.out.print(pro_id);
	    }catch (SQLException e) {
	        e.printStackTrace();
	    }
	//    System.out.print(pro_id);
	    String sql = "insert into problem (pro_id,proname,course_id,start_time,end_time) values(?,?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, pro_id);
	        pstmt.setString(2, proname);
	        pstmt.setInt(3, course_id);
	        pstmt.setTimestamp(4, start_time);
	        pstmt.setTimestamp(5, end_time);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	private static int proUpdate(ProblemAbstract problem) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update problem set proname='" + problem.getProName() + 
	    		"',start_time ='" + problem.getStartTime() + "',end_time='" + problem.getEndTime() + 
	    		"' where pro_id ='" + problem.getProID() + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	private static ProblemAbstract proSearch(int pro_id){
		 Connection conn = getConn();
		 String sql = "select * from problem where pro_id ='" + pro_id + "'";
		 PreparedStatement pstmt;
		 try {
		        pstmt = conn.prepareStatement(sql);
		        ResultSet rs = pstmt.executeQuery();
		        if(rs.next()){
		        		ProblemAbstract problem = new ProblemAbstract(rs.getInt(1),rs.getString(2),rs.getInt(3),time2string(rs.getTimestamp(4)),time2string(rs.getTimestamp(5)));
		        		pstmt.close();
		        		return problem;
		        }
		//        System.out.print(pro_id);
		    }catch (SQLException e) {
		        e.printStackTrace();
		        
		    }
		 return null;
	}
	
	private static ArrayList<ProblemAbstract> searchMyProblem(int user_id){
		 Connection conn = getConn();
		 String sql = "select * from problem where course_id in (select course_id from study where user_id = '" + user_id + "')";
		 PreparedStatement pstmt;
		 try {
		        pstmt = conn.prepareStatement(sql);
		        ResultSet rs = pstmt.executeQuery();
		        ArrayList<ProblemAbstract> prolist = new ArrayList<ProblemAbstract>();
		        while(rs.next()){
		        	ProblemAbstract problem = new ProblemAbstract(rs.getInt(1),rs.getString(2),rs.getInt(3),time2string(rs.getTimestamp(4)),time2string(rs.getTimestamp(5)));
		        	prolist.add(problem);
		        }
		        pstmt.close();
		        return prolist;
		 }catch (SQLException e) {
		        e.printStackTrace();
		        
		 }
		 return null;
	}
	
	private static int proDelete(String proname) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "delete from problem where proname='" + proname + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	private static int solInsert(int user_id,int pro_id,String result,double time,double memory,int grade,Timestamp submit_time) {
	    Connection conn = getConn();
	    System.out.println("insert solution");
	    int i = 0, sol_id = 0;
	    String sql1 = "select MAX(sol_id) from solution";
	    PreparedStatement pstmt1;
	    try {
	        pstmt1 = conn.prepareStatement(sql1);
	        ResultSet rs = pstmt1.executeQuery();
	        if(rs.next()){
	        	sol_id = rs.getInt(1) + 1;  	
	        }
	//        System.out.print(pro_id);
	    }catch (SQLException e) {
	        e.printStackTrace();
	    }
	//    System.out.print(pro_id);
	    String sql = "insert into solution (sol_id,user_id,pro_id,result,time,memory,grade,submit_time) values(?,?,?,?,?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, sol_id);
	        pstmt.setInt(2, user_id);
	        pstmt.setInt(3, pro_id);
	        pstmt.setString(4, result);
	        pstmt.setDouble(5, time);
	        pstmt.setDouble(6, memory);
	        pstmt.setInt(7,grade);
	        pstmt.setTimestamp(8, submit_time);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	public static JudgeResult solSearch(int sol_id){
		 Connection conn = getConn();
		 String sql = "select * from solution where sol_id ='" + sol_id + "'";
		 PreparedStatement pstmt;
		 try {
		        pstmt = conn.prepareStatement(sql);
		        ResultSet rs = pstmt.executeQuery();
		        if(rs.next()){
		        		JudgeResult solution = new JudgeResult(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6),rs.getInt(7),time2string(rs.getTimestamp(8)));
		        		pstmt.close();
		        		return solution;
		        }
		//        System.out.print(pro_id);
		    }catch (SQLException e) {
		        e.printStackTrace();
		        
		    }
		 return null;
	}
	private static ArrayList<JudgeResult> searchMySolution(int user_id){
		 Connection conn = getConn();
		 String sql = "select * from solution where user_id ='" + user_id + "'";		 
		 PreparedStatement pstmt;
		 try {
		        pstmt = conn.prepareStatement(sql);
		        ResultSet rs = pstmt.executeQuery();
		        ArrayList<JudgeResult> sollist = new ArrayList<JudgeResult>();
		        while(rs.next()){
	        		JudgeResult solution = new JudgeResult(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6),rs.getInt(7),time2string(rs.getTimestamp(8)));
		        	sollist.add(solution);
		        }
		        pstmt.close();
		        return sollist;
		 }catch (SQLException e) {
		        e.printStackTrace();
		        
		 }
		 return null;
	}
	private static ArrayList<JudgeResult> searchAllSolution(int pro_id){
		 Connection conn = getConn();
		 String sql = "select * from solution where pro_id ='" + pro_id + "'";		 
		 PreparedStatement pstmt;
		 try {
		        pstmt = conn.prepareStatement(sql);
		        ResultSet rs = pstmt.executeQuery();
		        ArrayList<JudgeResult> sollist = new ArrayList<JudgeResult>();
		        while(rs.next()){
	        		JudgeResult solution = new JudgeResult(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6),rs.getInt(7),time2string(rs.getTimestamp(8)));
		        	sollist.add(solution);
		        }
		        pstmt.close();
		        return sollist;
		 }catch (SQLException e) {
		        e.printStackTrace();
		 }
		 return null;
	}
	public static Timestamp string2time(String strtime){ 
	       Timestamp ts = Timestamp.valueOf(strtime);
	       return ts;
	}
    public static String time2string(Timestamp datime){
    	String strtime = "";
    	strtime = datime.toString();
    	return strtime;
    }
	public static void main(String[] args) {
		proInsert("abc",1,string2time("2016-12-7 13:14:00"),string2time("2016-12-8 13:14:00"));
//		proDelete("abc");
	//	solInsert(1,1,"AC",10,100,99,string2time("2016-12-7 13:14:00"));
//		proUpdate("bde",string2time("2016-12-7 13:14:00"),string2time("2016-12-8 13:14:10"),"abc");
	//	ProblemAbstract pro = proSearch(1);
	//	System.out.println(pro.getProName());
		ArrayList<JudgeResult> sollist = searchMySolution(1);
		for(int i = 0;i < sollist.size();i++){
			
			System.out.print(sollist.get(i).solutionID);
		}
		return;
		
	}

}