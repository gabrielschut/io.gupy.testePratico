package org.example.atores;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Funcionario extends Pessoa implements Comparable<Funcionario> {

    private BigDecimal salario;
    private final String funcao;

    public Funcionario(String nome, LocalDate nascimento, String funcao, BigDecimal salario) {
        super(nome, nascimento);
        this.funcao = funcao;
        this.salario = salario;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    private void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void ajusteSalario(double porcentagemDeAjuste){
        BigDecimal porcentagem = BigDecimal.valueOf(1+(porcentagemDeAjuste/100));
        setSalario(this.salario.multiply(porcentagem).setScale(2, RoundingMode.HALF_UP));
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        return String.format(
                """
                Nome: %s,
                Data de Nascimento: %s,
                Salário: R$ %s,
                Função: %s,
                """,
                getNome(),
                getNascimento().format(dateTimeFormatter),
                numberFormat.format(getSalario()),
                getFuncao());
    }

    public String ToStringIdadeNome(){

        return String.format(
            """
            Nome: %s,
            Idade: %s
            """,
                getNome(),
                ChronoUnit.YEARS.between(getNascimento(), LocalDate.now()));
    }

    @Override
    public int compareTo(Funcionario outroFuncionario){
        String nome = getNome();
        int length = Math.min(nome.length(), outroFuncionario.getNome().length());
        int compare = 0;
        for(int i =0; i< length; i++){
            Character char1 = nome.toLowerCase().charAt(i);
            Character char2 = outroFuncionario.getNome().toLowerCase().charAt(i);

            compare = char1.compareTo(char2);
            if(compare != 0)
                return compare;
        }
        return compare;
    }

    public BigDecimal totalDeSlariosMinimos(){
        System.out.println(getNome());
        return getSalario().divide(BigDecimal.valueOf(1212.00), 2, RoundingMode.HALF_UP);
    }
}
