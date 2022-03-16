package com.github.aleite31.clientecontaapi.controller;

import com.github.aleite31.clientecontaapi.repository.domain.Cliente;
import com.github.aleite31.clientecontaapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "{cpf}")
    public Cliente getClienteByCpf(@PathVariable String cpf) { return clienteService.getClienteByCpf(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @DeleteMapping(value = "{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String cpf) {
        clienteService.delete(cpf);
    }

    @PutMapping(value = "{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String cpf,
                       @RequestBody Cliente cliente) {
        clienteService.update(cpf, cliente);
    }
}
