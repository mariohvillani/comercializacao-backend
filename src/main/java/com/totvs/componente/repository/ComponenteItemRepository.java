package com.totvs.componente.repository;

import com.totvs.componente.dto.ComponenteItemDTO;
import com.totvs.componente.model.ComponenteItem;
import com.totvs.tjf.api.jpa.repository.ApiJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComponenteItemRepository extends JpaRepository<ComponenteItem, Integer>, ApiJpaRepository<ComponenteItem> {

    @Query("select ci from ComponenteItem ci where ci.componente.id = :idComponente and (ci.codigo like %:parametro% or ci.descricao like %:parametro%)")
    List<ComponenteItemDTO> buscarComponenteItem(Integer idComponente, String parametro);

}
