package com.example.curriculo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curriculo.model.Habilidade;
import com.example.curriculo.repository.HabilidadeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HabilidadeService {

    @Autowired
    private HabilidadeRepository habilidadeRepository;

    public List<Habilidade> findAll() {
        return habilidadeRepository.findAll();
    }

    public Optional<Habilidade> findById(Long id) {
        return habilidadeRepository.findById(id);
    }

    public Habilidade save(Habilidade habilidade) {
        return habilidadeRepository.save(habilidade);
    }

    public void delete(Long id) {
        habilidadeRepository.deleteById(id);
    }
}
