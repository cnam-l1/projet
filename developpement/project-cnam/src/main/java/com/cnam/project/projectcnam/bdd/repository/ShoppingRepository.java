package com.cnam.project.projectcnam.bdd.repository;

import com.cnam.project.projectcnam.bdd.DTO.ShoppingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Developed by Hugo Seban
 * Date : 01/07/2018
 * email : hugoseban@icloud.com
 */

@Repository
public interface ShoppingRepository extends JpaRepository<ShoppingDTO, Long> {

    public List<ShoppingDTO> findByIdUser(Integer idUser);

}
