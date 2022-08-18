package pl.great.company_pl.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Employee {

    private String firstName;
    private String lastName;
    private String pesel;
    private BigDecimal salary;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Employee(String firstName, String lastName, String pesel, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
