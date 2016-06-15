package app.com.br.calculoimc.entidade;

import java.io.Serializable;

/**
 * Created by Andre on 30/05/2016.
 */
public class Imc implements Serializable {

    private int idImc;
    private double peso;
    private double altura;
    private double resultado;

    public int getIdImc() {
        return idImc;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public double getResultado() {
        return resultado;
    }

    public void setIdImc(int idImc) {
        this.idImc = idImc;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Imc{" +
                "idImc=" + idImc +
                ", peso=" + peso +
                ", altura=" + altura +
                ", resultado=" + resultado +
                '}';
    }
}
