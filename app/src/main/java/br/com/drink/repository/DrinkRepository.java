package br.com.drink.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.drink.entity.DrinkEntity;


@Repository
public interface DrinkRepository extends JpaRepository<DrinkEntity, Long>{

	Page<DrinkEntity> findByAprovado(boolean aprovado, Pageable pageable);
}
