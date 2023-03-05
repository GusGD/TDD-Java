package ServiceTest;

import br.com.tdd.modelo.Desempenho;
import br.com.tdd.modelo.Funcionario;
import br.com.tdd.service.ReajusteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

  private ReajusteService service;
  private Funcionario funcionario;

  @BeforeEach
  public void inicializar (){
    this.service = new ReajusteService();
    this.funcionario = new Funcionario("Gustavo", LocalDate.now(),new BigDecimal("1000.00"));
  }
  @Test
  public void reajusteDeveriaSerDeTresPorcenttoComDesempenhoADesejar(){
    service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
    assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
  }

  @Test
  public void reajusteDeveriaSerDeQuinzePorcenttoComDesempenhoBom(){
    service.concederReajuste(funcionario, Desempenho.BOM);
    assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
  }
  @Test
  public void reajusteDeveriaSerDeVintePorcenttoComDesempenhoOtimo(){
    service.concederReajuste(funcionario, Desempenho.OTIMO);
    assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
  }
}
