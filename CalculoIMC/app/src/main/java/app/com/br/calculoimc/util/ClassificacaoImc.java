package app.com.br.calculoimc.util;

/**
 * Created by Andre on 16/06/2016.
 */
public class ClassificacaoImc {

    private String tipo;

    public String classificaImc(double resultado){

        if(resultado < 16){
            tipo = "Magreza Grau III";
        }else if(resultado >= 16 && resultado <= 16.9){
            tipo = "Magreza Grau II";
        }else if(resultado >= 17 && resultado <= 18.49) {
            tipo = "Magreza Grau I";
        }else if(resultado >= 18.5 && resultado <= 24.9){
            tipo = "Eutrofia";
        }else if(resultado >= 25 && resultado <= 29.9){
            tipo = "Sobrepeso";
        }else if(resultado >= 30 && resultado <= 34.9){
            tipo = "Obesidade Grau I";
        }else if(resultado >= 35 && resultado <= 39.9){
            tipo = "Obesidade Grau II";
        }else if(resultado >= 40){
            tipo = "Obesidade Grau III";
        }
        return tipo;
    }

}
