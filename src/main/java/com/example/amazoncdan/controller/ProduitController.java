package com.example.amazoncdan.controller;

import com.example.amazoncdan.dto.ProduitDto;
import com.example.amazoncdan.service.ServiceProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produit")
public class ProduitController {

    @Autowired
    private ServiceProduit serviceProduit;
    @PostMapping("add")
    public ResponseEntity<Integer> ajouter(@RequestBody ProduitDto dto){

        Integer id = serviceProduit.ajouterProduit(dto);

        if (id.equals(null)){
            return new ResponseEntity("le produit n'a pas été ajouté", HttpStatus.valueOf(500));
        }
        return new ResponseEntity(id, HttpStatus.OK);
    }
}
