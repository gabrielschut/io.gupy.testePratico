package atores;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.atores.Funcionario;

public class FuncionarioTest {

        private Funcionario funcionario1;
        private Funcionario funcionario2;

        @BeforeEach
        public void setUp() {
            funcionario1 = new Funcionario("Ana Paula", LocalDate.of(1990,
                    1, 1), "Desenvolvedor", new BigDecimal("4830.00"));
            funcionario2 = new Funcionario("Ana Clara", LocalDate.of(1985,
                    5, 20), "Gerente", new BigDecimal("3000.00"));
        }

        @Test
        public void testAjusteSalario() {
            funcionario1.ajusteSalario(10); // 10% de aumento
            BigDecimal salarioEsperado = new BigDecimal("5313.00");
            assertEquals(salarioEsperado, funcionario1.getSalario());

            funcionario2.ajusteSalario(50); // 50% de aumento
            BigDecimal salarioEsperado2 = new BigDecimal("4500.00");
            assertEquals(salarioEsperado2, funcionario2.getSalario());
        }

        @Test
        public void testCompareTo() {
            Funcionario funcionario3 = new Funcionario("Ana Maria", LocalDate.of(1992,
                    8, 10), "Analista", new BigDecimal("2500.00"));
            Funcionario funcionario4 = new Funcionario("João", LocalDate.of(1992,
                    8, 10), "Analista", new BigDecimal("2500.00"));

            assertTrue(funcionario1.compareTo(funcionario2) > 0); // Ana Paula > Ana Clara
            assertTrue(funcionario2.compareTo(funcionario1) < 0); // Ana Clara < Ana Paula
            assertTrue(funcionario1.compareTo(funcionario1) == 0); // Ana Clara == Ana Clara
            assertTrue(funcionario3.compareTo(funcionario4) < 0); // Ana Maria < João
        }

    @Test
    public void testTotalDeSalariosMinimos() {
        assertEquals(new BigDecimal("3.99"), funcionario1.totalDeSlariosMinimos());
    }
}