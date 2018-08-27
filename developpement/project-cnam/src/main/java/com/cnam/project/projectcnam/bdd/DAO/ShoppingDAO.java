package com.cnam.project.projectcnam.bdd.DAO;

import com.cnam.project.projectcnam.bdd.DTO.ShoppingDTO;
import com.cnam.project.projectcnam.bdd.repository.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingDAO {

    @Autowired
    ShoppingRepository shoppingRepository;

    public ShoppingDTO saveShopping(ShoppingDTO shoppingDTO) {

        return shoppingRepository.save(shoppingDTO);
    }

    public List<ShoppingDTO> findAll(Integer idUser) {

        return shoppingRepository.findByIdUser(idUser);
    }
}
