package pl.great.company_pl.service;

import pl.great.company_pl.controller.EmployeeView;
import pl.great.company_pl.entity.Employee;

import java.math.BigDecimal;

public interface EmployeeService {

    Employee create(EmployeeView employeeView) throws Exception;

    Employee update(EmployeeView employeeView );

    Employee get(String pesel);

    boolean delete(String pesel);
}
