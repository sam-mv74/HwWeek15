package repository;

import entity.Course;
import entity.Student;
import entity.Teacher;
import entity.Term;

public interface TeacherRepository extends UserRepository<Teacher> {
   void recordStudentMark(Double mark, Student student, Course course);
   Long teachingUnits(Term term);
}