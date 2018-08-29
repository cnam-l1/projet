package com.cnam.project.projectcnam.bdd.repository;

import com.cnam.project.projectcnam.bdd.DTO.MeasureUnitDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Repository
public interface MeasureUnitRepository extends JpaRepository<MeasureUnitDTO, Long> {
}
