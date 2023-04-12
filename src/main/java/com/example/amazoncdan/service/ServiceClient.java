package com.example.amazoncdan.service;

import com.example.amazoncdan.dto.ClientDto;
import com.example.amazoncdan.entity.ClientEntity;
import com.example.amazoncdan.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ServiceClient implements IServiceClient{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Boolean exist(String mail) {
        return clientRepository.existsById(mail);
    }

    @Override
    public Boolean AddClient(ClientDto dto) {
        ClientEntity entity = toEntity(dto);
        try {
            clientRepository.saveAndFlush(entity);
            return  true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ClientDto toDto(ClientEntity entity) {
        return null;
    }

    @Override
    public ClientEntity toEntity(ClientDto dto) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setMail(dto.getMail());
        clientEntity.setNom(dto.getNom());
        clientEntity.setPrenom(dto.getPrenom());
        return clientEntity;
    }
}
