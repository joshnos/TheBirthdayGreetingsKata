package xpug.kata.birthday_greetings;

import static java.util.Arrays.asList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class BirthdayService {
	int numberOfGreetingsSent;

	public void sendGreetings(EmployeeRepository repository, OurDate ourDate,
			EmailService mail) throws IOException, ParseException, AddressException, MessagingException {
		List<Employee> listOfEmployeesBornOn = repository.findEmployeesBornOn(ourDate);
		numberOfGreetingsSent = 0;
		for (Employee employee : listOfEmployeesBornOn) {
			mail.sendMessage("sender@here.com", employee);
			numberOfGreetingsSent++;
		}
	}

	public static void main(String[] args) {
		EmailService mail = new SMTPMailService("localhost", 25); 
		EmployeeRepository repository = new FileEmployeeRepository("employee_data.txt");
		BirthdayService service = new BirthdayService();
		try {
			service.sendGreetings(repository,
					new OurDate("2008/10/08"), mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int quantityOfGreetingsSent() {
		return numberOfGreetingsSent;
	}
}
