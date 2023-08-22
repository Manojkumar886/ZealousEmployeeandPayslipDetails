package ZEPD.ZealousEmployeeandPayslipDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayslipdetailsService
{
    @Autowired
    PayslipdetailsRepositary payrepo;

    public Payslipdetails newpayslip(Payslipdetails payslip)
    {
        return payrepo.save(payslip);
    }
}
