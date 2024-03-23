package br.com.fullstack.education.m1s10exercicios.controllers;

import br.com.fullstack.education.m1s10exercicios.entities.AgendaEntity;
import br.com.fullstack.education.m1s10exercicios.services.AgendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agendamentos")
public class AgendamentoController {

    private final AgendaService service;

    public AgendamentoController(AgendaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AgendaEntity>> get() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<AgendaEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("aluno-id/{alunoId}")
    public ResponseEntity<AgendaEntity> getAlunoId(@PathVariable Long alunoId) {
        return ResponseEntity.ok(service.buscarPorAlunoId(alunoId));
    }

    @GetMapping("tutor-id/{tutorId}")
    public ResponseEntity<AgendaEntity> getTutorId(@PathVariable Long tutorId) {
        return ResponseEntity.ok(service.buscarPorTutorId(tutorId));
    }

    @PostMapping
    public ResponseEntity<AgendaEntity> post(@RequestBody AgendaEntity request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(request));
    }

    @PutMapping("{id}")
    public ResponseEntity<AgendaEntity> put(
            @PathVariable Long id, @RequestBody AgendaEntity request
    ) {
        return ResponseEntity.ok(service.alterar(id, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
