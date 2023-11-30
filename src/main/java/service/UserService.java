package service;

import base.service.BaseEntityService;
import entity.User;

public interface UserService<T extends User> extends BaseEntityService<T, Integer> {
    boolean existByUserNameAndPassword(String userName, String password);

    T findByUserName(String userName);
}