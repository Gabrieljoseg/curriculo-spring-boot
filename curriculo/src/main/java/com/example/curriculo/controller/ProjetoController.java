package com.example.curriculo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curriculo.model.Projeto;
import com.example.curriculo.service.ProjetoService;

@RestController
@RequestMapping("/curriculo/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public List<Projeto> getAllProjetos() {
        return projetoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> getProjetoById(@PathVariable Long id) {
        return projetoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Projeto createProjeto(@RequestBody Projeto projeto) {
        return projetoService.save(projeto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> updateProjeto(@PathVariable Long id, @RequestBody Projeto projetoDetails) {
        return projetoService.findById(id)
                .map(projeto -> {
                    projeto.setNomeProjeto(projetoDetails.getNomeProjeto());
                    projeto.setDescricao(projetoDetails.getDescricao());
                    projeto.setUrl(projetoDetails.getUrl());
                    projeto.setInicio(projetoDetails.getInicio());
                    projeto.setFim(projetoDetails.getFim());
                    return ResponseEntity.ok(projetoService.save(projeto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProjeto(@PathVariable Long id) {
        return projetoService.findById(id)
                .map(projeto -> {
                    projetoService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
