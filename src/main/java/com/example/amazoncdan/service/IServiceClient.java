package com.example.amazoncdan.service;

import com.example.amazoncdan.dto.ClientDto;
import com.example.amazoncdan.entity.ClientEntity;

public interface IServiceClient {

    Boolean exist(String mail);

    Boolean AddClient(ClientDto dto);

    ClientDto toDto(ClientEntity entity);

    ClientEntity toEntity(ClientDto dto);


}
