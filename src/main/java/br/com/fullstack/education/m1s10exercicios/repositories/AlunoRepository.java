package br.com.fullstack.education.m1s10exercicios.repositories;

import br.com.fullstack.education.m1s10exercicios.entities.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
}
