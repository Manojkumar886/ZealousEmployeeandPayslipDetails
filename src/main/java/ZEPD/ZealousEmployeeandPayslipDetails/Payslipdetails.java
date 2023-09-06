package ZEPD.ZealousEmployeeandPayslipDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payslipdetails
{
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int payslipId;
//    @JsonFormat(pattern="YYYY-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date payslipDate;
    private double payslipBasicsalary;
    private double paysliptds;
    private double payslipAllowance;
    private double payslipTakehome;
    @ManyToOne
    @JoinColumn(name = "empId")
    @Nullable
    @JsonBackReference
    public Employeedetails empdetails;//empid
}
