package empresas;

import org.example.atores.Funcionario;
import org.example.empresa.Administrativo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdministrativoTest {

    private Funcionario funcionario1;
    private Funcionario funcionario2;
    private Funcionario funcionario3;

    @BeforeEach
    public void setUp() {
        funcionario1 = new Funcionario("João", LocalDate.of(1990,
                1, 1), "Desenvolvedor", new BigDecimal("3150.00"));
        funcionario2 = new Funcionario("Maria", LocalDate.of(1985,
                5, 20), "Gerente", new BigDecimal("4250.00"));
        funcionario3 = new Funcionario("Ana", LocalDate.of(1992,
                8, 10), "Analista", new BigDecimal("2600.00"));
    }

    @Test
    public void testAumentarSalarioEmPorcentagem() {
        // Aumento de 10% para o funcionário1
        Administrativo.aumentarSalarioEmPorcentagem(funcionario1, 10);
        assertEquals(new BigDecimal("3465.00"), funcionario1.getSalario());

        // Aumento de 20% para o funcionário2
        Administrativo.aumentarSalarioEmPorcentagem(funcionario2, 20);
        assertEquals(new BigDecimal("5100.00"), funcionario2.getSalario());

        // Aumento de 50% para o funcionário3
        Administrativo.aumentarSalarioEmPorcentagem(funcionario3, 50);
        assertEquals(new BigDecimal("3900.00"), funcionario3.getSalario());
    }

    @Test
    public void testTotalSalarioDosFuncionarios() {
        List<Funcionario> funcionarios = Arrays.asList(funcionario1, funcionario2, funcionario3);

        BigDecimal totalSalarios = Administrativo.totalSlarioDosFuncionarios(funcionarios);
        assertEquals(new BigDecimal("10000.00"), totalSalarios);
    }
}
