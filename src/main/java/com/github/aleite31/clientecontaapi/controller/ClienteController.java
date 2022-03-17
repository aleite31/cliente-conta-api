package com.github.aleite31.clientecontaapi.controller;

import com.github.aleite31.clientecontaapi.repository.domain.Cliente;
import com.github.aleite31.clientecontaapi.service.ClienteService;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "{cpf}")
    public Cliente getClienteByCpf(@PathVariable("cpf") @CPF(message = "CPF inválido.") String cpf) {
        return clienteService.getClienteByCpf(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody @Valid Cliente cliente) {
        return clienteService.save(cliente);
    }

    @DeleteMapping(value = "{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("cpf") @CPF(message = "CPF inválido.") String cpf) {
        clienteService.delete(cpf);
    }

    @PutMapping(value = "{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("cpf") @CPF(message = "CPF inválido.") String cpf,
                       @RequestBody @Valid Cliente cliente) {
        clienteService.update(cpf, cliente);
    }
}
