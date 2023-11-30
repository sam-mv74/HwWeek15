package repository.impl;

import entity.Course;
import entity.Student;
import entity.Teacher;
import entity.Term;
import repository.TeacherRepository;
import utility.SecurityContext;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class TeacherRepositoryImpl extends UserRepositoryImpl<Teacher> implements TeacherRepository {

    public TeacherRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Teacher> getEntityClass() {
        return Teacher.class;
    }

    @Override
    public void recordStudentMark(Double mark, Student student , Course course) {
        try {
            beginTransaction();
                boolean isPass = mark > 10;
                String hql = "UPDATE FROM ReportCard r SET r.mark = :mark ,  r.isPass= :isPass WHERE student = :student  AND course = :course";
                Query query = entityManager.createQuery(hql);
                query.setParameter("mark", mark);
                query.setParameter("student", student);
                query.setParameter("course", course);
                query.setParameter("isPass", isPass);
                query.executeUpdate();
                commitTransaction();
            } catch(Exception e){
                e.printStackTrace();
                rollBack();
            }
    }


    @Override
    public Long teachingUnits(Term term) {
        try {
            Teacher teacher = (Teacher) SecurityContext.getCurrentUser();

            String hql = """
                SELECT SUM(l.unit) FROM Course c
                JOIN Lesson l on l.id = c.lesson.id
                WHERE c.term = :term AND c.teacher = :teacher
                """;
            TypedQuery<Long> query = entityManager.createQuery(hql, Long.class);
            query.setParameter("term", term);
            query.setParameter("teacher", teacher);
            return query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}