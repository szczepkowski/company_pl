package pl.great.company_pl.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.great.company_pl.entity.Employee;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepoDefaultTest {

    private static final String FIRST_NAME_TEST = "TEST_NAME";
    private static final String LAST_NAME_TEST = "TEST_NAME2";
    private static final String PESEL_TEST = "TEST_PESEL";
    private static final BigDecimal SALARY_TEST = BigDecimal.TEN;

    @Autowired
    private EmployeeRepo employeeRepo;

    private Employee employee;

    @BeforeEach
    public void setup() throws Exception {
        this.employee = this.employeeRepo.create(FIRST_NAME_TEST, LAST_NAME_TEST, PESEL_TEST, SALARY_TEST);
    }

    @AfterEach
    public void tearDown() {
        this.employeeRepo.delete(PESEL_TEST);
    }

    @Test
    void create() {

        assertEquals(employee.getPesel(), PESEL_TEST);
        assertEquals(employee.getFirstName(), FIRST_NAME_TEST);
        assertEquals(employee.getLastName(), LAST_NAME_TEST);
        assertEquals(employee.getSalary(), SALARY_TEST);
    }

    @Test
    void create2SamePesel() {
        assertThrows(Exception.class, () -> this.employeeRepo.create(FIRST_NAME_TEST, LAST_NAME_TEST, PESEL_TEST, SALARY_TEST));

    }

    @Test
    void update() {

        employee.setFirstName("1234");
        this.employeeRepo.update(employee);

        Employee savedEmployee = this.employeeRepo.get(employee.getPesel());

        assertEquals(savedEmployee.getFirstName(), "1234");
    }

    @Test
    void get() {

        Employee savedEmployee = this.employeeRepo.get(PESEL_TEST);

        assertEquals(savedEmployee.getPesel(), PESEL_TEST);
        assertEquals(savedEmployee.getFirstName(), FIRST_NAME_TEST);
        assertEquals(savedEmployee.getLastName(), LAST_NAME_TEST);
        assertEquals(savedEmployee.getSalary(), SALARY_TEST);
    }

    @Test
    void delete() {
        this.employeeRepo.delete(employee.getPesel());

        Employee removed = this.employeeRepo.get(employee.getPesel());
        assertNull(removed);
    }
}