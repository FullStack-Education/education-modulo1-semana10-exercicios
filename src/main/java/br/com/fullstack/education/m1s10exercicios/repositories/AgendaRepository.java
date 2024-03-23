package br.com.fullstack.education.m1s10exercicios.repositories;

import br.com.fullstack.education.m1s10exercicios.entities.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {
}
