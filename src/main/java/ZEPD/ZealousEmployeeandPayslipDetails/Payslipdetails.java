package ZEPD.ZealousEmployeeandPayslipDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payslipdetails
{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private  int payslipId;
    private Date payslipDate;
    private double payslipBasicsalary;
    private double paysliptds;
    private double payslipAllowance;
    private double payslipTakehome;
    @ManyToOne
    @JoinColumn(name = "empId")
    public Employeedetails empdetails;//empid
}
