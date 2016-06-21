package app.com.br.calculoimc.util;

import app.com.br.calculoimc.R;

/**
 * Created by Andre on 16/06/2016.
 */
public class ClassificacaoRcq {

    private String tipo;
    private String cor;
    private String frase;

    public String classificaRcq(double resultado, int idade, Sexo sexo){
        switch (sexo){
            case MASCULINO:
                    if(idade == 29){
                        if(resultado <= 0.83){
                            tipo = String.format(String.valueOf(R.string.claBaixo));
                            this.frase = "";//TODO verificar e criar as frases do RCQ
                            this.cor = "#FFA500";
                        }else if(resultado > 0.83 && resultado <= 0.88){
                            tipo = String.format(String.valueOf(R.string.claModerado));
                            this.cor = "#00FF00";
                        }else if(resultado >= 0.89 && resultado < 0.94) {
                            tipo = String.format(String.valueOf(R.string.claAlto));
                            this.cor = "#FF4500";
                        }else if(resultado >= 0.94) {
                            tipo = String.format(String.valueOf(R.string.claMuitoAlto));
                            this.cor = "#FF0000";
                        }else{
                            tipo = String.format(String.valueOf(R.string.claValorInvalido));
                            this.cor = "#000000";
                        }
                    }else if(idade >= 30 && idade <= 39){
                        if(resultado <= 0.84){
                            tipo = String.format(String.valueOf(R.string.claBaixo));
                            this.cor = "#FFA500";
                        }else if(resultado > 0.84 && resultado <= 0.91){
                            tipo = String.format(String.valueOf(R.string.claModerado));
                            this.cor = "#00FF00";
                        }else if(resultado >= 0.92 && resultado < 0.96) {
                            tipo = String.format(String.valueOf(R.string.claAlto));
                            this.cor = "#FF4500";
                        }else if(resultado >= 0.96) {
                            tipo = String.format(String.valueOf(R.string.claMuitoAlto));
                            this.cor = "#FF0000";
                        }else{
                            tipo = String.format(String.valueOf(R.string.claValorInvalido));
                            this.cor = "#000000";
                        }
                    }else if(idade >= 40 && idade <= 49) {
                        if (resultado <= 0.88) {
                            tipo = String.format(String.valueOf(R.string.claBaixo));
                            this.cor = "#FFA500";
                        } else if (resultado > 0.88 && resultado <= 0.95) {
                            tipo = String.format(String.valueOf(R.string.claModerado));
                            this.cor = "#00FF00";
                        } else if (resultado >= 0.96 && resultado < 1) {
                            tipo = String.format(String.valueOf(R.string.claAlto));
                            this.cor = "#FF4500";
                        } else if (resultado >= 1) {
                            tipo = String.format(String.valueOf(R.string.claMuitoAlto));
                            this.cor = "#FF0000";
                        }else{
                            tipo = String.format(String.valueOf(R.string.claValorInvalido));
                            this.cor = "#000000";
                        }
                    }else if(idade >= 50 && idade <= 59) {
                        if (resultado <= 0.90) {
                            tipo = String.format(String.valueOf(R.string.claBaixo));
                            this.cor = "#FFA500";
                        } else if (resultado > 0.90 && resultado <= 0.96) {
                            tipo = String.format(String.valueOf(R.string.claModerado));
                            this.cor = "#00FF00";
                        } else if (resultado >= 0.97 && resultado < 1.02) {
                            tipo = String.format(String.valueOf(R.string.claAlto));
                            this.cor = "#FF4500";
                        } else if (resultado >= 1.02) {
                            tipo = String.format(String.valueOf(R.string.claMuitoAlto));
                            this.cor = "#FF0000";
                        }else{
                            tipo = String.format(String.valueOf(R.string.claValorInvalido));
                            this.cor = "#000000";
                        }
                    }else if(idade > 59) {
                        if (resultado <= 0.91) {
                            tipo = String.format(String.valueOf(R.string.claBaixo));
                            this.cor = "#FFA500";
                        } else if (resultado > 0.91 && resultado <= 0.98) {
                            tipo = String.format(String.valueOf(R.string.claModerado));
                            this.cor = "#00FF00";
                        } else if (resultado >= 0.99 && resultado < 1.03) {
                            tipo = String.format(String.valueOf(R.string.claAlto));
                            this.cor = "#FF4500";
                        } else if (resultado >= 1.03) {
                            tipo = String.format(String.valueOf(R.string.claMuitoAlto));
                            this.cor = "#FF0000";
                        }else{
                            tipo = String.format(String.valueOf(R.string.claValorInvalido));
                            this.cor = "#000000";
                        }
                    }else {
                        tipo = String.format(String.valueOf(R.string.claIdadeInvalido));
                        this.cor = "#000000";
                    }
                break;
            case FEMININO:
                if(idade == 29){
                    if(resultado <= 0.71){
                        tipo = String.format(String.valueOf(R.string.claBaixo));
                        this.cor = "#FFA500";
                    }else if(resultado > 0.71 && resultado <= 0.77){
                        tipo = String.format(String.valueOf(R.string.claModerado));
                        this.cor = "#00FF00";
                    }else if(resultado >= 0.78 && resultado < 0.82) {
                        tipo = String.format(String.valueOf(R.string.claAlto));
                        this.cor = "#FF4500";
                    }else if(resultado >= 0.82) {
                        tipo = String.format(String.valueOf(R.string.claMuitoAlto));
                        this.cor = "#FF0000";
                    }else{
                        tipo = String.format(String.valueOf(R.string.claValorInvalido));
                        this.cor = "#000000";
                    }
                }else if(idade >= 30 && idade <= 39){
                    if(resultado <= 0.72){
                        tipo = String.format(String.valueOf(R.string.claBaixo));
                        this.cor = "#FFA500";
                    }else if(resultado > 0.72 && resultado <= 0.78){
                        tipo = String.format(String.valueOf(R.string.claModerado));
                        this.cor = "#00FF00";
                    }else if(resultado >= 0.79 && resultado < 0.84) {
                        tipo = String.format(String.valueOf(R.string.claAlto));
                        this.cor = "#FF4500";
                    }else if(resultado >= 0.84) {
                        tipo = String.format(String.valueOf(R.string.claMuitoAlto));
                        this.cor = "#FF0000";
                    }else{
                        tipo = String.format(String.valueOf(R.string.claValorInvalido));
                        this.cor = "#000000";
                    }
                }else if(idade >= 40 && idade <= 49) {
                    if (resultado <= 0.73) {
                        tipo = String.format(String.valueOf(R.string.claBaixo));
                        this.cor = "#FFA500";
                    } else if (resultado > 0.73 && resultado <= 0.79) {
                        tipo = String.format(String.valueOf(R.string.claModerado));
                        this.cor = "#00FF00";
                    } else if (resultado >= 0.80 && resultado < 0.87) {
                        tipo = String.format(String.valueOf(R.string.claAlto));
                        this.cor = "#FF4500";
                    } else if (resultado >= 87) {
                        tipo = String.format(String.valueOf(R.string.claMuitoAlto));
                        this.cor = "#FF0000";
                    }else{
                        tipo = String.format(String.valueOf(R.string.claValorInvalido));
                        this.cor = "#000000";
                    }
                }else if(idade >= 50 && idade <= 59) {
                    if (resultado <= 0.74) {
                        tipo = String.format(String.valueOf(R.string.claBaixo));
                        this.cor = "#FFA500";
                    } else if (resultado > 0.74 && resultado <= 0.81) {
                        tipo = String.format(String.valueOf(R.string.claModerado));
                        this.cor = "#00FF00";
                    } else if (resultado >= 0.82 && resultado < 0.88) {
                        tipo = String.format(String.valueOf(R.string.claAlto));
                        this.cor = "#FF4500";
                    } else if (resultado >= 0.88) {
                        tipo = String.format(String.valueOf(R.string.claMuitoAlto));
                        this.cor = "#FF0000";
                    }else{
                        tipo = String.format(String.valueOf(R.string.claValorInvalido));
                        this.cor = "#000000";
                    }
                }else if(idade > 59) {
                    if (resultado <= 0.76) {
                        tipo = String.format(String.valueOf(R.string.claBaixo));
                        this.cor = "#FFA500";
                    } else if (resultado > 0.76 && resultado <= 0.83) {
                        tipo = String.format(String.valueOf(R.string.claModerado));
                        this.cor = "#00FF00";
                    } else if (resultado >= 0.84 && resultado < 0.90) {
                        tipo = String.format(String.valueOf(R.string.claAlto));
                        this.cor = "#FF4500";
                    } else if (resultado >= 0.90) {
                        tipo = String.format(String.valueOf(R.string.claMuitoAlto));
                        this.cor = "#FF0000";
                    }else{
                        tipo = String.format(String.valueOf(R.string.claValorInvalido));
                        this.cor = "#000000";
                    }
                }else {
                    tipo = String.format(String.valueOf(R.string.claIdadeInvalido));
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
