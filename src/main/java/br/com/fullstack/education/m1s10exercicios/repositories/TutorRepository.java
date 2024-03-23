package br.com.fullstack.education.m1s10exercicios.repositories;

import br.com.fullstack.education.m1s10exercicios.entities.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<TutorEntity, Long> {
}
