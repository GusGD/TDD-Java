package ServiceTest;

import br.com.tdd.modelo.Funcionario;
import br.com.tdd.service.BonusService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

  @Test
  void bonusDeveriaSerZeroParaFuncionarioComSalarioMaiorQueMil(){
    BonusService service = new BonusService();
    assertThrows( IllegalArgumentException.class,
      () -> service.calcularBonus(new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("25000"))));
  }

  @Test
  void bonusDeveriaSerDezPorCentoSalario(){
    BonusService service = new BonusService();
    BigDecimal bonus = service.calcularBonus(new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("2500")));
    assertEquals(new BigDecimal("250.00"), bonus);
  }

  @Test
  void bonusDeveriaSerDezPorCentoExatamentoSalarioDezMil(){
    BonusService service = new BonusService();
    BigDecimal bonus = service.calcularBonus(new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("10000")));
    assertEquals(new BigDecimal("1000.00"), bonus);
  }
}
