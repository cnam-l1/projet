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


}
