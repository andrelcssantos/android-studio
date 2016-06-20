package app.com.br.calculoimc.entidade;

import java.io.Serializable;

import app.com.br.calculoimc.util.Sexo;

/**
 * Created by Andre on 30/05/2016.
 */
public class Rcq implements Serializable {

    private int idRcq;
    private double cintura;
    private double quadril;
    private int idade;
    private double resultado;
    private String tipo;
    private Sexo sexo;

    public int getIdRcq() {
        return idRcq;
    }

    public double getCintura() {
        return cintura;
    }

    public double getQuadril() {
        return quadril;
    }

    public int getIdade() {
        return idade;
    }

    public double getResultado() {
        return resultado;
    }

    public String getTipo() {
        return tipo;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setIdRcq(int idRcq) {
        this.idRcq = idRcq;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
