package team.usr;

public class User {
	private String accountName;
	private String password;
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	// TODO
	private boolean vertifyAccount(){
		return true;
	}
	
	private boolean createAccount(){
		return true;
	}
	
	public void register(String accountName, String password){
		
	}
	
	public void login(String accountName, String password){
		if(this.vertifyAccount()  == false)
				;//TODO call the wrongPassword method
		else
			this.createAccount();
	}
	
	
	
}
