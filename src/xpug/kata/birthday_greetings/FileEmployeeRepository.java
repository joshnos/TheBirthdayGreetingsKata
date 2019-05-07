package xpug.kata.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class FileEmployeeRepository implements EmployeeRepository {

	private String fileName;
	private List<Employee> listOfEmployees;
	
	public FileEmployeeRepository(String fileName) {
		this.fileName = fileName;
		this.listOfEmployees = new ArrayList<>();
		try {
			fileUpload();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void fileUpload() throws IOException, ParseException {
		System.out.println("Abriendo archivo");
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String str = "";
		str = in.readLine(); // skip header
		System.out.println("Primera linea de archivo");
		while ((str = in.readLine()) != null) {
			String[] employeeData = str.split(", ");
			Employee employee = new Employee(employeeData[1], employeeData[0],
					employeeData[2], employeeData[3]);
			listOfEmployees.add(employee);
		}
	}
	
	@Override
	public List<Employee> findEmployeesBornOn(OurDate ourDate) {
		List<Employee> listOfEmployeesBornOn = new ArrayList<>();
		for (Employee employee : listOfEmployees) {
			if (employee.isBirthday(ourDate)) {
				listOfEmployeesBornOn.add(employee);
			}
		}
		return listOfEmployeesBornOn;
	}

}
