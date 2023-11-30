package repository.impl;

import entity.Employee;
import repository.EmployeeRepository;

import javax.persistence.EntityManager;

public class EmployeeRepositoryImpl extends UserRepositoryImpl<Employee> implements EmployeeRepository {

    public EmployeeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
}