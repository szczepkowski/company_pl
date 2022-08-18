package pl.great.company_pl.repository;

import pl.great.company_pl.entity.Employee;
import java.math.BigDecimal;

public interface EmployeeRepo {

    Employee create(String firstName, String lastName, String pesel, BigDecimal salary) throws Exception;

    Employee update(Employee employee);

    Employee get(String pesel);

    boolean delete(String pesel);
}
