package br.com.api.prova.service.departamentos;

import br.com.api.prova.dto.DepartamentoDTO;
import br.com.api.prova.entity.DepartamentoEntity;
import br.com.api.prova.exception.departamentoException.DepartamentoException;
import br.com.api.prova.repository.DepartamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentoService implements DepartamentoInterf {

    @Autowired
    DepartamentoRepository repository;
    @Autowired
    private ModelMapper mapper;


    public List<DepartamentoEntity> getTodosDepartamentos() {
        List<DepartamentoEntity> departamentoEntities;
        if(!CollectionUtils.isEmpty(repository.findAll())) {
            departamentoEntities = repository.findAll().stream().collect(Collectors.toList());
            return departamentoEntities;
        }
        return new ArrayList<>();
    }


    public DepartamentoDTO adicionarDepartamento(DepartamentoDTO departamentoDTO) {
        if (!ObjectUtils.isEmpty(departamentoDTO)) {
            if(departamentoDTO.getIdDepartamento() >= 1 && departamentoDTO.getIdDepartamento() <= 3) {
                if(departamentoDTO.getIdDepartamento() == 1 && !departamentoDTO.getTitulo().equalsIgnoreCase("financeiro")) {
                    throw new DepartamentoException("Não foi possível adicionar esse novo departamento");
                } else if (departamentoDTO.getIdDepartamento() == 2 && !departamentoDTO.getTitulo().equalsIgnoreCase("comercial")) {
                    throw new DepartamentoException("Não foi possível adicionar esse novo departamento");
                } else if (departamentoDTO.getIdDepartamento() == 3 && !departamentoDTO.getTitulo().equalsIgnoreCase("desenvolvimento")) {
                    throw new DepartamentoException("Não foi possível adicionar esse novo departamento");
                } else {
                    DepartamentoEntity departamentoEntity = mapper.map(departamentoDTO, DepartamentoEntity.class);
                    DepartamentoEntity salvarDepartamento = repository.save(departamentoEntity);
                    return mapper.map(salvarDepartamento, DepartamentoDTO.class);
                }
            }
        }
        throw new DepartamentoException("Não foi possível adicionar esse novo departamento");
    }


    @Override
    public List<DepartamentoEntity> listarDepartamentosComQuantidades(Long departamentoId) {
        return repository.listarDepartamentosComQuantidades(departamentoId);
    }
}

