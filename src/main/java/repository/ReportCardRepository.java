package repository;

import base.repository.BaseEntityRepository;
import entity.Course;
import entity.ReportCard;
import entity.Student;
import entity.Teacher;

import java.util.List;

public interface ReportCardRepository extends BaseEntityRepository<ReportCard, Integer> {

    Double getAvg(Student student);

    Long getSumOfUnitsInCurrentTerm(Student student);

    List<ReportCard> findByStudent(Student student);

    List<Course> findCourseByStudent(Student student);
    List<Course> findCourseByStudentAndTeacher(Student student, Teacher teacher);

}
