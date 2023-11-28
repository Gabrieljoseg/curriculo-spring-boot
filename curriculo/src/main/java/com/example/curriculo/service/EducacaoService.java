package com.example.curriculo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curriculo.model.Educacao;
import com.example.curriculo.repository.EducacaoRepository;

@Service
public class EducacaoService {

    @Autowired
    private EducacaoRepository educacaoRepository;

    public List<Educacao> findAll() {
        return educacaoRepository.findAll();
    }

    public Optional<Educacao> findById(Long id) {
        return educacaoRepository.findById(id);
    }

    public Educacao save(Educacao educacao) {
        return educacaoRepository.save(educacao);
    }

    public void delete(Long id) {
        educacaoRepository.deleteById(id);
    }
}
