package ZEPD.ZealousEmployeeandPayslipDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayslipdetailsRepositary  extends JpaRepository<Payslipdetails,Integer>
{

}
