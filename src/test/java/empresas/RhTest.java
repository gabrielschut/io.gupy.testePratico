package empresas;

import org.example.atores.Funcionario;
import org.example.empresa.Rh;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RhTest {

    private Funcionario funcionario1;
    private Funcionario funcionario2;
    private Funcionario funcionario3;
    private Funcionario funcionario4;
    private Funcionario funcionario5;
    private Funcionario funcionario6;

    @BeforeEach
    public void setUp() {
        funcionario1 = new Funcionario("João", LocalDate.of(1990,
                1, 1), "Desenvolvedor", new BigDecimal("2000.00"));
        funcionario2 = new Funcionario("Maria", LocalDate.of(1985,
                10, 20), "Gerente", new BigDecimal("3000.00"));
        funcionario3 = new Funcionario("Ana", LocalDate.of(1992,
                12, 10), "Analista", new BigDecimal("2500.00"));
        funcionario4 = new Funcionario("Paulo", LocalDate.of(1988,
                5, 15), "Desenvolvedor", new BigDecimal("2800.00"));
        funcionario5 = new Funcionario("Carla", LocalDate.of(1983,
                3, 8), "Gerente", new BigDecimal("3200.00"));
        funcionario6 = new Funcionario("Pedro", LocalDate.of(1975,
                7, 30), "Diretor", new BigDecimal("5000.00"));
    }

    @Test
    public void testGeraMapDasFuncoes() {
        List<Funcionario> funcionarios = Arrays.asList(funcionario1, funcionario2, funcionario3, funcionario4, funcionario5, funcionario6);
        Map<String, List<Funcionario>> funcoesMap = Rh.geraMapDasFuncoes(funcionarios);

        assertEquals(7, funcoesMap.size());
        assertEquals(2, funcoesMap.get("Gerente").size());
        assertEquals(1, funcoesMap.get("Diretor").size());
        assertEquals(0, funcoesMap.get("Operador").size());
    }

    @Test
    public void testAniversariantesOutubroEDezembro() {
        List<Funcionario> funcionarios = Arrays.asList(funcionario1, funcionario2, funcionario3, funcionario4, funcionario5, funcionario6);
        Rh.aniversariantesOutubroEDezembro(funcionarios);

    }

    @Test
    public void testTodosOsFuncionariosEmOrdemAlfabetica() {
        List<Funcionario> funcionarios = Arrays.asList(funcionario1, funcionario2, funcionario3, funcionario4, funcionario5, funcionario6);
        Rh.todosOsFuncionariosEmOrdemAlfabetica(funcionarios);
    }

    @Test
    public void testImprimeFuncionarioMaisVelho() {
        List<Funcionario> funcionarios = Arrays.asList(funcionario1, funcionario2, funcionario3, funcionario4, funcionario5, funcionario6);
        Rh.imprimeFuncionarioMaisVelho(funcionarios);
    }
}
