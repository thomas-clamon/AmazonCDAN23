package com.example.amazoncdan.controller;

import com.example.amazoncdan.dto.CommandeDto;
import com.example.amazoncdan.service.ICommandeService;
import com.example.amazoncdan.service.IServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("Commande")
public class CommandController {

    @Autowired
    private IServiceClient serviceClient;

    @Autowired
    private ICommandeService commandeService;

    @PostMapping("add")
    public ResponseEntity ajouter(@RequestBody CommandeDto dto){

        // controller que le client existe
        if (!serviceClient.exist(dto.getMail_client()))
            return new ResponseEntity("le client n'existe pas", HttpStatus.BAD_REQUEST);

        // controller que la date est bonne
        try {
            LocalDateTime.parse(dto.getDate());
        }catch (Exception e){
            return new ResponseEntity("la date n'est pas bonne", HttpStatus.BAD_REQUEST);
        }

        Integer ID = commandeService.ajouter(dto);

        return new ResponseEntity(ID, HttpStatus.OK);
    }
}
