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

import com.example.curriculo.model.Habilidade;
import com.example.curriculo.service.HabilidadeService;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadeController {

    @Autowired
    private HabilidadeService habilidadeService;

    @GetMapping
    public List<Habilidade> getAllHabilidades() {
        return habilidadeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habilidade> getHabilidadeById(@PathVariable Long id) {
        return habilidadeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Habilidade createHabilidade(@RequestBody Habilidade habilidade) {
        return habilidadeService.save(habilidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habilidade> updateHabilidade(@PathVariable Long id, @RequestBody Habilidade habilidadeDetails) {
        return habilidadeService.findById(id)
                .map(habilidade -> {
                    habilidade.setHabilidade(habilidadeDetails.getHabilidade());
                    habilidade.setNivel(habilidadeDetails.getNivel());
                    return ResponseEntity.ok(habilidadeService.save(habilidade));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHabilidade(@PathVariable Long id) {
        return habilidadeService.findById(id)
                .map(habilidade -> {
                    habilidadeService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
