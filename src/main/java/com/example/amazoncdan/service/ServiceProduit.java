package com.example.amazoncdan.service;

import com.example.amazoncdan.dto.ProduitDto;
import com.example.amazoncdan.entity.ProduitEntity;
import com.example.amazoncdan.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProduit implements IProduitService{

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public ProduitEntity toEntity(ProduitDto dto) {
        ProduitEntity entity = new ProduitEntity();
        entity.setNom(dto.getNom());
        entity.setPrix(dto.getPrix());

        return entity;
    }

    @Override
    public ProduitEntity toEntity(Integer ID) {
        return produitRepository.findById(ID).get();
    }

    @Override
    public Boolean exist(Integer ID) {
        return produitRepository.existsById(ID);
    }

    @Override
    public Integer ajouterProduit(ProduitDto dto) {

        ProduitEntity entity = toEntity(dto);
        produitRepository.saveAndFlush(entity);
        return entity.getID();
    }
}
