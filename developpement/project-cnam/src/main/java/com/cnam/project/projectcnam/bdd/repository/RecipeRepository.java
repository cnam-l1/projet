package com.cnam.project.projectcnam.bdd.repository;

import com.cnam.project.projectcnam.bdd.DTO.RecipeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Developed by Hugo Seban
 * Date : 01/07/2018
 * email : hugoseban@icloud.com
 */

@Repository
public interface RecipeRepository extends JpaRepository<RecipeDTO, Long> {}
