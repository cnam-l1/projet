package com.cnam.project.projectcnam.service;

import com.cnam.project.projectcnam.dao.model.UserDao;
import com.cnam.project.projectcnam.dao.repository.UserRepository;
import io.swagger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser( String id ){

        UserDao userDao = userRepository.getOne(Long.parseLong(id));

        User user = new User();
        user.setIdUser(userDao.getId() + "");
        user.setName(userDao.getName());
        user.setEmail(userDao.getEmail());
        user.setFirstname(userDao.getFirstname());

        return user;
    }

    public List<User> getUserList() {

        List<User> userList = new ArrayList<>();
        List<UserDao> userDaoList = userRepository.findAll();

        for( UserDao userDao : userDaoList ){

            User user = new User();
            user.setIdUser(userDao.getId() + "");
            user.setName(userDao.getName());
            user.setEmail(userDao.getEmail());
            user.setFirstname(userDao.getFirstname());

            userList.add(user);
        }

        return userList;
    }
}
