package com.example.curriculo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curriculo.model.ExperienciaProfissional;
import com.example.curriculo.repository.ExperienciaProfissionalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienciaProfissionalService {

    @Autowired
    private ExperienciaProfissionalRepository experienciaRepository;

    public List<ExperienciaProfissional> findAll() {
        return experienciaRepository.findAll();
    }

    public Optional<ExperienciaProfissional> findById(Long id) {
        return experienciaRepository.findById(id);
    }

    public ExperienciaProfissional save(ExperienciaProfissional experiencia) {
        return experienciaRepository.save(experiencia);
    }

    public void delete(Long id) {
        experienciaRepository.deleteById(id);
    }
}
