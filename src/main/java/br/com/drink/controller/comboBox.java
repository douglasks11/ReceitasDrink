package br.com.drink.controller;

import br.com.drink.dto.comboBoxDosagemDTO;
import br.com.drink.service.comboBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("enum")
public class comboBox {

    @Autowired
    private comboBoxService comboBoxService;
    @GetMapping("/dosagem")
    public ResponseEntity<List<comboBoxDosagemDTO>> getAllDosagens(){
        return ResponseEntity.ok(comboBoxService.getAllDosagens());
    }

}
