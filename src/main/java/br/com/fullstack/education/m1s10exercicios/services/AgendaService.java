package br.com.fullstack.education.m1s10exercicios.services;

import br.com.fullstack.education.m1s10exercicios.entities.AgendaEntity;

import java.util.List;

public interface AgendaService {

    List<AgendaEntity> buscarTodos();

    AgendaEntity buscarPorId(Long id);

    AgendaEntity criar(AgendaEntity entity);

    AgendaEntity alterar(Long id, AgendaEntity entity);

    void excluir(Long id);

    List<AgendaEntity> buscarPorAlunoId(Long alunoId);

    List<AgendaEntity> buscarProximosPorAlunoId(Long alunoId);

    List<AgendaEntity> buscarPorTutorId(Long tutorId);

    List<AgendaEntity> buscarProximosPorTutorId(Long tutorId);

}
