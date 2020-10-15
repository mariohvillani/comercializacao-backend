package com.totvs.componente.controller;

import com.totvs.componente.dto.ComponenteDTO;
import com.totvs.componente.dto.ComponenteItemDTO;
import com.totvs.componente.model.ComponenteItem;
import com.totvs.componente.repository.ComponenteItemRepository;
import com.totvs.componente.request.NovoComponenteItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(path = "componente/item", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ComponenteItemController {

    @Lazy
    @Autowired
    private ComponenteItemRepository repository;

    @PostMapping()
    ResponseEntity<ComponenteItemDTO> salvarComponenteItem(@Valid @RequestBody NovoComponenteItem novoComponenteItem) {
        ComponenteItem componenteItem = this.repository.save(novoComponenteItem.toEntity());
        return ResponseEntity.ok(ComponenteItemDTO.from(componenteItem));
    }

    @DeleteMapping(value = "excluirComponenteItem", params = "idItem")
    ResponseEntity<?> excluirComponenteItem(@Valid @NotNull Integer idItem) {
        this.repository.deleteById(idItem);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "buscarComponenteItem", params = {"idComponente", "parametro"})
    ResponseEntity<List<ComponenteItemDTO>> buscarComponenteItem(@Valid @NotNull Integer idComponente, String parametro) {
        return ResponseEntity.ok(this.repository.buscarComponenteItem(idComponente, parametro));
    }
}
