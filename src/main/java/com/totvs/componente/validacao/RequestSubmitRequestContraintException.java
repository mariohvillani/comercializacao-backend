package com.totvs.componente.validacao;

import com.totvs.tjf.api.context.stereotype.error.ApiBadRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@ApiBadRequest
public class RequestSubmitRequestContraintException extends ConstraintViolationException {
    private static final long serialVersionUID = 2071517040052831080L;

    public RequestSubmitRequestContraintException(Set<? extends ConstraintViolation<?>> constraintViolations) {
        super(constraintViolations);
    }
}