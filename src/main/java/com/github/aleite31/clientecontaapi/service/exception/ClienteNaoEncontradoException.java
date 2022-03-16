package com.github.aleite31.clientecontaapi.service.exception;


public class ClienteNaoEncontradoException extends RuntimeException {

    public ClienteNaoEncontradoException() {
        super("Cliente não encontrado.");
    }
}
