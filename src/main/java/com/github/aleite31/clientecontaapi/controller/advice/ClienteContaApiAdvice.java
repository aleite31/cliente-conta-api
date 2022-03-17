package com.github.aleite31.clientecontaapi.controller.advice;

import com.github.aleite31.clientecontaapi.service.exception.ClienteNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.validation.ConstraintViolationException;

import java.util.stream.Collectors;

/**
 *
 * Opcional:
 *
 * Classe responsável por interceptar excessões de negócio e retornar erro "amigável" para o utilizador da API.
 *
 */

@RestControllerAdvice
public class ClienteContaApiAdvice {

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handleProdutoNotFoundException(ClienteNaoEncontradoException ex) {
        return new ApiErrors(ex.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException ex) {
        return new ApiErrors(ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(erro -> erro.getDefaultMessage()).collect(Collectors.toList()));
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodNotValidException(ConstraintViolationException ex) {
        return new ApiErrors(ex.getConstraintViolations()
                .stream()
                .map(erro -> erro.getMessage()).collect(Collectors.toList()));
    }
}
