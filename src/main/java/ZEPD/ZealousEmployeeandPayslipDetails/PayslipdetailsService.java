package ZEPD.ZealousEmployeeandPayslipDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PayslipdetailsService
{
    @Autowired
    PayslipdetailsRepositary payrepo;

    public Payslipdetails newpayslip(Payslipdetails payslip)
    {
        return payrepo.save(payslip);
    }

    public List<Payslipdetails> getbyempdetails(Employeedetails emp)
    {
        return  payrepo.findAllByEmpdetails(emp);
    }

    public List<Payslipdetails> getbybetweendates(Date dt1,Date dt2)
    {
        return payrepo.findAllByDateBetween(dt1,dt2);
    }
}
