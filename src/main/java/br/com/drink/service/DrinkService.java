package br.com.drink.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.drink.dto.DrinkDto;
import br.com.drink.model.Drink;
import br.com.drink.repository.DrinkRepository;

@Service
public class DrinkService {

	@Autowired
	private DrinkRepository drinkRepository;
	
	
	public List<Drink> findAll(){
		
		return drinkRepository.findAll();
	}
	
	public Drink create(DrinkDto drink) {
		Drink drink2 = drink.toEntity();
		return drinkRepository.save(drink2);
	}
	
}
