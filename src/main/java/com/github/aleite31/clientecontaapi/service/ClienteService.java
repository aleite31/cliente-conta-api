package com.github.aleite31.clientecontaapi.service;

import com.github.aleite31.clientecontaapi.repository.domain.Cliente;

public interface ClienteService {

    Cliente getClienteByCpf(String cpf);

    Cliente save(Cliente clienteDTO);

    void delete(String cpf);

    void update(String cpf, Cliente clienteDTO);

}

