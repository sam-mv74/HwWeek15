package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.Lesson;
import repository.LessonRepository;
import service.LessonService;

public class LessonServiceImpl extends BaseEntityServiceImpl<Lesson, Integer, LessonRepository> implements LessonService {

    public LessonServiceImpl(LessonRepository repository) {
        super(repository);
    }

}