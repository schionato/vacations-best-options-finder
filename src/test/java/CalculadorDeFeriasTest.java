import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculadorDeFeriasTest {

    @Test
    public void verificaMelhorPeriodo() {
        Dia dataInicial = new Dia("01/01/2018");
        Dia dataFinal = new Dia("31/01/2018");

        Periodo periodoASerAnalisado = new Periodo(dataInicial, dataFinal);

        List<Ferias> periodo = new CalculadorDeFerias(10, periodoASerAnalisado)
                .calcula()
                .getMelhoresPeriodos();

        assertEquals(10, periodo.size());
        assertEquals(8, periodo.get(0).getQuantidadeDeDiasUteis());
        assertEquals(8, periodo.get(1).getQuantidadeDeDiasUteis());
    }

    @Test
    public void adicionaFinalDeSemanaNoPeriodo() {
        Dia segundaFeira = new Dia("01/01/2018");
        Dia outraSegunda = new Dia("08/01/2018");

        Periodo periodoASerAnalisado = new Periodo(segundaFeira, outraSegunda);

        List<Ferias> ferias = new CalculadorDeFerias(5, periodoASerAnalisado)
                .calcula()
                .getMelhoresPeriodos();

        assertEquals(7, ferias.get(0).size());
    }

}