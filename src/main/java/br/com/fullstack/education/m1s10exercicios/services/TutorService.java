package br.com.fullstack.education.m1s10exercicios.services;

import br.com.fullstack.education.m1s10exercicios.entities.TutorEntity;

import java.util.List;

public interface TutorService {

    List<TutorEntity> buscarTodos();

    TutorEntity buscarPorId(Long id);

    TutorEntity criar(TutorEntity entity);

    TutorEntity alterar(Long id, TutorEntity entity);

    void excluir(Long id);

}
