package br.com.drink.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


    public Page<DrinkResponse> getAllDrinks(Pageable pageable, Boolean aprovado) {
    	
    	if (aprovado != null) return drinkRepository.findByAprovado(aprovado, pageable).map(DrinkResponse::new);
    	
    	return drinkRepository.findAll(pageable).map(DrinkResponse::new);
    }

    public DrinkResponse getDrinkById(Long Id) {
        return new DrinkResponse(getDrinkEntityById(Id));
    }

    public DrinkResponse saveDrink(DrinkRequest drinkRequest) {
        return new DrinkResponse(drinkRepository.save(drinkRequest.toEntity()));
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
    	return new DrinkResponse(drinkRepository.save(updated));
  }

	public void approve(Long id) {
		var drink = getDrinkEntityById(id);
		drink.setAprovado(true);
		drink.setDataAprovacao(LocalDate.now());
		drinkRepository.save(drink);
	}

	public void giveLike(Long id) {
		var drink = getDrinkEntityById(id);
		drink.setLikes(drink.getLikes() + 1);
		drinkRepository.save(drink);
	}

}
