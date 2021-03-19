package br.com.drink.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.drink.dto.DrinkRequest;
import br.com.drink.dto.DrinkResponse;
import br.com.drink.entity.DrinkEntity;
import br.com.drink.exceptions.handler.DefaultMessage;
import br.com.drink.service.DrinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/drinks")
@Api(value = "Controlador Drinks")
public class DrinkController {

	@Autowired
	private DrinkService drinkService;

	@ApiOperation(value = "Listar todos os Drinks")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "OK", response = DrinkEntity.class),
			@ApiResponse(code = 500, message = "Erro", response = DefaultMessage.class),
	})
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<DrinkResponse> findAll(){
		return drinkService.getAllDrinks();
	}

	@ApiOperation(value = "Salvar um novo Drink")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "OK", response = DrinkEntity.class),
			@ApiResponse(code = 500, message = "Erro", response = DefaultMessage.class),
			@ApiResponse(code = 400, message = "BadRequest", response = DefaultMessage.class),
	})
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DrinkResponse create(@Valid @RequestBody DrinkRequest request) {
		return drinkService.saveDrink(request);
	}

	@ApiOperation(value = "Pegar Drink por ID")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "OK", response = DrinkEntity.class),
			@ApiResponse(code = 500, message = "Erro", response = DefaultMessage.class),
	})
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public DrinkResponse findById(@PathVariable Long id) {
		return drinkService.getDrinkById(id);
	}
	
	@PutMapping("/{id}")
	public DrinkResponse update(@PathVariable("id") Long id, @RequestBody DrinkRequest drinkRequest) {
		return drinkService.update(id, drinkRequest);
	}
	
	@ApiOperation(value = "Deletar Drink")
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		drinkService.deleteDrinkById(id);
	}
	
	@PostMapping("/approve/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void approve(@PathVariable Long id) {
		drinkService.approve(id);
	}
	
}
