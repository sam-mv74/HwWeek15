package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.Course;
import entity.ReportCard;
import entity.Student;
import entity.Teacher;
import repository.ReportCardRepository;
import service.ReportCardService;

import java.util.List;

public class ReportCardServiceImpl extends BaseEntityServiceImpl<ReportCard, Integer, ReportCardRepository> implements ReportCardService {

    public ReportCardServiceImpl(ReportCardRepository repository) {
        super(repository);
    }

    @Override
    public Double getAvg(Student student) {
        return repository.getAvg(student);
    }
    @Override
    public Long getSumOfUnitsInCurrentTerm(Student student) {
        return repository.getSumOfUnitsInCurrentTerm(student);
    }
    @Override
    public List<ReportCard> findByStudent(Student student) {
        return repository.findByStudent(student);
    }
    @Override
    public List<Course> findCourseByStudent(Student student) {
        return repository.findCourseByStudent(student);
    }
    @Override
    public List<Course> findCourseByStudentAndTeacher(Student student, Teacher teacher) {
        return repository.findCourseByStudentAndTeacher(student, teacher);
    }
}