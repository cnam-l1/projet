package com.cnam.project.projectcnam.bdd.DAO;

import com.cnam.project.projectcnam.bdd.DTO.ShoppingDTO;
import com.cnam.project.projectcnam.bdd.exception.DAOException;
import com.cnam.project.projectcnam.bdd.repository.ShoppingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingDAO {

    @Autowired
    ShoppingRepository shoppingRepository;

    private Logger logger = LoggerFactory.getLogger(ShoppingDAO.class);

    public ShoppingDTO saveShopping(ShoppingDTO shoppingDTO) {

        logger.debug("[saveShopping] is called. shopping.id : {}", shoppingDTO.getIdHashShopping());

        try {

            return shoppingRepository.save(shoppingDTO);
        } catch (Exception e) {

            throw new DAOException("Impossible to save the shopping.");
        }
    }

    public List<ShoppingDTO> findAll(Integer idUser) {

        logger.debug("[findAll] is called. user.id : {}", idUser);

        return shoppingRepository.findByIdUser(idUser);
    }
}
