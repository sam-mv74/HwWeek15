package service.impl;

import entity.*;
import repository.TeacherRepository;
import service.TeacherService;
import service.dto.TeacherPaySlip;
import utility.SecurityContext;

public class TeacherServiceImpl extends UserServiceImpl<Teacher, TeacherRepository> implements TeacherService {

    public TeacherServiceImpl(TeacherRepository repository) {
        super(repository);
    }

    @Override
    public Teacher getAllTeacherInfo(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean recordStudentMark(Double mark, Student student, Course course) {
        if (mark < 0 || mark > 20) {
            return false;
        }
        repository.recordStudentMark(mark, student, course);
        return true;
    }
    @Override
    public TeacherPaySlip showPaySlip(Term term) {
        Teacher teacher = (Teacher) SecurityContext.getCurrentUser();
        double salary;
        Long unit;
        if (repository.teachingUnits(term) == null) {
            unit = 0L;
        } else {
            unit = repository.teachingUnits(term);
        }
        if (teacher.getTeacherType() == TeacherType.ACADEMIC_STAFF) {
            double fixedSalary = 5000000;
            salary = fixedSalary + (unit * 1000000);
        } else {
            salary = unit * 1000000;
        }
        return new TeacherPaySlip(
                teacher, unit, salary
        );
    }
}