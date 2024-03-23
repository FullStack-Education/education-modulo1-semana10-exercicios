package br.com.fullstack.education.m1s10exercicios.services;

import br.com.fullstack.education.m1s10exercicios.entities.AgendaEntity;
import br.com.fullstack.education.m1s10exercicios.entities.AlunoEntity;
import br.com.fullstack.education.m1s10exercicios.entities.TutorEntity;
import br.com.fullstack.education.m1s10exercicios.exceptions.NotFoundException;
import br.com.fullstack.education.m1s10exercicios.repositories.AgendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AlunoService alunoService;
    private final TutorService tutorService;
    private final AgendaRepository repository;

    public AgendaServiceImpl(AlunoService alunoService, TutorService tutorService, AgendaRepository repository) {
        this.alunoService = alunoService;
        this.tutorService = tutorService;
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

        AlunoEntity aluno = alunoService.buscarPorId(entity.getAluno().getId());
        entity.setAluno(aluno);

        TutorEntity tutor = tutorService.buscarPorId(entity.getTutor().getId());
        entity.setTutor(tutor);

        return repository.save(entity);
    }

    @Override
    public AgendaEntity alterar(Long id, AgendaEntity entity) {
        buscarPorId(id);
        entity.setId(id);

        AlunoEntity aluno = alunoService.buscarPorId(entity.getAluno().getId());
        entity.setAluno(aluno);

        TutorEntity tutor = tutorService.buscarPorId(entity.getTutor().getId());
        entity.setTutor(tutor);

        return repository.save(entity);
    }

    @Override
    public void excluir(Long id) {
        AgendaEntity entity = buscarPorId(id);
        repository.delete(entity);
    }

    @Override
    public List<AgendaEntity> buscarPorAlunoId(Long alunoId) {
        alunoService.buscarPorId(alunoId);
        return repository.findByAlunoIdOrderByData(alunoId);
    }

    @Override
    public List<AgendaEntity> buscarProximosPorAlunoId(Long alunoId) {
        alunoService.buscarPorId(alunoId);
        return repository.findByAlunoIdAndDataGreaterThanOrderByData(alunoId, LocalDateTime.now());
    }

    @Override
    public List<AgendaEntity> buscarPorTutorId(Long tutorId) {
        tutorService.buscarPorId(tutorId);
        return repository.findByTutorIdOrderByData(tutorId);
    }

    @Override
    public List<AgendaEntity> buscarProximosPorTutorId(Long tutorId) {
        tutorService.buscarPorId(tutorId);
        return repository.findByTutorIdAndDataGreaterThanOrderByData(tutorId, LocalDateTime.now());
    }
}
