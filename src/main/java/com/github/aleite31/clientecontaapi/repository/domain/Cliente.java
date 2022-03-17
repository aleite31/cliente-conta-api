package com.github.aleite31.clientecontaapi.repository.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {

    @Id
    @Column(name = "cpf")
    @CPF(message = "CPF inválido.")
    private String cpf;

    @Column(name = "nome")
    @NotEmpty(message = "Nome não informado.")
    private String nome;
}