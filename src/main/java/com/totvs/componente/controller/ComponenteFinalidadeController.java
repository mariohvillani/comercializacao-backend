package com.totvs.componente.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.totvs.componente.dto.ComponenteFinalidadeDTO;
import com.totvs.componente.model.ComponenteFinalidade;
import com.totvs.componente.repository.ComponenteFinalidadeRepository;
import com.totvs.componente.request.NovoComponenteFinalidade;

@RestController
@RequestMapping(path = "componente/finalidade", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ComponenteFinalidadeController {

    @Lazy
    @Autowired
    private ComponenteFinalidadeRepository repository;

    @PostMapping()
    ResponseEntity<ComponenteFinalidadeDTO> salvarComponenteFinalidade(
            @Valid @RequestBody NovoComponenteFinalidade novoComponenteFinalidade) {
        ComponenteFinalidade componenteFinalidade = this.repository.save(novoComponenteFinalidade.toEntity());
        return ResponseEntity.ok(ComponenteFinalidadeDTO.from(componenteFinalidade));
    }

    @DeleteMapping(value = "excluirComponenteFinalidade", params = "idItem")
    ResponseEntity<?> excluirComponentiFinalidade(@Valid @NotNull Integer idItem) {
        this.repository.deleteById(idItem);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "buscarComponenteFinalidade", params = { "idComponente", "parametro" })
    ResponseEntity<List<ComponenteFinalidadeDTO>> buscarComponenteFinalidade(@Valid @NotNull Integer idComponente,
            String parametro) {
        return ResponseEntity.ok(this.repository.buscarComponenteFinalidade(idComponente, parametro));
    }
}
