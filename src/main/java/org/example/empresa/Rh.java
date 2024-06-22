package org.example.empresa;

import org.example.atores.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Rh {

    private static List<Funcionario> agrupaFuncionariosPorFuncao(String funcao, List<Funcionario> funcionarioList){
        return funcionarioList.stream().filter(funcionario -> funcionario.getFuncao().equals(funcao)).collect(Collectors.toList());
    }

    public static Map<String, List<Funcionario>> geraMapDasFuncoes(List<Funcionario> funcionarioList){
        List<String> funcoes = new ArrayList<>();
        funcoes.add("Operador");
        funcoes.add("Coordenador");
        funcoes.add("Diretor");
        funcoes.add("Recepcionista");
        funcoes.add("Contador");
        funcoes.add("Gerente");
        funcoes.add("Eletricista");

        Map<String, List<Funcionario>> funcoesMap = new HashMap<>();
        for(String funcao : funcoes){
            funcoesMap.put(funcao, agrupaFuncionariosPorFuncao(funcao, funcionarioList));
        }
        return funcoesMap;
    }

    public static void aniversariantesOutubroEDezembro(List<Funcionario> funcionarioList){
        System.out.println(" ");
        System.out.println("Aniversariantes de Outubro e Dezembro");
        for(Funcionario funcionario: funcionarioList){
            if(funcionario.getNascimento().getMonthValue() == 10 || funcionario.getNascimento().getMonthValue() == 12) {
                System.out.println(funcionario);
            }
        }
    }

    public static void todosOsFuncionariosEmOrdemAlfabetica(List<Funcionario> funcionarioList){
        Collections.sort(funcionarioList);
        for(Funcionario funcionario: funcionarioList){
            System.out.println(funcionario);
        }
    }

    public static void imprimeFuncionarioMaisVelho(List<Funcionario> funcionarioList){
        Funcionario maisVelho = new Funcionario("Dummy", LocalDate.now(), "Dummy", BigDecimal.ZERO);
        for(Funcionario funcionario : funcionarioList){
            if(funcionario.getNascimento().isBefore(maisVelho.getNascimento()))
                maisVelho = funcionario;
        }
        System.out.println("Funcionário mais velho");
        System.out.println(maisVelho.ToStringIdadeNome());
    }
}
