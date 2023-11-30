package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.Lesson;
import repository.LessonRepository;

import javax.persistence.EntityManager;
public class LessonRepositoryImpl extends BaseEntityRepositoryImpl<Lesson,Integer> implements LessonRepository {
    public LessonRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Lesson> getEntityClass() {
        return Lesson.class;
    }
}
