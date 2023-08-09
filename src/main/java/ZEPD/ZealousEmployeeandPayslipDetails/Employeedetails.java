package ZEPD.ZealousEmployeeandPayslipDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employeedetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int empId;
    private String empName;
    private String empUsername;
    private String empPassword;
    private String empDesignation;
    private int empExperience;
    @Column(name = "Annualincome")
    private double empSalary;
}
