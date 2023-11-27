package com.example.curriculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curriculo.model.Habilidade;

public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {
}
