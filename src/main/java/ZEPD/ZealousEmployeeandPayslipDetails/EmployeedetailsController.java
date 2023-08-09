package ZEPD.ZealousEmployeeandPayslipDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.EnumMap;
import java.util.List;

@RestController
public class EmployeedetailsController
{
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
}
