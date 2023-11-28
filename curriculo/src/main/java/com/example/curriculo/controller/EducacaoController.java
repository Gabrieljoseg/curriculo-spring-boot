package com.example.curriculo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.curriculo.model.Educacao;
import com.example.curriculo.service.EducacaoService;

import java.util.List;

@RestController
@RequestMapping("/curriculo/educacao")
public class EducacaoController {

    @Autowired
    private EducacaoService educacaoService;

    @GetMapping
    public List<Educacao> getAllEducacoes() {
        return educacaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Educacao> getEducacaoById(@PathVariable Long id) {
        return educacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Educacao createEducacao(@RequestBody Educacao educacao) {
        return educacaoService.save(educacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Educacao> updateEducacao(@PathVariable Long id, @RequestBody Educacao educacaoDetails) {
        return educacaoService.findById(id)
                .map(educacao -> {
                    educacao.setInstituicao(educacaoDetails.getInstituicao());
                    educacao.setCurso(educacaoDetails.getCurso());
                    educacao.setInicio(educacaoDetails.getInicio());
                    educacao.setFim(educacaoDetails.getFim());
                    educacao.setDescricao(educacaoDetails.getDescricao());
                    return ResponseEntity.ok(educacaoService.save(educacao));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEducacao(@PathVariable Long id) {
        return educacaoService.findById(id)
                .map(educacao -> {
                    educacaoService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

