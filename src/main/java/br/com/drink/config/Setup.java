package br.com.drink.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.drink.entity.DrinkEntity;
import br.com.drink.entity.IngredientesEntity;
import br.com.drink.repository.DrinkRepository;

@Component
@Profile("dev")
public class Setup implements CommandLineRunner {

	@Autowired
	private DrinkRepository drinkRepository;

	@Override
	public void run(String... args) throws Exception {
		
		var ingredients = Arrays.asList(IngredientesEntity.builder().dosagem("ML").ingrediente("Corote").quantidade("500").build(),
										IngredientesEntity.builder().dosagem("Unidade").ingrediente("Gelo de Coco").quantidade("1").build(),
										IngredientesEntity.builder().dosagem("Unidade").ingrediente("Suco").quantidade("1").build());
		
		var drink = DrinkEntity.builder()
						.ingredientes(ingredients)
						.modoPreparo("Mistura Tudo")
						.nome("Chevette")
						.build();
		
		drinkRepository.save(drink);
	}

}
