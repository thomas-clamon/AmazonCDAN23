package com.example.amazoncdan.repository;

import com.example.amazoncdan.entity.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<ProduitEntity, Integer> {
}
