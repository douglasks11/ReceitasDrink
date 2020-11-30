package br.com.drink.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.drink.model.Drink;



	@Repository
	public interface DrinkRepository extends JpaRepository<Drink, Long>{

		List<Drink> findByIngredientesIngrediente(String ingrediente);

}
