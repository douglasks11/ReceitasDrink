package br.com.drink.repository;

import java.util.List;

import br.com.drink.entity.drinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
	public interface DrinkRepository extends JpaRepository<drinkEntity, Long>{
}
