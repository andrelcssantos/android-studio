package app.com.br.calculoimc.util;

import app.com.br.calculoimc.R;

/**
 * Created by Andre on 16/06/2016.
 */
public class ClassificacaoImc {

    private String tipo;
    private String frase;
    private String cor;

    public String classificaImc(double resultado){

        if(resultado < 16){
            tipo = String.format(String.valueOf(R.string.claMagreza3));
            this.frase = String.format(String.valueOf(R.string.fraMuitoBaixo));
            this.cor = "#FF0000";
        }else if(resultado >= 16 && resultado <= 16.99){
            tipo = String.format(String.valueOf(R.string.claMagreza2));
            this.frase = String.format(String.valueOf(R.string.fraPoucoBaixo));
            this.cor = "#FF4500";
        }else if(resultado >= 17 && resultado <= 18.49) {
            tipo = String.format(String.valueOf(R.string.claMagreza1));
            this.frase = String.format(String.valueOf(R.string.fraBaixo));
            this.cor = "#FFA500";
        }else if(resultado >= 18.5 && resultado <= 24.99){
            tipo = String.format(String.valueOf(R.string.claEutrofia));
            this.frase = String.format(String.valueOf(R.string.fraIdeal));
            this.cor = "#32CD32";
        }else if(resultado >= 25 && resultado <= 29.99){
            tipo = String.format(String.valueOf(R.string.claSobrepeso));
            this.frase = String.format(String.valueOf(R.string.fraSobre));
            this.cor = "#CD0000";
        }else if(resultado >= 30 && resultado <= 34.99){
            tipo = String.format(String.valueOf(R.string.claObesidade1));
            this.cor = "#FFA500";
        }else if(resultado >= 35 && resultado <= 39.99){
            tipo = String.format(String.valueOf(R.string.claObesidade2));
            this.cor = "#FF4500";
        }else if(resultado >= 40){
            tipo = String.format(String.valueOf(R.string.claObesidade3));
            this.frase = String.format(String.valueOf(R.string.fraMuiAlto));
            this.cor = "#FF0000";
        }else{
            tipo = String.format(String.valueOf(R.string.claValorInvalido));
            this.cor = "#000000";
        }
        return tipo;
    }

    public String getCor() {
        return this.cor;
    }

    public String getFrase() {
        return this.frase;
    }

}
