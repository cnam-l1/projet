package com.cnam.project.projectcnam.service;

import com.cnam.project.projectcnam.dao.model.MesureUnitDao;
import com.cnam.project.projectcnam.dao.repository.MeasureUnitRepository;
import com.cnam.project.projectcnam.exception.model.InternalServerError;
import com.cnam.project.projectcnam.exception.model.NotFoundException;
import io.swagger.model.UnitOfMeasure;
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

    @Autowired
    MeasureUnitRepository measureUnitRepository;

    public Integer getIdMesureUnitByName(UnitOfMeasure unitOfMeasure) {

        List<MesureUnitDao> mesureUnitDaoList = measureUnitRepository.findAll();

        for (MesureUnitDao mesureUnitDao : mesureUnitDaoList) {

            if (mesureUnitDao.getName().equals(unitOfMeasure.name())) {

                return mesureUnitDao.getIdMesureUnit().intValue();
            }
        }

        throw new NotFoundException("Category is not found.");
    }

    public String getMeasureUnitNameById(Integer idMeasureUnit) {

        List<MesureUnitDao> mesureUnitDaoList = measureUnitRepository.findAll();

        for (MesureUnitDao measureUnitDao : mesureUnitDaoList) {

            if (measureUnitDao.getIdMesureUnit().equals(idMeasureUnit)) {

                return measureUnitDao.getName();
            }
        }

        throw new InternalServerError("An error occured.");
    }
}
