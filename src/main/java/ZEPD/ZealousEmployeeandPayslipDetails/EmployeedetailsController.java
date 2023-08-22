package ZEPD.ZealousEmployeeandPayslipDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeedetailsController
{
    @Autowired
    PayslipdetailsService Pserv;
    @Autowired
    EmployeedetailsService serv;
//    http://localhost:8082/urlmapping
//  URL MAPPINGs-  put(update),post(create),get(read ,list),delete(remove)

//    http://localhost:8082/newemployeedetail
    @PostMapping("/newemployeedetail")
    public String createEmployee(@RequestBody Employeedetails emp1)
    {
        return serv.creation(emp1).getEmpName()+"has been added successfully";
    }
    //    http://localhost:8082/
    @GetMapping("/")
    public List<Employeedetails> listall()
    {
        return serv.Showall();
    }

//http://localhost:8082/updatingempdetails
    @PutMapping("/updatingempdetails")
    public String updating(@RequestBody Employeedetails emp1)
    {
        Employeedetails temp=serv.creation(emp1);
        return  temp.getEmpName()+" has beem updated successfully";
    }

//    http://localhost:8082/deleting/{id}
    @DeleteMapping("/deleting/{empid}")
    public String removing(@PathVariable("empid") int empid )
    {
        return serv.erasing(empid);
    }
    @GetMapping("/fetchone/{id}")
    public Optional<Employeedetails> readonly(@PathVariable("id") int id)
    {
        return  serv.fetchingone(id);
    }

    @GetMapping("/fetchonebyname/{name}")
    public List<Employeedetails> readbyname(@PathVariable("name")String name)
    {
        return serv.Fetchingonebyname(name);
    }

    @GetMapping("/toppestsalary/{salary}")
    public List<Employeedetails> readhighest(@PathVariable("salary")double salary)
    {
        return serv.readgreatestsalaries(salary);
    }

    @PutMapping("/updatingsalary/{name}")
    public void UpdatingSalary(@PathVariable("name")String name)
    {
        serv.updateonepersonsalary(name);
    }

//    Payslip CRUDL Activations
    @PostMapping("/createpayslip")
    public Payslipdetails newpayslip(@RequestBody Payslipdetails payslip)
    {
        Employeedetails temp=serv.gettingexactnumber(payslip.getEmpdetails().getEmpId());

        double monthlysalary= temp.getEmpSalary()/12;//480000/12=40000

        double basicsalary=monthlysalary-(monthlysalary*(payslip.getPayslipAllowance())/100);//40000-(40000*2/100)-->40000-800--->39200

        payslip.setPayslipBasicsalary(basicsalary);

        monthlysalary=monthlysalary-(basicsalary*payslip.getPaysliptds()/100);//39200*18/100-->7056-40000--->32944
        payslip.setPayslipTakehome(monthlysalary);

        temp.getMypayslip().add(payslip);

        Pserv.newpayslip(payslip);

        serv.creation(temp);

        return payslip;
    }
}
