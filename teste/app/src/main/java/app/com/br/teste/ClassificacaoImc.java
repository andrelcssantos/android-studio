package app.com.br.teste;

/**
 * Created by Andre on 16/06/2016.
 */
public class ClassificacaoImc {

    private String tipo;
    public String cor;

    public String classificaImc(double resultado){

        if(resultado < 16){
            tipo = String.format(String.valueOf(R.string.claMagreza3));
            cor = String.format(String.valueOf(R.string.corMagrezaI));
        }else if(resultado >= 16 && resultado <= 16.9){
            tipo = String.format(String.valueOf(R.string.claMagreza2));
        }else if(resultado >= 17 && resultado <= 18.49) {
            tipo = String.format(String.valueOf(R.string.claMagreza1));
        }else if(resultado >= 18.5 && resultado <= 24.9){
            tipo = String.format(String.valueOf(R.string.claEutrofia));
        }else if(resultado >= 25 && resultado <= 29.9){
            tipo = String.format(String.valueOf(R.string.claSobrepeso));
        }else if(resultado >= 30 && resultado <= 34.9){
            tipo = String.format(String.valueOf(R.string.claObesidade1));
        }else if(resultado >= 35 && resultado <= 39.9){
            tipo = String.format(String.valueOf(R.string.claObesidade2));
        }else if(resultado >= 40){
            tipo = String.format(String.valueOf(R.string.claObesidade3));
        }else{
            tipo = String.format(String.valueOf(R.string.claValorInvalido));
        }
        return tipo;
    }

    public String getCor() {
        return cor;
    }

}
