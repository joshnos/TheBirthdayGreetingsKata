package xpug.kata.birthday_greetings;

import java.util.List;

public interface EmployeeRepository {

	List<Employee> findEmployeesBornOn(OurDate ourDate);
}
