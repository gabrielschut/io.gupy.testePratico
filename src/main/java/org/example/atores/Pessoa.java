package org.example.atores;

import java.time.LocalDate;

public class Pessoa {

    private String nome;
    private LocalDate nascimento;

    public Pessoa(){}

    public Pessoa(String nome, LocalDate nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public String getNome() {return nome;}

    private void setNome(String nome) {this.nome = nome;}

    public LocalDate getNascimento() {return nascimento;}

    private void setNascimento(LocalDate nascimento) {this.nascimento = nascimento;}
}
