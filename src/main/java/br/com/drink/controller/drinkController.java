package br.com.drink.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.drink.entity.drinkEntity;
import br.com.drink.service.drinkService;
import br.com.drink.service.impl.drinkServiceImpl;
import br.com.drink.validation.DefaultMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.drink.dto.drinkDto;

@RestController
@CrossOrigin("*")
@RequestMapping("/drinks")
@Api(value = "Controlador Drinks")
public class drinkController {

	@Autowired
	private br.com.drink.service.drinkService drinkService;

	@ApiOperation(value = "Listar todos os Drinks")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "OK", response = drinkEntity.class),
			@ApiResponse(code = 500, message = "Erro", response = DefaultMessage.class),
	})
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<drinkEntity> getAllDrinks(){
		return drinkService.getAllDrinks();
	}

	@ApiOperation(value = "Salvar um novo Drink")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "OK", response = drinkEntity.class),
			@ApiResponse(code = 500, message = "Erro", response = DefaultMessage.class),
			@ApiResponse(code = 400, message = "BadRequest", response = DefaultMessage.class),
	})
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public drinkEntity saveDrink(@Valid @RequestBody drinkDto drink) {
		return drinkService.saveDrink(drink);
	}

	@ApiOperation(value = "Pegar Drink por ID")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "OK", response = drinkEntity.class),
			@ApiResponse(code = 500, message = "Erro", response = DefaultMessage.class),
	})
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<drinkEntity> getDrinkById(@PathVariable Long id) {
		return drinkService.getDrinkById(id);
	}

	@ApiOperation(value = "Deletar Drink")
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> deleteDrinkById(@PathVariable long id) {
		return ResponseEntity.ok(drinkService.deleteDrinkById(id));
	}
	
	
}
