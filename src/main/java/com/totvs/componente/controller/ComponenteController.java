package com.totvs.componente.controller;

import com.totvs.componente.dto.ComponenteDTO;
import com.totvs.componente.repository.ComponenteRepository;
import com.totvs.componente.request.NovoComponente;
import com.totvs.componente.service.componente.ComponenteService;
import com.totvs.tjf.api.context.stereotype.ApiGuideline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ApiGuideline(ApiGuideline.ApiGuidelineVersion.V2)
@RequestMapping(path = "componente", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ComponenteController {

    @Lazy
    @Autowired
    private ComponenteRepository repository;

    @Lazy
    @Autowired
    private ComponenteService salvarComponente;

    @PostMapping
    ResponseEntity<ComponenteDTO> salvarComponente(@RequestBody NovoComponente novoComponente) {
        return ResponseEntity.ok(salvarComponente.salvar(novoComponente));
    }

    @GetMapping
    ResponseEntity<Page<ComponenteDTO>> paginar(@RequestParam(required = false) String codigo,
                                                @PageableDefault(sort = "codigo",
                                                        direction = Sort.Direction.ASC,
                                                        page = 0,
                                                        size = 30)
                                                        Pageable paginacao) {
        return ResponseEntity.ok(this.repository.findComponenteByCodigoContains(codigo, paginacao));
    }

    @GetMapping(path = "buscarPorId", params = "id")
    ResponseEntity<ComponenteDTO> findComponenteById(Integer id) {
        return ResponseEntity.ok(this.repository.findComponenteById(id));
    }

}
