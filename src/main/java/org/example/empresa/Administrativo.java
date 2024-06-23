package org.example.empresa;

import org.example.atores.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public class Administrativo {

    public static void aumentarSalarioEmPorcentagem(Funcionario funcionario, double porcentagemAumento){
        funcionario.ajusteSalario(porcentagemAumento);
    }

    public static BigDecimal totalSlarioDosFuncionarios(List<Funcionario> funcionarioList){
        BigDecimal total = BigDecimal.ZERO;
        for(Funcionario funcionario: funcionarioList){
            BigDecimal salarioFuncionario = funcionario.getSalario();
            total = total.add(salarioFuncionario);
        }
        System.out.println("Soma do salário de todos os funcionários");
        return total;
    }


}
