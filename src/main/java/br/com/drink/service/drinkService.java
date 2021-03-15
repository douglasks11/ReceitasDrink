package br.com.drink.service;

import br.com.drink.dto.drinkDto;
import br.com.drink.entity.drinkEntity;
import br.com.drink.service.impl.drinkServiceImpl;

import java.util.List;
import java.util.Optional;

public interface drinkService {

    List<drinkEntity> getAllDrinks();

    Optional<drinkEntity> getDrinkById(Long Id);

    drinkEntity saveDrink(drinkDto drink);

    Object deleteDrinkById(long id);

}
