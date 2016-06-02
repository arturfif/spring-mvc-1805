package com.springapp.mvc.dao;

import com.springapp.mvc.model.User;

import java.util.List;

/**
 * Created by arturk on 27.05.2016.
 */
public interface UserDAO {

    public void save(User user);

    public void delete(long personId);

    public User get(long personId);

    public User get(String username);

    public List list();

}
