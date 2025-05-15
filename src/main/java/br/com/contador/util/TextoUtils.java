package br.com.contador.util;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TextoUtils {

    private TextoUtils() {}

    public static List<String> extrairPalavras(String frase) {
        if (frase == null || frase.trim().isEmpty()) {
            return Collections.emptyList();
        }

        String textoLimpo = frase.toLowerCase()
                .replaceAll("[^\\p{L}\\p{Nd}\\s]+", "")
                .replaceAll("\\s+", " ")
                .trim();

        textoLimpo = Normalizer.normalize(textoLimpo, Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

        String[] palavras = textoLimpo.split(" ");
        List<String> lista = new ArrayList<>();
        for (String p : palavras) {
            if (!p.isEmpty()) {
                lista.add(p);
            }
        }

        return lista;
    }
}
