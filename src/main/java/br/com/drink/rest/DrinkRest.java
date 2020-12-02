package br.com.drink.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public List<Drink> getDrinks(String ingrediente){
		return drinkService.findAll(ingrediente);
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Drink salvarDrink(@Valid @RequestBody DrinkDto drink) {		
		return drinkService.create(drink);
	}
	
	@GetMapping("/{id}")
	public Optional<Drink> GetById(@PathVariable Long id) {
		return drinkService.FindById(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void DeleteById(@PathVariable long id) {
		drinkService.deleteById(id);
	}
	
	
}
