package br.com.drink.repository;

import br.com.drink.entity.comboBoxDosagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboBoxRepository extends JpaRepository<comboBoxDosagemEntity, Long> {
}
