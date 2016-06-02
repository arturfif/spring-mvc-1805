package com.springapp.mvc.service;

import com.springapp.mvc.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

@Named
public class UserService implements UserDetailsService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public UserService(SessionFactory factory) {
        this.sessionFactory = factory; // Конструирует DAO
    }


    private Session currentSession() { // Извлекает текущий
        return sessionFactory.getCurrentSession(); // сеанс из фабрики
    }

    public UserService() {
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Query query = currentSession().createQuery("from User u where u.username=:username");
        query.setParameter("username", username);
        User user  =  (User) query.uniqueResult();
        if(user == null) {
            throw new UsernameNotFoundException("username: " + username + "not found!");
        }
        return user;
    }
}
