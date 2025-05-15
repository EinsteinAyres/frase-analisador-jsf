package br.com.contador.model;

import java.io.Serializable;
import java.util.Objects;

public class Palavra implements Serializable {

    private static final long serialVersionUID = 1L;

    private String texto;
    private Integer quantidade;

    public Palavra() {}

    public Palavra(String texto, Integer quantidade) {
        this.texto = texto;
        this.quantidade = quantidade;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Palavra)) return false;
        Palavra palavra = (Palavra) o;
        return Objects.equals(texto, palavra.texto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(texto);
    }

    @Override
    public String toString() {
        return texto + " (" + quantidade + ")";
    }
}
