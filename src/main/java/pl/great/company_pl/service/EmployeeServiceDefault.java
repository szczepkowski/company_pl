package pl.great.company_pl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.great.company_pl.controller.EmployeeView;
import pl.great.company_pl.entity.Employee;
import pl.great.company_pl.repository.EmployeeRepo;

@Service
public class EmployeeServiceDefault implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee create(EmployeeView view) throws Exception {
        return employeeRepo.create(view.getFirstName(), view.getLastName(), view.getPesel(), view.getSalary());
    }

    @Override
    public Employee update(EmployeeView view) {
        return employeeRepo.update(new Employee(view.getFirstName(), view.getLastName(), view.getPesel(), view.getSalary()));
    }

    @Override
    public Employee get(String pesel) {
        return employeeRepo.get(pesel);
    }

    @Override
    public boolean delete(String pesel) {
        return employeeRepo.delete(pesel);
    }
}
