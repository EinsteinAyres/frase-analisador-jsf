package br.com.teste.service;

import br.com.teste.model.Palavra;
import br.com.teste.util.TextoUtils;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class AnalisadorFraseService {

    public Map<String, Integer> contarPalavras(String frase) {
        List<String> palavras = TextoUtils.extrairPalavras(frase);
        Map<String, Integer> contagem = new TreeMap<>();

        for (String palavra : palavras) {
            contagem.put(palavra, contagem.getOrDefault(palavra, 0) + 1);
        }
        return contagem;
    }

    public Palavra encontrarMaisFrequente(Map<String, Integer> mapa) {
        if (mapa == null || mapa.isEmpty()) return null;

        Map.Entry<String, Integer> entradaMax = null;

        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            if (entradaMax == null || entry.getValue() > entradaMax.getValue()) {
                entradaMax = entry;
            }
        }
        return new Palavra(entradaMax.getKey(), entradaMax.getValue());
    }

    public int contarTotalPalavras(Map<String, Integer> mapa) {
        if (mapa == null || mapa.isEmpty()) return 0;
        int total = 0;
        for (Integer count : mapa.values()) {
            total += count;
        }
        return total;
    }
}
