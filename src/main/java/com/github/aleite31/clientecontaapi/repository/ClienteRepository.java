package com.github.aleite31.clientecontaapi.repository;

import com.github.aleite31.clientecontaapi.repository.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}