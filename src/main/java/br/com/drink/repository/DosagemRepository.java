package br.com.drink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.drink.entity.DosagemEntity;

@Repository
public interface DosagemRepository extends JpaRepository<DosagemEntity, Long>{

}
