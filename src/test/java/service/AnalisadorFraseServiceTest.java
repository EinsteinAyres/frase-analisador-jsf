package service;

import br.com.contador.model.Palavra;
import br.com.contador.service.AnalisadorFraseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class AnalisadorFraseServiceTest {

    private AnalisadorFraseService service;

    @BeforeEach
    void setUp() {
        service = new AnalisadorFraseService();
    }

    @Test
    void deveContarPalavrasComSucesso() {
        String frase = "Java EE Java CDI JSF JSF JSF";

        Map<String, Integer> resultado = service.contarPalavras(frase);

        assertThat(resultado)
                .isNotNull()
                .hasSize(4)
                .containsEntry("java", 2)
                .containsEntry("ee", 1)
                .containsEntry("cdi", 1)
                .containsEntry("jsf", 3);
    }

    @Test
    void deveRetornarPalavraMaisFrequente() {
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("java", 2);
        mapa.put("jsf", 5);
        mapa.put("cdi", 3);

        Palavra frequente = service.encontrarMaisFrequente(mapa);

        assertThat(frequente).isNotNull();
        assertThat(frequente.getTexto()).isEqualTo("jsf");
        assertThat(frequente.getQuantidade()).isEqualTo(5);
    }

    @Test
    void deveRetornarTotalCorretoDePalavras() {
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("java", 2);
        mapa.put("jsf", 3);

        int total = service.contarTotalPalavras(mapa);

        assertThat(total).isEqualTo(5);
    }

    @Test
    void deveRetornarNuloParaMaisFrequenteEmMapaVazio() {
        Palavra frequente = service.encontrarMaisFrequente(null);
        assertThat(frequente).isNull();

        frequente = service.encontrarMaisFrequente(new HashMap<>());
        assertThat(frequente).isNull();
    }

    @Test
    void deveRetornarZeroSeMapaVazio() {
        int total = service.contarTotalPalavras(null);
        assertThat(total).isZero();

        total = service.contarTotalPalavras(new HashMap<>());
        assertThat(total).isZero();
    }
}
