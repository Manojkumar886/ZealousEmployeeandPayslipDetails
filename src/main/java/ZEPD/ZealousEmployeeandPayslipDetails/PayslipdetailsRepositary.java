package ZEPD.ZealousEmployeeandPayslipDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PayslipdetailsRepositary  extends JpaRepository<Payslipdetails,Integer>
{
    public List<Payslipdetails> findAllByEmpdetails(Employeedetails emp);

    @Query(value = "from Payslipdetails where payslipDate between :d1 and :d2")
    public List<Payslipdetails> findAllByDateBetween(Date d1,Date d2);
}
