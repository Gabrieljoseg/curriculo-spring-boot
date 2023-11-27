package com.example.curriculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curriculo.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
