package ravi.model;

public class MySubs {

	private String accountIdentifier;
	private String success;
	
	
	public MySubs(String accountIdentifier, String success){
		this.accountIdentifier = accountIdentifier;
		this.success = success;
	}
	
	
public void MySubs()
   {
		
		
	}

public String getAccountIdentifier()
{
	return accountIdentifier;
}
	
public void setAccountIdentifier(String accountIdentifier){
	this.accountIdentifier = accountIdentifier;
}

public String getSuccess(){
	return success;
	
}

public void setSuccess (String success){
	this.success = success;
}


}
