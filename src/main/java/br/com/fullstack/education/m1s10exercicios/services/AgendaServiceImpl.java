package br.com.fullstack.education.m1s10exercicios.services;

import br.com.fullstack.education.m1s10exercicios.entities.AgendaEntity;
import br.com.fullstack.education.m1s10exercicios.exceptions.NotFoundException;
import br.com.fullstack.education.m1s10exercicios.repositories.AgendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository repository;

    public AgendaServiceImpl(AgendaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AgendaEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public AgendaEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "Agenda não encontrada com id: " + id
                ));
    }

    @Override
    public AgendaEntity criar(AgendaEntity entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Override
    public AgendaEntity alterar(Long id, AgendaEntity entity) {
        buscarPorId(id);
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void excluir(Long id) {
        AgendaEntity entity = buscarPorId(id);
        repository.delete(entity);
    }

    @Override
    public AgendaEntity buscarPorAlunoId(Long alunoId) {
        return null;
    }

    @Override
    public AgendaEntity buscarPorTutorId(Long tutorId) {
        return null;
    }
}
