package br.com.drink.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.drink.dto.DrinkDto;
import br.com.drink.model.Drink;
import br.com.drink.service.DrinkService;

@RestController
@CrossOrigin("*")
@RequestMapping("/drinks")
public class DrinkRest {

	@Autowired
	private DrinkService drinkService;
	
	@GetMapping
	public List<Drink> getDrinks(){
		return drinkService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Drink salvarDrink(@RequestBody @Validated DrinkDto drink) {		
		return drinkService.create(drink);
	}
	
}
