package controller;

import br.com.contador.controller.FraseBean;
import br.com.contador.model.Palavra;
import br.com.contador.service.AnalisadorFraseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FraseBeanTest {

    @InjectMocks
    private FraseBean bean;

    @Mock
    private AnalisadorFraseService analisadorFraseService;

    private Map<String, Integer> resultadoSimulado;

    @BeforeEach
    void setUp() {
        resultadoSimulado = new HashMap<>();
        resultadoSimulado.put("java", 2);
        resultadoSimulado.put("ee", 1);
    }

    @Test
    void devePreencherResultadoCorretamente() {
        String frase = "Java EE Java";

        when(analisadorFraseService.contarPalavras(frase)).thenReturn(resultadoSimulado);
        when(analisadorFraseService.encontrarMaisFrequente(resultadoSimulado)).thenReturn(new Palavra("java", 2));
        when(analisadorFraseService.contarTotalPalavras(resultadoSimulado)).thenReturn(3);

        bean.setFrase(frase);
        bean.analisar();

        assertThat(bean.getResultado())
                .isNotNull()
                .hasSize(2)
                .containsEntry("java", 2)
                .containsEntry("ee", 1);

        assertThat(bean.getMaisFrequente())
                .isNotNull()
                .extracting(Palavra::getTexto)
                .isEqualTo("java");

        assertThat(bean.getTotalPalavras()).isEqualTo(3);
    }

    @Test
    void deveRetornarResultadoVazioParaFraseNula() {
        bean.setFrase(null);
        when(analisadorFraseService.contarPalavras(null)).thenReturn(new HashMap<>());
        when(analisadorFraseService.encontrarMaisFrequente(new HashMap<>())).thenReturn(null);
        when(analisadorFraseService.contarTotalPalavras(new HashMap<>())).thenReturn(0);

        bean.analisar();

        assertThat(bean.getResultado()).isEmpty();
        assertThat(bean.getMaisFrequente()).isNull();
        assertThat(bean.getTotalPalavras()).isZero();
    }
}
