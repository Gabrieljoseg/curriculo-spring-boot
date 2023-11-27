package com.example.curriculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curriculo.model.Educacao;

public interface EducacaoRepository extends JpaRepository<Educacao, Long> {
}
