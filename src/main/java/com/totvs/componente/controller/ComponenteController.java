package com.totvs.componente.controller;

import com.totvs.componente.dto.ComponenteDTO;
import com.totvs.componente.model.Componente;
import com.totvs.componente.repository.ComponenteRepository;
import com.totvs.componente.request.NovoComponente;
import com.totvs.tjf.api.context.stereotype.ApiGuideline;
import com.totvs.tjf.api.validation.stereotype.ApiValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiGuideline(ApiGuideline.ApiGuidelineVersion.V2)
@RequestMapping(path = "componente", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ComponenteController {

    @Lazy
    @Autowired
    private ComponenteRepository repository;

    @PostMapping()
    ResponseEntity<ComponenteDTO> salvarComponente(@ApiValid @RequestBody NovoComponente novoComponente) {
        Componente componente = this.repository.save(novoComponente.toEntity());
        return ResponseEntity.ok(ComponenteDTO.from(componente));
    }

    @GetMapping(path = "buscarPorCodigo", params = "codigo")
    ResponseEntity<List<ComponenteDTO>> buscarPorCodigo(String codigo) {
        return ResponseEntity.ok(this.repository.findComponenteByCodigoContains(codigo));
    }

    @GetMapping(path = "buscarComponentePorId", params = "id")
    ResponseEntity<ComponenteDTO> findComponenteById(Integer id) {
        return ResponseEntity.ok(this.repository.findComponenteById(id));
    }

}
