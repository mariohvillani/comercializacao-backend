package com.totvs.componente.repository;

import com.totvs.componente.dto.ComponenteDTO;
import com.totvs.componente.model.Componente;
import com.totvs.tjf.api.jpa.repository.ApiJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponenteRepository extends JpaRepository<Componente, Integer>, ApiJpaRepository<Componente> {

    List<ComponenteDTO> findComponenteByCodigoContains(String codigo);

    ComponenteDTO findComponenteById(Integer id);
}
