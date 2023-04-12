package com.example.amazoncdan.controller;

import com.example.amazoncdan.dto.ClientDto;
import com.example.amazoncdan.service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ServiceClient serviceClient;

    @PostMapping("add")
    public ResponseEntity<Boolean> ajouterClient(@RequestBody ClientDto dto){

        // checker si le mail n'existe pas deja
        if (serviceClient.exist(dto.getMail())){
            return new ResponseEntity("le client existe deja", HttpStatus.BAD_REQUEST);
        }

        if (!serviceClient.AddClient(dto)){
            return new ResponseEntity("une erreur est survenue", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);

    }
}
