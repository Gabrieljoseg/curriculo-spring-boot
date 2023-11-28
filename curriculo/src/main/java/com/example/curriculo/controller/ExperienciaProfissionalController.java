package com.example.curriculo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.curriculo.model.ExperienciaProfissional;
import com.example.curriculo.service.ExperienciaProfissionalService;

import java.util.List;

@RestController
@RequestMapping("/api/experiencias")
public class ExperienciaProfissionalController {

    @Autowired
    private ExperienciaProfissionalService experienciaService;

    @GetMapping
    public List<ExperienciaProfissional> getAllExperiencias() {
        return experienciaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienciaProfissional> getExperienciaById(@PathVariable Long id) {
        return experienciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ExperienciaProfissional createExperiencia(@RequestBody ExperienciaProfissional experiencia) {
        return experienciaService.save(experiencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExperienciaProfissional> updateExperiencia(@PathVariable Long id, @RequestBody ExperienciaProfissional experienciaDetails) {
        return experienciaService.findById(id)
                .map(experiencia -> {
                    experiencia.setEmpresa(experienciaDetails.getEmpresa());
                    experiencia.setCargo(experienciaDetails.getCargo());
                    experiencia.setInicio(experienciaDetails.getInicio());
                    experiencia.setFim(experienciaDetails.getFim());
                    experiencia.setDescricao(experienciaDetails.getDescricao());
                    return ResponseEntity.ok(experienciaService.save(experiencia));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExperiencia(@PathVariable Long id) {
        return experienciaService.findById(id)
                .map(experiencia -> {
                    experienciaService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
