package repository;

import base.repository.BaseEntityRepository;
import entity.User;

public interface UserRepository<T extends User> extends BaseEntityRepository<T, Integer> {
    boolean existByUserNameAndPassword(String userName, String password);
    T findByUserName(String userName);
}