package xpug.kata.birthday_greetings;

public class Greetings {
	
	private Employee employee;
	private String sender;
	
	public Greetings(Employee employee) {
		this.employee = employee;
		this.sender = "sender@here.com";
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public String getSender() {
		return sender;
	}
}
