package service.impl;


import entity.Course;
import entity.Lesson;
import entity.ReportCard;
import entity.Student;
import repository.StudentRepository;
import service.ReportCardService;
import service.StudentService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentServiceImpl extends UserServiceImpl<Student, StudentRepository> implements StudentService {
    private final ReportCardService reportCardService;

    public StudentServiceImpl(StudentRepository repository, ReportCardService reportCardService) {
        super(repository);
        this.reportCardService = reportCardService;
    }

    public boolean chooseCourses(Student student, Course course) {
        int maxUnits;
        Long sum;
        if (reportCardService.getAvg(student) == null) {
            maxUnits = 20;
        } else {
            double previousAvg = reportCardService.getAvg(student);
            maxUnits = (previousAvg > 18) ? 24 : 20;
        }
        if (reportCardService.getSumOfUnitsInCurrentTerm(student) == null) {
            sum = 0L;
        } else {
            sum = reportCardService.getSumOfUnitsInCurrentTerm(student);
        }
        if (sum < maxUnits) {
            Set<Lesson> passedLessons = getPassedLessons(student);
            if (!passedLessons.contains(course.getLesson())) {
                if (!isSimilarCourseChosen(student, course)) {
                    ReportCard reportCard = new ReportCard();
                    reportCard.setCourse(course);
                    reportCard.setStudent(student);
                    reportCardService.saveOrUpdate(reportCard);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<ReportCard> findByStudent(Student student) {
        return reportCardService.findByStudent(student);
    }

    private Set<Lesson> getPassedLessons(Student student) {
        Set<Lesson> passedLessons = new HashSet<>();
        for (ReportCard studentCourse : student.getReportCards()) {
            if (studentCourse.getIsPass()) {
                passedLessons.add(studentCourse.getCourse().getLesson());
            }
        }
        return passedLessons;
    }

    private boolean isSimilarCourseChosen(Student student, Course course) {
        for (ReportCard studentCourse : student.getReportCards()) {
            if (studentCourse.getCourse().getLesson().equals(course.getLesson())) {
                return true;
            }
        }
        return false;
    }
}