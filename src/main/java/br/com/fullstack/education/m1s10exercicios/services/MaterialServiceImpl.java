package br.com.fullstack.education.m1s10exercicios.services;

import br.com.fullstack.education.m1s10exercicios.entities.AgendaEntity;
import br.com.fullstack.education.m1s10exercicios.entities.MaterialEntity;
import br.com.fullstack.education.m1s10exercicios.exceptions.NotFoundException;
import br.com.fullstack.education.m1s10exercicios.repositories.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final AgendaService agendaService;
    private final MaterialRepository repository;

    public MaterialServiceImpl(AgendaService agendaService, MaterialRepository repository) {
        this.agendaService = agendaService;
        this.repository = repository;
    }

    @Override
    public List<MaterialEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public MaterialEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "Material não encontrado com id: " + id
                ));
    }

    @Override
    public List<MaterialEntity> buscarPorAgenda(Long agendaId) {
        AgendaEntity agenda = agendaService.buscarPorId(agendaId);
        return repository.findByAgenda(agenda);
    }

    @Override
    public MaterialEntity criar(MaterialEntity entity) {
        entity.setId(null);

        AgendaEntity agenda = agendaService.buscarPorId(entity.getAgenda().getId());
        entity.setAgenda(agenda);

        return repository.save(entity);
    }

    @Override
    public MaterialEntity alterar(Long id, MaterialEntity entity) {
        buscarPorId(id);
        entity.setId(id);

        AgendaEntity agenda = agendaService.buscarPorId(entity.getAgenda().getId());
        entity.setAgenda(agenda);

        return repository.save(entity);
    }

    @Override
    public void excluir(Long id) {
        MaterialEntity entity = buscarPorId(id);
        repository.delete(entity);
    }
}
