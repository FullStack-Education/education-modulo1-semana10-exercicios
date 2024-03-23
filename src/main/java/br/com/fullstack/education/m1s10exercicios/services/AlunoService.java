package br.com.fullstack.education.m1s10exercicios.services;

import br.com.fullstack.education.m1s10exercicios.entities.AlunoEntity;

import java.util.List;

public interface AlunoService {

    List<AlunoEntity> buscarTodos();

    AlunoEntity buscarPorId(Long id);

    AlunoEntity criar(AlunoEntity entity);

    AlunoEntity alterar(Long id, AlunoEntity entity);

    void excluir(Long id);

}
