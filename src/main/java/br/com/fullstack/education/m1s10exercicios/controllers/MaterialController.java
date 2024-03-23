package br.com.fullstack.education.m1s10exercicios.controllers;

import br.com.fullstack.education.m1s10exercicios.entities.MaterialEntity;
import br.com.fullstack.education.m1s10exercicios.services.MaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("materiais")
public class MaterialController {

    private final MaterialService service;

    public MaterialController(MaterialService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MaterialEntity>> get() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<MaterialEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<MaterialEntity> post(@RequestBody MaterialEntity request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(request));
    }

    @PutMapping("{id}")
    public ResponseEntity<MaterialEntity> put(
            @PathVariable Long id, @RequestBody MaterialEntity request
    ) {
        return ResponseEntity.ok(service.alterar(id, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
