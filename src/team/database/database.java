package team.database;

import java.sql.*;	

import java.util.ArrayList;

import team.acc.Account;
import team.jr.JudgeResult;
import team.pro.ProblemAbstract;

public class database {
	String url,name,password;
	public database(String a,String b,String c){
		url=a;
		name=b;
		password=c;
	}

	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("connecting to database ");
			conn = DriverManager.getConnection(url,name,password);
			System.out.println("connected");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	public void addUser(Account account){
        int id=1;
        String username=account.getAccountName();
        String password=account.getPassword();
        int level=account.getLevel().ordinal();
        Connection conn=getConn();
        System.out.println("insert user");
        String sql1 = "select max(user_id) from userinfo";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql1);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())id=rs.getInt(1)+1;
            else System.out.println("empty!");
            System.out.println("id="+id);
        } catch (SQLException e) {
            e.printStackTrace();
        }         
		String sql2 = "insert into userinfo (user_id,username,password,level,is_online) values(?,?,?,?,0)"; 
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql2);
            pstmt.setInt(1, id);
            pstmt.setString(2,username );
            pstmt.setString(3, password);
            pstmt.setInt(4, level);            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            System.out.println("inserted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void deleteUser(int user_id) {
	    String sql = "delete from userinfo where user_id='" + user_id + "'";
	    Connection conn=getConn();
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.executeUpdate();   
	        pstmt.close();
	        conn.close();
	        System.out.println("deleted" );
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void updateUser(Account account){
		Connection conn=getConn();
		String sql = "update userinfo set username= '" +	account.getAccountName()
		+ "', password='" + account.getPassword()
		+"' ,level="+account.getLevel().ordinal()
		+" ,is_online="+account.getState().ordinal()
		+" where user_id="+account.getID();
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.executeUpdate();
	        System.out.println("updated" );
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public Account searchUser(int user_id){
		Connection conn=getConn();
		String sql = "select * from userinfo where user_id="+user_id;	
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        System.out.println("selected!" );
	        if(rs.next()){
	        	Account account=new Account(rs.getInt(1),rs.getString(2),rs.getString(3),Account.Level.values()[rs.getInt(4)],Account.State.values()[rs.getInt(5)]);
	        	pstmt.close();
	        	conn.close();
	        	return account;
	        
	        
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return null;
	}
	public int proInsert(ProblemAbstract problem) {
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
	    problem.setProID(pro_id);
	//    System.out.print(pro_id);
	    String sql = "insert into problem (pro_id,proname,course_id,start_time,end_time) values(?,?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, pro_id);
	        pstmt.setString(2, problem.getProName());
	        pstmt.setInt(3, problem.getCourseID());
	        pstmt.setTimestamp(4, string2time(problem.getStartTime()));
	        pstmt.setTimestamp(5, string2time(problem.getEndTime()));
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return pro_id;
	}
	
	public int proUpdate(ProblemAbstract problem) {
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
	
	public ProblemAbstract proSearch(int pro_id){
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
	
	public ArrayList<ProblemAbstract> searchMyProblem(int user_id){
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
	
	public int proDelete(int pro_id) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "delete from problem where pro_id='" +pro_id + "'";
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
	public int solInsert(JudgeResult solution) {
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
	    solution.setSolutionID(sol_id);
	//    System.out.print(pro_id);
	    String sql = "insert into solution (sol_id,user_id,pro_id,result,time,memory,grade,submit_time) values(?,?,?,?,?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, sol_id);
	        pstmt.setInt(2, solution.getUserID());
	        pstmt.setInt(3, solution.getProblemID());
	        pstmt.setString(4, solution.getRunResult());
	        pstmt.setDouble(5,solution.getRunTime());
	        pstmt.setDouble(6, solution.getMemory());
	        pstmt.setInt(7,solution.getGrade());
	        pstmt.setTimestamp(8, string2time(solution.getSubmitTime()));
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return sol_id;
	}
	public JudgeResult solSearch(int sol_id){
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
	public ArrayList<JudgeResult> searchMySolution(int user_id){
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
	public ArrayList<JudgeResult> searchAllSolution(int pro_id){
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
	public Timestamp string2time(String strtime){ 
	       Timestamp ts = Timestamp.valueOf(strtime);
	       return ts;
	}
    public String time2string(Timestamp datime){
    	String strtime = "";
    	strtime = datime.toString();
    	return strtime;
    }
//	public void main(String[] args) {
	//	proInsert("abc",1,string2time("2016-12-7 13:14:00"),string2time("2016-12-8 13:14:00"));
//		proDelete("abc");
	//	solInsert(1,1,"AC",10,100,99,string2time("2016-12-7 13:14:00"));
//		proUpdate("bde",string2time("2016-12-7 13:14:00"),string2time("2016-12-8 13:14:10"),"abc");
	//	ProblemAbstract pro = proSearch(1);
	//	System.out.println(pro.getProName());
//		ArrayList<JudgeResult> sollist = searchMySolution(1);
//		for(int i = 0;i < sollist.size();i++){
//			
//			System.out.print(sollist.get(i).getSolutionID());
//		}
//		return;
//	}
 //   database dta = new database("1","1","1");
    
	public Account searchUser(String username){
		Connection conn=getConn();
		String sql = "select * from userinfo where username='"+username+"'";	
	   PreparedStatement pstmt;
	   try {
	       pstmt = (PreparedStatement) conn.prepareStatement(sql);
	       ResultSet rs = pstmt.executeQuery();
	       System.out.println("selected!" );
	       if(rs.next()){
	       	Account account=new Account(rs.getInt(1),rs.getString(2),rs.getString(3),Account.Level.values()[rs.getInt(4)],Account.State.values()[rs.getInt(5)]);
	       	pstmt.close();
	       	conn.close();
	       	return account;
	       }
	   } catch (SQLException e) {
	       e.printStackTrace();
	   }
		return null;
	}
	
	public boolean checkUsername(String username){
		Connection conn=getConn();
		String sql = "select count(*) from userinfo where username='"+username+"'";			
		PreparedStatement pstmt;
	   try {
	       pstmt = (PreparedStatement) conn.prepareStatement(sql);
	       ResultSet rs = pstmt.executeQuery();
	       System.out.println("checked!" );
	       if(rs.next()){
	       	pstmt.close();
	       	conn.close();
	       	if(rs.getInt(1)==0)return true;
	       	else return false;
	       }
	   } catch (SQLException e) {
	       e.printStackTrace();
	   }
	   return false;
	}
	
	public ArrayList<ProblemAbstract> showAllProblem(){
		Connection conn = getConn();
		String sql = "select * from problem order by start_time desc";
		PreparedStatement pstmt;
		try{
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<ProblemAbstract> prolist = new ArrayList<ProblemAbstract>();
			while(rs.next()){
				ProblemAbstract problem = new ProblemAbstract(rs.getInt(1),rs.getString(2),rs.getInt(3),time2string(rs.getTimestamp(4)),time2string(rs.getTimestamp(5)));
				prolist.add(problem);
			}
			pstmt.close();
			conn.close();
			return prolist;
		}catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
}
