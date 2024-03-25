package br.com.fullstack.education.m1s10exercicios.repositories;

import br.com.fullstack.education.m1s10exercicios.entities.AgendaEntity;
import br.com.fullstack.education.m1s10exercicios.entities.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {

    List<MaterialEntity> findByAgenda(AgendaEntity agenda);

}
