package ZEPD.ZealousEmployeeandPayslipDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeedetailsRepository extends CrudRepository<Employeedetails,Integer>
{
    public List<Employeedetails> findAllByEmpName(String empname);
// public List<Employeedetails> findAllByEMpDesignation(String empdesignation);

//    select * from Employeedetails where EmpSalary>=5;

//    HQL-Hibernate Query Languages
    @Query("from Employeedetails where empSalary>=:useramount")
    public List<Employeedetails> findAllByUserGreatestSalary(double useramount);

//    400000=400000+(400000*20/100)
    @Transactional
    @Modifying
    @Query("update Employeedetails set empSalary=empSalary+(empSalary*20/100) where empName=:upgradesalarybymyfav")
    public void updateSalaryByname(String upgradesalarybymyfav);

}
