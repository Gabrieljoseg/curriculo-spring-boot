package com.example.curriculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curriculo.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
