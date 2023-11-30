package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.*;
import repository.ReportCardRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


public class ReportCardRepositoryImpl extends BaseEntityRepositoryImpl<ReportCard, Integer> implements ReportCardRepository {
    public ReportCardRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<ReportCard> getEntityClass() {
        return ReportCard.class;
    }

    @Override
    public Double getAvg(Student student) {
        try {
            Term term = currentTerm();
            String hql = "SELECT avg(mark) FROM ReportCard WHERE student = :student AND course.term.midTerm = :midTerm AND course.term.year = :year";
            TypedQuery<Double> query = entityManager.createQuery(hql, Double.class);
            query.setParameter("student", student);
            query.setParameter("midTerm", term.getMidTerm());
            query.setParameter("year", term.getYear());
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Long getSumOfUnitsInCurrentTerm(Student student) {
        try {
            Term term = currentTerm();
            String hql = """
                    SELECT sum(c.lesson.unit) FROM ReportCard rc
                    JOIN Course c ON rc.course.id =  c.id
                    JOIN Lesson l ON c.lesson.id = l.id
                    WHERE rc.student = :student  AND c.term.midTerm = :midTerm AND c.term.year = :year
                    """;
            TypedQuery<Long> query = entityManager.createQuery(hql, Long.class);
            query.setParameter("student", student);
            query.setParameter("midTerm", term.getMidTerm());
            query.setParameter("year", term.getYear());
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ReportCard> findByStudent(Student student) {
        try {
            String hql = "SELECT r FROM ReportCard r WHERE r.student = :student";
            TypedQuery<ReportCard> reportCardTypedQuery = entityManager.createQuery(hql, ReportCard.class);
            reportCardTypedQuery.setParameter("student", student);
            return reportCardTypedQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Course> findCourseByStudent(Student student) {
        try {
            String hql = "SELECT course FROM ReportCard r WHERE r.student = :student";
            TypedQuery<Course> reportCardTypedQuery = entityManager.createQuery(hql, Course.class);
            reportCardTypedQuery.setParameter("student", student);
            return reportCardTypedQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Course> findCourseByStudentAndTeacher(Student student, Teacher teacher) {
        try {
            String hql = "SELECT course FROM ReportCard r WHERE r.student = :student AND r.course.teacher = :teacher";
            TypedQuery<Course> reportCardTypedQuery = entityManager.createQuery(hql, Course.class);
            reportCardTypedQuery.setParameter("student", student);
            reportCardTypedQuery.setParameter("teacher", teacher);
            return reportCardTypedQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Term currentTerm() {
        try {
            String hql = "SELECT r FROM ReportCard r ORDER BY r.id desc";
            TypedQuery<ReportCard> reportCardTypedQuery = entityManager.createQuery(hql, ReportCard.class);
            reportCardTypedQuery.setMaxResults(1);
            ReportCard reportCard = reportCardTypedQuery.getSingleResult();
            return reportCard.getCourse().getTerm();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}