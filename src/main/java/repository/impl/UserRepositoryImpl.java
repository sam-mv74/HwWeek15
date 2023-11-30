package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.User;
import repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public abstract class UserRepositoryImpl<T extends User> extends BaseEntityRepositoryImpl<T, Integer> implements UserRepository<T> {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean existByUserNameAndPassword(String userName, String password) {
        try {
            String sql = "select count(u.userName) from "
                    + getEntityClass().getSimpleName()
                    + " u where u.userName = :userName And u.password = :password";
            TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
            query.setParameter("userName", userName);
            query.setParameter("password", password);
            return query.getSingleResult() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public T findByUserName(String userName) {
        try {
            String hql = "SELECT t FROM " + getEntityClass().getSimpleName() + " t WHERE t.userName = :userName";
            TypedQuery<T> query = entityManager.createQuery(hql, getEntityClass());
            query.setParameter("userName", userName);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}