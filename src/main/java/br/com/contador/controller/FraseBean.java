package br.com.contador.controller;

import br.com.contador.model.Palavra;
import br.com.contador.service.AnalisadorFraseService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

@Named("fraseBean")
@RequestScoped
public class FraseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String frase;
    private Map<String, Integer> resultado;
    private Palavra maisFrequente;
    private int totalPalavras;

    @Inject
    private AnalisadorFraseService analisadorFraseService;

    public void analisar() {
        resultado = analisadorFraseService.contarPalavras(frase);
        maisFrequente = analisadorFraseService.encontrarMaisFrequente(resultado);
        totalPalavras = analisadorFraseService.contarTotalPalavras(resultado);
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public Map<String, Integer> getResultado() {
        return resultado;
    }

    public Palavra getMaisFrequente() {
        return maisFrequente;
    }

    public int getTotalPalavras() {
        return totalPalavras;
    }
}

