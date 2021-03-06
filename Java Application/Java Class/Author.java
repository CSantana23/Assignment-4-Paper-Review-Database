package db.columns;

public class Author {
	private String emailAddr;
	private String firstName;
	private String lastName;
	
	public Author(String emailAddr, String firstName, String lastName) {
		super();
		this.emailAddr = emailAddr;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getEmailAddr() {
		return emailAddr;
	}
	
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
}
