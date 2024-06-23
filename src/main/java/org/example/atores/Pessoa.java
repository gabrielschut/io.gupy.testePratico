package org.example.atores;

import java.time.LocalDate;

public class Pessoa {

    private final String nome;
    private final LocalDate nascimento;

    public Pessoa(String nome, LocalDate nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public String getNome() {return nome;}

    public LocalDate getNascimento() {return nascimento;}
}
