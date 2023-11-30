package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Employee extends User {

    private String employeeNumber;

    public Employee(String firstName, String lastName, String userName, String password, String employeeNumber) {
        super(firstName, lastName, userName, password);
        this.employeeNumber = employeeNumber;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id = " + getId() +'\'' +
                " employeeNumber='" + employeeNumber + '\'' +
                "} ";
    }
}