package com.example.amazoncdan.service;

import com.example.amazoncdan.dto.CommandeDto;
import com.example.amazoncdan.entity.ClientEntity;
import com.example.amazoncdan.entity.CommandeEntity;
import com.example.amazoncdan.entity.ProduitEntity;
import com.example.amazoncdan.repository.ClientRepository;
import com.example.amazoncdan.repository.CommandeRepository;
import com.example.amazoncdan.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommandeService implements ICommandeService{

    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    IProduitService produitService;

    @Override
    public Integer ajouter(CommandeDto dto) {

        CommandeEntity entity = new CommandeEntity();

        entity.setDate(LocalDateTime.parse(dto.getDate()));

        // on ajoute notre client
        ClientEntity clientEntity = clientRepository.findById(dto.getMail_client()).get();

        ProduitEntity produitEntity = produitService.toEntity(dto.getProduit());

        entity.setClient(clientEntity);
        entity.setProduit(produitEntity);

        commandeRepository.saveAndFlush(entity);
        return  entity.getID();
    }
}
