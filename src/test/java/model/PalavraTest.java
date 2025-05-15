package model;

import br.com.contador.model.Palavra;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PalavraTest {

    @Test
    void deveCriarObjetoComConstrutorCheio() {
        Palavra palavra = new Palavra("java", 3);

        assertThat(palavra.getTexto()).isEqualTo("java");
        assertThat(palavra.getQuantidade()).isEqualTo(3);
    }

    @Test
    void deveGerarToStringLegivel() {
        Palavra palavra = new Palavra("ee", 2);

        assertThat(palavra.toString()).isEqualTo("ee (2)");
    }

    @Test
    void deveConsiderarObjetosComMesmoTextoComoIguais() {
        Palavra p1 = new Palavra("java", 3);
        Palavra p2 = new Palavra("java", 1);

        assertThat(p1).isEqualTo(p2);
        assertThat(p1.hashCode()).isEqualTo(p2.hashCode());
    }

    @Test
    void devePermitirAlterarCamposComSetters() {
        Palavra palavra = new Palavra();
        palavra.setTexto("wildfly");
        palavra.setQuantidade(10);

        assertThat(palavra.getTexto()).isEqualTo("wildfly");
        assertThat(palavra.getQuantidade()).isEqualTo(10);
    }
}
