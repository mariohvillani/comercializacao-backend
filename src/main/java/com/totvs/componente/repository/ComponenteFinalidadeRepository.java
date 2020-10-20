package com.totvs.componente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.totvs.componente.dto.ComponenteFinalidadeDTO;
import com.totvs.componente.model.ComponenteFinalidade;
import com.totvs.tjf.api.jpa.repository.ApiJpaRepository;

public interface ComponenteFinalidadeRepository extends JpaRepository<ComponenteFinalidade, Integer>, ApiJpaRepository<ComponenteFinalidade> {

    @Query("select cf from ComponenteFinalidade cf where cf.componente.id = :idComponente and (cf.codigo like %:parametro% or cf.descricao like %:parametro%)")
    List<ComponenteFinalidadeDTO> buscarComponenteFinalidade(Integer idComponente, String parametro);

}
