package ZEPD.ZealousEmployeeandPayslipDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeedetailsService
{
    @Autowired
    EmployeedetailsRepository repo;//object creation

    public Employeedetails creation(Employeedetails emp)
    {
        return repo.save(emp);
    }

    public List<Employeedetails> Showall()
    {
        return (List<Employeedetails>) repo.findAll();
    }
}
