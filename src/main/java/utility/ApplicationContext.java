package utility;

import repository.*;
import repository.impl.*;
import service.*;
import service.impl.*;

import javax.persistence.EntityManager;
public class ApplicationContext {
    private static final EntityManager entityManager;
    private static final CourseRepository COURSE_REPOSITORY;
    private static final EmployeeRepository EMPLOYEE_REPOSITORY;
    private static final LessonRepository LESSON_REPOSITORY;
    private static final ReportCardRepository REPORT_CARD_REPOSITORY;
    private static final StudentRepository STUDENT_REPOSITORY;
    private static final TeacherRepository TEACHER_REPOSITORY;
    private static final CourseService COURSE_SERVICE;
    private static final EmployeeService EMPLOYEE_SERVICE;
    private static final LessonService LESSON_SERVICE;
    private static final ReportCardService REPORT_CARD_SERVICE;
    private static final StudentService STUDENT_SERVICE;
    private static final TeacherService TEACHER_SERVICE;
//    private static final UserService USER_SERVICE;


    static {
        entityManager = EntityMangerProvider.getEntityManager();
        COURSE_REPOSITORY = new CourseRepositoryImpl(entityManager);
        LESSON_REPOSITORY = new LessonRepositoryImpl(entityManager);
        REPORT_CARD_REPOSITORY = new ReportCardRepositoryImpl(entityManager);
        TEACHER_REPOSITORY = new TeacherRepositoryImpl(entityManager);
        EMPLOYEE_REPOSITORY = new EmployeeRepositoryImpl(entityManager);
        STUDENT_REPOSITORY = new StudentRepositoryImpl(entityManager);

        REPORT_CARD_SERVICE = new ReportCardServiceImpl(REPORT_CARD_REPOSITORY);
        EMPLOYEE_SERVICE = new EmployeeServiceImpl(EMPLOYEE_REPOSITORY);
        STUDENT_SERVICE = new StudentServiceImpl(STUDENT_REPOSITORY, REPORT_CARD_SERVICE);
        TEACHER_SERVICE = new TeacherServiceImpl(TEACHER_REPOSITORY);
        COURSE_SERVICE = new CourseServiceImpl(COURSE_REPOSITORY);
        LESSON_SERVICE = new LessonServiceImpl(LESSON_REPOSITORY);
    }


    public static CourseService getCourseService() {
        return COURSE_SERVICE;
    }

    public static EmployeeService getEmployeeService() {
        return EMPLOYEE_SERVICE;
    }

    public static LessonService getLessonService() {
        return LESSON_SERVICE;
    }

    public static ReportCardService getReportCardService() {
        return REPORT_CARD_SERVICE;
    }

    public static StudentService getStudentService() {
        return STUDENT_SERVICE;
    }

    public static TeacherService getTeacherService() {
        return TEACHER_SERVICE;
    }
}