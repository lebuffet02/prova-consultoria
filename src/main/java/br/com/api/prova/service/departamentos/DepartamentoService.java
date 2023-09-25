package br.com.api.prova.service.departamentos;

import br.com.api.prova.DTO.record.Departamento;
import br.com.api.prova.db.entity.DepartamentoEntity;
import br.com.api.prova.db.repository.DepartamentoRepository;
import br.com.api.prova.exception.departamentoException.DepartamentoException;
import br.com.api.prova.util.MapperUtilsDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService implements DepartamentoInterf {

    @Autowired
    DepartamentoRepository repository;

    @Override
    public Departamento adicionarDepartamento(Departamento departamentoDTO) {
        Optional<DepartamentoEntity> departamento = repository.findById(departamentoDTO.id());
        if (departamento.isPresent()) {
            throw new DepartamentoException("Departamento já existe");
        }
        DepartamentoEntity departamentoEntity = MapperUtilsDepartamento.MAPPER.mapToDepartamentoEntity(departamentoDTO);
        DepartamentoEntity salvarDepartamento = repository.save(departamentoEntity);
        return MapperUtilsDepartamento.MAPPER.mapToDepartamentoDTO(salvarDepartamento);
    }

    @Override
    public List<Object[]> listarDepartamentosComQuantidades() {
        return repository.listarDepartamentosComQuantidades();
    }

    public DepartamentoEntity findByTitulo(String titulo) {
        return repository.findByTitulo(titulo);
    }
}

