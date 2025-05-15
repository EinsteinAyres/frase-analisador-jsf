package util;

import br.com.contador.util.TextoUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TextoUtilsTest {

    @Test
    void deveExtrairPalavrasSimplesComSucesso() {
        String frase = "Java é top!";
        List<String> palavras = TextoUtils.extrairPalavras(frase);

        assertThat(palavras)
                .containsExactly("java", "e", "top");
    }

    @Test
    void deveRemoverPontuacaoEAcentos() {
        String frase = "Olá, você viu o João? Ele está com o cão.";
        List<String> palavras = TextoUtils.extrairPalavras(frase);

        assertThat(palavras)
                .containsExactly("ola", "voce", "viu", "o", "joao", "ele", "esta", "com", "o", "cao");
    }

    @Test
    void deveTratarFraseComEspacosExtras() {
        String frase = "   Testando     espaços     em branco.  ";
        List<String> palavras = TextoUtils.extrairPalavras(frase);

        assertThat(palavras)
                .containsExactly("testando", "espacos", "em", "branco");
    }

    @Test
    void deveRetornarListaVaziaParaStringVaziaOuNula() {
        assertThat(TextoUtils.extrairPalavras("")).isEmpty();
        assertThat(TextoUtils.extrairPalavras("     ")).isEmpty();
        assertThat(TextoUtils.extrairPalavras(null)).isEmpty();
    }

    @Test
    void deveManterNumerosNaFrase() {
        String frase = "123 teste com 456 e número 789";
        List<String> palavras = TextoUtils.extrairPalavras(frase);

        assertThat(palavras)
                .containsExactly("123", "teste", "com", "456", "e", "numero", "789");
    }
}
