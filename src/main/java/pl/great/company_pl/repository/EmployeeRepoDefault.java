package pl.great.company_pl.repository;

import org.springframework.stereotype.Repository;
import pl.great.company_pl.entity.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeRepoDefault implements EmployeeRepo {

    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee create(String firstName, String lastName, String pesel, BigDecimal salary) throws Exception {
        Employee employee = new Employee(firstName, lastName, pesel, salary);
        Employee exist = this.get(employee.getPesel());

        if (exist != null) {
            throw new Exception("Cannot add 2 same pesel");
        }

        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee oldEmployee = this.get(employee.getPesel());
        int index = this.employeeList.indexOf(oldEmployee);
        this.employeeList.set(index, employee);
        return employee;
    }

    @Override
    public Employee get(String pesel) {

        for (Employee employee : employeeList) {
            if (Objects.equals(pesel, employee.getPesel())) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String pesel) {
        Employee employee = this.get(pesel);
        return this.employeeList.remove(employee);
    }
}
