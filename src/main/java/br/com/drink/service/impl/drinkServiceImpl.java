package br.com.drink.service.impl;

import java.util.List;
import java.util.Optional;

import br.com.drink.repository.DrinkRepository;
import br.com.drink.service.drinkService;
import br.com.drink.validation.DefaultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.drink.dto.drinkDto;
import br.com.drink.entity.drinkEntity;

@Service
public class drinkServiceImpl implements drinkService {

    @Autowired
    private DrinkRepository drinkRepository;


    public List<drinkEntity> getAllDrinks() {
        return drinkRepository.findAll();
    }

    public Optional<drinkEntity> getDrinkById(Long Id) {
        return drinkRepository.findById(Id);
    }

    public drinkEntity saveDrink(drinkDto drink) {
        return drinkRepository.save(drinkEntity.builder()
                .id(null)
                .nome(drink.getNome())
                .ingredientes(drink.getIngredientes())
                .modoPreparo(drink.getModoPreparo())
                .build());
    }

    public Object deleteDrinkById(long id) {
        drinkRepository.deleteById(id);
        var drink = drinkRepository.findById(id);
        if (drink.isEmpty()) {
            return DefaultMessage.builder()
                    .code("200")
                    .message("Deletado com sucesso")
                    .build();
        } else return DefaultMessage.builder()
                .code("500")
                .message("Problema ao deletar drink Abaixo")
                .objectGeneric(drink);

    }


}
