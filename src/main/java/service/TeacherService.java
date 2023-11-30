package service;

import entity.Course;
import entity.Student;
import entity.Teacher;
import entity.Term;
import service.dto.TeacherPaySlip;

public interface TeacherService extends UserService<Teacher> {
    Teacher getAllTeacherInfo(Integer id);

    boolean recordStudentMark(Double mark, Student student, Course course);

    TeacherPaySlip showPaySlip(Term term);
}