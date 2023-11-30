package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.Course;
import repository.CourseRepository;
import service.CourseService;

public class CourseServiceImpl extends BaseEntityServiceImpl<Course, Integer, CourseRepository> implements CourseService {
    public CourseServiceImpl(CourseRepository repository) {
        super(repository);
    }

}