package app.com.br.calculoimc.util;

import app.com.br.calculoimc.R;

/**
 * Created by Andre on 16/06/2016.
 */
public class ClassificacaoRcq {

    private String tipo;
    private String cor;
    private String frase;

    public String classificaRcq(double resultado, Sexo sexo){
        switch (sexo){
            case MASCULINO:
                    if(resultado >= 0.01 && resultado <= 0.85){
                        tipo = String.format(String.valueOf(R.string.claBaixo));
                        this.frase = String.format(String.valueOf(R.string.RcqBaixo));
                        this.cor = "#54d9e5";
                    }else if(resultado > 0.85 && resultado < 0.90){
                        tipo = String.format(String.valueOf(R.string.claModerado));
                        this.frase = String.format(String.valueOf(R.string.RcqModerado));
                        this.cor = "#15f765";
                    }else if(resultado >= 0.90) {
                        tipo = String.format(String.valueOf(R.string.claAlto));
                        this.frase = String.format(String.valueOf(R.string.RcqAlto));
                        this.cor = "#ff0000";
                    }else {
                        tipo = String.format(String.valueOf(R.string.claValorInvalido));
                        this.frase = String.format(String.valueOf(R.string.valoresInv));
                        this.cor = "#000000";
                    }
                break;
            case FEMININO:
                    if(resultado >= 0.01 && resultado <= 0.80){
                        tipo = String.format(String.valueOf(R.string.claBaixo));
                        this.frase = String.format(String.valueOf(R.string.RcqBaixo));
                        this.cor = "#54d9e5";
                    }else if(resultado > 0.80 && resultado < 0.85){
                        tipo = String.format(String.valueOf(R.string.claModerado));
                        this.frase = String.format(String.valueOf(R.string.RcqModerado));
                        this.cor = "#15f765";
                    }else if(resultado >= 0.85) {
                        tipo = String.format(String.valueOf(R.string.claAlto));
                        this.frase = String.format(String.valueOf(R.string.RcqAlto));
                        this.cor = "#ff0000";
                    }else{
                        tipo = String.format(String.valueOf(R.string.claValorInvalido));
                        this.frase = String.format(String.valueOf(R.string.valoresInv));
                        this.cor = "#000000";
                }
                break;
        }
        return tipo;
    }

    public String getCor() {
        return this.cor;
    }

    public String getFrase(){ return this.frase; }
}
