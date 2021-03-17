package br.com.drink.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.drink.dto.DrinkRequest;
import br.com.drink.dto.DrinkResponse;
import br.com.drink.entity.DrinkEntity;
import br.com.drink.exception.NotFoundException;
import br.com.drink.repository.DrinkRepository;

@Service
public class DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;


    public List<DrinkResponse> getAllDrinks() {
        return drinkRepository.findAll()
        			.stream()
        			.map(drink -> drink.toResponse())
        			.collect(Collectors.toList());
    }

    public DrinkResponse getDrinkById(Long Id) {
        return getDrinkEntityById(Id)
        		.toResponse();
    }

    public DrinkResponse saveDrink(DrinkRequest drinkRequest) {
        return drinkRepository.save(drinkRequest.toEntity()).toResponse();
    }

    public void deleteDrinkById(long id) {
        var drink = getDrinkEntityById(id);
        drinkRepository.delete(drink);
    }
    
   protected DrinkEntity getDrinkEntityById(Long id) {
	  return drinkRepository.findById(id)
			  .orElseThrow(() -> new NotFoundException("Drink not found with the entered id."));
   }

    public DrinkResponse update(Long id, DrinkRequest drinkRequest) {
    	var drink = getDrinkEntityById(id);
    	var updated = drink.update(drinkRequest);
    	return drinkRepository.save(updated).toResponse();
  }

}
