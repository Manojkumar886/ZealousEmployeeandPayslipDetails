package ZEPD.ZealousEmployeeandPayslipDetails;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class ZealousEmployeeandPayslipDetailsApplicationTests
{
	@MockBean
	EmployeedetailsRepository repo;
	@Autowired
	EmployeedetailsService service;
	@Test
	public void test1()
	{
		Employeedetails emp1=new Employeedetails(1,"Manojkumar","Maddy434","Maddy@1234","Java Stack Developer",2,3.6,null);
		Employeedetails emp2=new Employeedetails(2,"Jeejo","jeejovetharaj","jeejo123","Java stack developer",5,10.5,null);

//		Assertequals,AssertNotEqual,AssertNull,notnull,Same,
//		Mockito.when(repo.save(emp1)).thenReturn(emp1);
//		assertSame("Manojkumar",service.creation(emp1).getEmpName());

		when(repo.findAll()).thenReturn(Stream.of(emp1,emp2).collect(Collectors.toList()));
//		assertSame((emp1),service.Showall().get(0));
//		assertNull(service.Showall().get(0).getMypayslip());
	}
}
