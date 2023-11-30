package service.impl;

import entity.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;
import service.dto.EmployeePaySlip;
import utility.SecurityContext;

public class EmployeeServiceImpl extends UserServiceImpl<Employee, EmployeeRepository> implements EmployeeService {

    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }

    @Override
    public EmployeePaySlip showPaySlip() {
        Employee employee = (Employee) SecurityContext.getCurrentUser();
        double salary = 1000000.0;
        return new EmployeePaySlip(
                employee, salary
        );
    }
}