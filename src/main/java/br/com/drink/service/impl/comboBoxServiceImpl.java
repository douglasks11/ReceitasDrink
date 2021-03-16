package br.com.drink.service.impl;

import br.com.drink.dto.comboBoxDosagemDTO;
import br.com.drink.repository.ComboBoxRepository;
import br.com.drink.service.comboBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class comboBoxServiceImpl implements comboBoxService {

    @Autowired
    private ComboBoxRepository comboBoxRepository;

    public List<comboBoxDosagemDTO> getAllDosagens() {
        List<comboBoxDosagemDTO> lista = new ArrayList<>();
        comboBoxRepository.findAll().forEach(e -> {
            lista.add(comboBoxDosagemDTO.builder()
                    .id(e.getId())
                    .tipo(e.getTipo())
                    .build());
        });
        return lista;
    }
}
