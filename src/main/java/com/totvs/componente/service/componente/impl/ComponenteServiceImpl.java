package com.totvs.componente.service.componente.impl;

import com.totvs.componente.dto.ComponenteDTO;
import com.totvs.componente.model.Componente;
import com.totvs.componente.repository.ComponenteRepository;
import com.totvs.componente.request.NovoComponente;
import com.totvs.componente.service.componente.ComponenteService;
import com.totvs.componente.validacao.RequestSubmitRequestContraintException;
import com.totvs.tjf.core.validation.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ComponenteServiceImpl implements ComponenteService {

    @Lazy
    @Autowired
    private ComponenteRepository repository;

    @Lazy
    @Autowired
    private ValidatorService validator;

    @Override
    public ComponenteDTO salvar(NovoComponente novoComponente) {
        this.validarContraintException(novoComponente);
        this.validarCodigo(novoComponente.getCodigo());
        return ComponenteDTO.from(this.repository.save(novoComponente.toEntity()));
    }

    private void validarCodigo(String codigo) {
        Componente componente = this.repository.findByCodigo(codigo);
        Assert.isNull(componente, "O código do componente já esta cadastrado");
    }

    private void validarContraintException(NovoComponente novoComponente) {
        this.validator.validate(novoComponente).ifPresent(violations -> {
            throw new RequestSubmitRequestContraintException(violations);
        });
    }
}
