package br.com.drink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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

import br.com.drink.dto.DosagemRequest;
import br.com.drink.dto.DosagemResponse;
import br.com.drink.service.DosagemService;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@RequestMapping("/dosagens")
@Api(value = "Controlador de Tipo de Dosagens")
public class DosagemController {

	@Autowired
	private DosagemService dosagemService;
	
	@GetMapping
	public List<DosagemResponse> findAll(){
		return dosagemService.findAll();
	}
	
	@GetMapping("/{id}")
	public DosagemResponse findById(@PathVariable("id") Long id) {
		return dosagemService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DosagemResponse create(@RequestBody @Validated DosagemRequest dosagemRequest) {
		return dosagemService.create(dosagemRequest);
	}
	
	@PutMapping("/{id}")
	public DosagemResponse update(@PathVariable("id") Long id, @RequestBody DosagemRequest dosagemRequest) {
		return dosagemService.update(id, dosagemRequest);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		dosagemService.delete(id);
	}
}
