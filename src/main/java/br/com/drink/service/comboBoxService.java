package br.com.drink.service;

import br.com.drink.dto.comboBoxDosagemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface comboBoxService {

    List<comboBoxDosagemDTO> getAllDosagens();
}
