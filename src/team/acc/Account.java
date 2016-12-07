package team.acc;

public class Account {
	public enum Level{ADMIN,TEACHER,STUDENT};
	public enum State{ONLINE,OFFLINE}
	private State state;
	private String accountName;
	private int ID;
	private  Level level;
	private String password;
	
	public Account() {
		
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void logout(){
		this.state = State.OFFLINE;
	}
	
	public void searchMyProblem(){
		
	}
	
	public void searchMySolution(){
		
	}
	
}
