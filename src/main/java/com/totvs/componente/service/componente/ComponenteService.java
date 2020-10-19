package com.totvs.componente.service.componente;

import com.totvs.componente.dto.ComponenteDTO;
import com.totvs.componente.request.NovoComponente;

public interface ComponenteService {

    ComponenteDTO salvar(NovoComponente novoComponente);

}
