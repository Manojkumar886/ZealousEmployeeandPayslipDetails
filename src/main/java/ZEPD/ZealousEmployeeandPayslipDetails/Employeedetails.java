package ZEPD.ZealousEmployeeandPayslipDetails;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employeedetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private  int empId;
    private String empName;
    private String empUsername;
    private String empPassword;
    private String empDesignation;
    private int empExperience;
    @Column(name = "Annualincome")
    private double empSalary;
//    lazy (one to many, many to many)
//    Eager(many to one, one to one)
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @Nullable
    @JoinTable(name = "AllRecords",joinColumns = @JoinColumn(name="empId")
            ,inverseJoinColumns = @JoinColumn(name = "payslipId"))
    @JsonManagedReference
    private Collection<Payslipdetails> mypayslip=new ArrayList<Payslipdetails>();
}
