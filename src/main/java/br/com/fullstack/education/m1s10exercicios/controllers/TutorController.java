package br.com.fullstack.education.m1s10exercicios.controllers;

import br.com.fullstack.education.m1s10exercicios.entities.TutorEntity;
import br.com.fullstack.education.m1s10exercicios.services.TutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tutores")
public class TutorController {

    private final TutorService service;

    public TutorController(TutorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TutorEntity>> get() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<TutorEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TutorEntity> post(@RequestBody TutorEntity request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(request));
    }

    @PutMapping("{id}")
    public ResponseEntity<TutorEntity> put(
            @PathVariable Long id, @RequestBody TutorEntity request
    ) {
        return ResponseEntity.ok(service.alterar(id, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
