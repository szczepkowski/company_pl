package pl.great.company_pl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.great.company_pl.entity.Employee;
import pl.great.company_pl.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee create(@RequestBody EmployeeView employeeView) throws Exception {
        return this.employeeService.create(employeeView);
    }

    @PutMapping
    public Employee update(@RequestBody EmployeeView employeeView) throws Exception {
        return this.employeeService.update(employeeView);
    }

    @GetMapping("/{pesel}")
    public Employee get(@PathVariable String pesel) throws Exception {
        Employee employee = this.employeeService.get(pesel);
        if (employee == null) {
            throw new Exception("not found pesel : " + pesel);
        }
        return employee;
    }

    @DeleteMapping
    public boolean delete(@RequestParam String pesel) {
        return this.employeeService.delete(pesel);
    }
}
