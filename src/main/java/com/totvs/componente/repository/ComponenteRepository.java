package com.totvs.componente.repository;

import com.totvs.componente.dto.ComponenteDTO;
import com.totvs.componente.model.Componente;
import com.totvs.tjf.api.jpa.repository.ApiJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponenteRepository extends JpaRepository<Componente, Integer>, ApiJpaRepository<Componente> {

    Page<ComponenteDTO> findComponenteByCodigoContains(String codigo, Pageable paginacao);

    ComponenteDTO findComponenteById(Integer id);
}
