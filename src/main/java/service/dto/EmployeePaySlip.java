package service.dto;

import entity.Employee;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeePaySlip implements Serializable {

    private Employee employee ;

    private double salary;

}