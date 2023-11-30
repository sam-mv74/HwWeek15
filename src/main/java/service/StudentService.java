package service;

import entity.Course;
import entity.ReportCard;
import entity.Student;

import java.util.List;

public interface StudentService extends UserService<Student> {
    boolean chooseCourses(Student student, Course availableCourses);

    List<ReportCard> findByStudent(Student student);
}