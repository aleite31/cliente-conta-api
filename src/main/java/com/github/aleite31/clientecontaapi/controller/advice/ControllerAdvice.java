package com.github.aleite31.clientecontaapi.controller.advice;

import com.github.aleite31.clientecontaapi.service.exception.ClienteNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(ClienteNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleProdutoNotFoundException(ClienteNaoEncontradoException ex) {
        return ex.getMessage();
    }
}


/*
@RestControllerAdvice
public class ProjetoTesteControllerAdvice {

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handleProdutoNotFoundException(ProdutoNaoEncontradoException ex) {
        return new ApiErrors(ex.getMessage());
    }
}
*/
