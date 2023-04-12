package com.example.amazoncdan.service;

import com.example.amazoncdan.dto.ProduitDto;
import com.example.amazoncdan.entity.ProduitEntity;

public interface IProduitService {

    ProduitEntity toEntity(ProduitDto dto);

    ProduitEntity toEntity(Integer ID);

    Boolean exist (Integer ID);
    Integer ajouterProduit(ProduitDto dto);
}