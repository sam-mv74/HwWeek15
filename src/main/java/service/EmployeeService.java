package service;

import entity.Employee;
import service.dto.EmployeePaySlip;

public interface EmployeeService extends UserService<Employee> {
    EmployeePaySlip showPaySlip();
}