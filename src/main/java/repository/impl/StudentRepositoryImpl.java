package repository.impl;

import entity.Student;
import repository.StudentRepository;

import javax.persistence.EntityManager;

public class StudentRepositoryImpl extends UserRepositoryImpl<Student> implements StudentRepository {

    public StudentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}