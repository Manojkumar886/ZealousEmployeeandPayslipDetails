package ZEPD.ZealousEmployeeandPayslipDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public String erasing(int id)
    {
        Employeedetails temp=repo.findById(id).orElse(new Employeedetails());
        repo.delete(temp);
        return  temp.getEmpName()+" deleted in my database";
    }

    public Optional<Employeedetails> fetchingone(int id)
    {
        return repo.findById(id);
    }

    public List<Employeedetails> Fetchingonebyname(String name)
    {
        return repo.findAllByEmpName(name);
    }

    public List<Employeedetails> readgreatestsalaries(double salary)
    {
        return  repo.findAllByUserGreatestSalary(salary);
    }

    public void updateonepersonsalary(String empname)
    {
        repo.updateSalaryByname(empname);
    }
}
