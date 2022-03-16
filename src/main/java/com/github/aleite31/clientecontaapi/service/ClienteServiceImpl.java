package com.github.aleite31.clientecontaapi.service;

import com.github.aleite31.clientecontaapi.repository.ClienteRepository;
import com.github.aleite31.clientecontaapi.repository.domain.Cliente;
import com.github.aleite31.clientecontaapi.service.exception.ClienteNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente getClienteByCpf(String cpf) {
        return clienteRepository
                .findById(cpf)
                .orElseThrow(() -> new ClienteNaoEncontradoException());
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(String cpf) {
        clienteRepository
                .findById(cpf)
                .map(clienteExistente -> {
                    clienteRepository.delete(clienteExistente);
                    return clienteExistente;
                })
                .orElseThrow(() -> new ClienteNaoEncontradoException());
    }

    @Override
    public void update(String cpf, Cliente cliente) {
        clienteRepository
                .findById(cpf)
                .map(clienteEncontrado -> {
                    cliente.setCpf(clienteEncontrado.getCpf());
                    return clienteRepository.save(cliente);
                })
                .orElseThrow(() -> new ClienteNaoEncontradoException());
    }

}