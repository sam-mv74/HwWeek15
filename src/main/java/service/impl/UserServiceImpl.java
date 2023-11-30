package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.User;
import repository.UserRepository;
import service.UserService;

public class UserServiceImpl<T extends User, R extends UserRepository<T>> extends BaseEntityServiceImpl<T, Integer, R> implements UserService<T> {

    public UserServiceImpl(R repository) {
        super(repository);
    }

    @Override
    public boolean existByUserNameAndPassword(String userName, String password) {
        return repository.existByUserNameAndPassword(userName, password);
    }

    @Override
    public T findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

}