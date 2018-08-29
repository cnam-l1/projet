package com.cnam.project.projectcnam.service;

import com.cnam.project.projectcnam.api.exception.NotFoundException;
import com.cnam.project.projectcnam.bdd.DTO.MeasureUnitDTO;
import com.cnam.project.projectcnam.bdd.repository.MeasureUnitRepository;
import io.swagger.model.MeasureUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Service
public class MeasureUnitService {

    private Logger logger = LoggerFactory.getLogger(MeasureUnitService.class);

    @Autowired
    MeasureUnitRepository measureUnitRepository;

    public Integer getIdMesureUnitByName(MeasureUnit measureUnit) {

        logger.debug("[getIdMesureUnitByName] is called. measureUnit : {}", measureUnit.toString());

        List<MeasureUnitDTO> measureUnitDTOList = measureUnitRepository.findAll();

        for (MeasureUnitDTO measureUnitDTO : measureUnitDTOList) {

            if (measureUnitDTO.getName().equals(measureUnit.toString())) {

                logger.debug("[getIdMesureUnitByName] measur unit is find. measureUnit : {}", measureUnitDTO.getName());

                return measureUnitDTO.getIdMesureUnit().intValue();
            }
        }

        throw new NotFoundException("Measure unit is not found.");
    }

    public String getMeasureUnitNameById(Integer idMeasureUnit) {

        logger.debug("[getMeasureUnitNameById] is called. idMeasureUnit : {}", idMeasureUnit);

        List<MeasureUnitDTO> measureUnitDTOList = measureUnitRepository.findAll();

        for (MeasureUnitDTO measureUnitDao : measureUnitDTOList) {

            if (measureUnitDao.getIdMesureUnit().intValue() == idMeasureUnit) {

                logger.debug("[getIdgetMeasureUnitNameByIdMesureUnitByName] is find. measureUnitDao.name : {}", measureUnitDao.getName());

                return measureUnitDao.getName();
            }
        }

        throw new NotFoundException("Measure unit is not found.");
    }
}
