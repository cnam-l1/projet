package com.cnam.project.projectcnam.dao.repository;

import com.cnam.project.projectcnam.dao.model.UserDao;
import io.swagger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDao, Long> {

    public User findUserByName(String name);
}
