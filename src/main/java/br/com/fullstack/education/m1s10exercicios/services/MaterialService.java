package br.com.fullstack.education.m1s10exercicios.services;

import br.com.fullstack.education.m1s10exercicios.entities.MaterialEntity;

import java.util.List;

public interface MaterialService {

    List<MaterialEntity> buscarTodos();

    MaterialEntity buscarPorId(Long id);

    MaterialEntity criar(MaterialEntity entity);

    MaterialEntity alterar(Long id, MaterialEntity entity);

    void excluir(Long id);

}
