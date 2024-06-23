package org.example;

import org.example.atores.Funcionario;
import org.example.empresa.Administrativo;
import org.example.empresa.Rh;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarioList = criaListaDeFuncionarios();
        funcionarioList = funcionarioList.stream().filter(funcionario -> !funcionario.getNome().equals("João")).collect(Collectors.toList());

        System.out.println("Listagem dos funcionários");
        funcionarioList.forEach(System.out::println);
        for(Funcionario funcionario: funcionarioList)
            Administrativo.aumentarSalarioEmPorcentagem(funcionario, 10);

        System.out.println("Os funcionários receberam 10% de aumento de salário!");
        Map<String, List<Funcionario>> mapFuncionarios = Rh.geraMapDasFuncoes(funcionarioList);
        System.out.println(" ");
        impreTodosGruposDeFuncionarios(mapFuncionarios);
        Rh.aniversariantesOutubroEDezembro(funcionarioList);
        Rh.imprimeFuncionarioMaisVelho(funcionarioList);
        Rh.todosOsFuncionariosEmOrdemAlfabetica(funcionarioList);
        System.out.println("R$ " + Administrativo.totalSlarioDosFuncionarios(funcionarioList));
        System.out.println("Número de salários mínimos por funcionário ");
        funcionarioList.forEach(funcionario -> System.out.println(funcionario.totalDeSlariosMinimos()));
    }

    private static void impreTodosGruposDeFuncionarios(Map<String, List<Funcionario>> mapFuncionarios) {
        System.out.println("Listagem dos funcionários agrupados por função");
        imprimeFuncionariosPorFuncao("Contador", mapFuncionarios);
        imprimeFuncionariosPorFuncao("Coordenador", mapFuncionarios);
        imprimeFuncionariosPorFuncao("Diretor", mapFuncionarios);
        imprimeFuncionariosPorFuncao("Eletricista", mapFuncionarios);
        imprimeFuncionariosPorFuncao("Gerente", mapFuncionarios);
        imprimeFuncionariosPorFuncao("Operador", mapFuncionarios);
        imprimeFuncionariosPorFuncao("Recepcionista", mapFuncionarios);
    }

    private static List<Funcionario> criaListaDeFuncionarios() {
        List<Funcionario> funcionarioList = new ArrayList<>();
        funcionarioList.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18),
                 "Operador", BigDecimal.valueOf(2009.44)));
        funcionarioList.add(new Funcionario("João", LocalDate.of(1990, 5, 12),
                "Operador", BigDecimal.valueOf(2284.38)));
        funcionarioList.add(new Funcionario("Caio", LocalDate.of(1961,5,21),
                "Coordenador", BigDecimal.valueOf(9836.14)));
        funcionarioList.add(new Funcionario("Miguel", LocalDate.of(1988, 10,14),
                "Diretor", BigDecimal.valueOf(19119.88)));
        funcionarioList.add(new Funcionario("Alice", LocalDate.of(1995,1,5),
                "Recepcionista", BigDecimal.valueOf(2234.68)));
        funcionarioList.add(new Funcionario("Heitor", LocalDate.of(1999,11,19),
                "Operador", BigDecimal.valueOf(1582.72)));
        funcionarioList.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31),
                "Contador", BigDecimal.valueOf(4071.84)));
        funcionarioList.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8),
                "Gerente", BigDecimal.valueOf(3017.45)));
        funcionarioList.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24),
                "Eletricista", BigDecimal.valueOf(1606.85)));
        funcionarioList.add(new Funcionario("Helena", LocalDate.of(1996, 9,2),
                "Gerente", BigDecimal.valueOf(2799.93)));
        return funcionarioList;
    }

    public static void imprimeFuncionariosPorFuncao(String funcao, Map<String, List<Funcionario>> map){
        System.out.println(funcao);
        List<Funcionario> funcionarioList = map.get(funcao);
        funcionarioList.forEach(System.out::println);
    }
}