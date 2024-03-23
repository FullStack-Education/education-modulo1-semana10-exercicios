package br.com.fullstack.education.m1s10exercicios.controllers;

import br.com.fullstack.education.m1s10exercicios.entities.AlunoEntity;
import br.com.fullstack.education.m1s10exercicios.services.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> get() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<AlunoEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AlunoEntity> post(@RequestBody AlunoEntity request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(request));
    }

    @PutMapping("{id}")
    public ResponseEntity<AlunoEntity> put(
            @PathVariable Long id, @RequestBody AlunoEntity request
    ) {
        return ResponseEntity.ok(service.alterar(id, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
