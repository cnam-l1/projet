package com.cnam.project.projectcnam.dao.repository;

import com.cnam.project.projectcnam.dao.model.UserDao;
import io.swagger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Repository
public interface UserRepository extends JpaRepository<UserDao, Long> {

    public UserDao findByLogin(String login);

    public UserDao findByIdHashUser(String idHashUser);
}
