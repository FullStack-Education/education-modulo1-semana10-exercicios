package br.com.fullstack.education.m1s10exercicios.repositories;

import br.com.fullstack.education.m1s10exercicios.entities.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {
}
