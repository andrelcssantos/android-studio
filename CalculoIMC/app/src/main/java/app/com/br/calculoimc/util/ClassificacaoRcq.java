package app.com.br.calculoimc.util;

import app.com.br.calculoimc.fragments.FragmentCalculaRCQ;

/**
 * Created by Andre on 16/06/2016.
 */
public class ClassificacaoRcq {

    private String tipo;

    public ClassificacaoRcq(FragmentCalculaRCQ fragmentCalculaRCQ){

    }

    public String classificaRcq(double resultado, int idade, Sexo sexo){ //TODO parei aqui.. preciso arrumar o strings.xml para a variável tipo desta classe

        switch (sexo){
            case MASCULINO:
                    if(idade == 29){
                        if(resultado <= 0.83){
                            tipo = "BAIXO";
                        }else if(resultado > 0.83 && resultado <= 0.88){
                            tipo = "MODERADO";
                        }else if(resultado >= 0.89 && resultado < 0.94) {
                            tipo = "ALTO";
                        }else if(resultado >= 0.94) {
                            tipo = "MUITO ALTO";
                        }
                    }else if(idade >= 30 && idade <= 39){
                        if(resultado <= 0.84){
                            tipo = "BAIXO";
                        }else if(resultado > 0.84 && resultado <= 0.91){
                            tipo = "MODERADO";
                        }else if(resultado >= 0.92 && resultado < 0.96) {
                            tipo = "ALTO";
                        }else if(resultado >= 0.96) {
                            tipo = "MUITO ALTO";
                        }
                    }else if(idade >= 40 && idade <= 49) {
                        if (resultado <= 0.88) {
                            tipo = "BAIXO";
                        } else if (resultado > 0.88 && resultado <= 0.95) {
                            tipo = "MODERADO";
                        } else if (resultado >= 0.96 && resultado < 1) {
                            tipo = "ALTO";
                        } else if (resultado >= 1) {
                            tipo = "MUITO ALTO";
                        }
                    }else if(idade >= 50 && idade <= 59) {
                        if (resultado <= 0.90) {
                            tipo = "BAIXO";
                        } else if (resultado > 0.90 && resultado <= 0.96) {
                            tipo = "MODERADO";
                        } else if (resultado >= 0.97 && resultado < 1.02) {
                            tipo = "ALTO";
                        } else if (resultado >= 1.02) {
                            tipo = "MUITO ALTO";
                        }
                    }else if(idade > 59) {
                        if (resultado <= 0.91) {
                            tipo = "BAIXO";
                        } else if (resultado > 0.91 && resultado <= 0.98) {
                            tipo = "MODERADO";
                        } else if (resultado >= 0.99 && resultado < 1.03) {
                            tipo = "ALTO";
                        } else if (resultado >= 1.03) {
                            tipo = "MUITO ALTO";
                        }
                    }
                break;
            case FEMININO:
                if(idade == 29){
                    if(resultado <= 0.71){
                        tipo = "BAIXO";
                    }else if(resultado > 0.71 && resultado <= 0.77){
                        tipo = "MODERADO";
                    }else if(resultado >= 0.78 && resultado < 0.82) {
                        tipo = "ALTO";
                    }else if(resultado >= 0.82) {
                        tipo = "MUITO ALTO";
                    }
                }else if(idade >= 30 && idade <= 39){
                    if(resultado <= 0.72){
                        tipo = "BAIXO";
                    }else if(resultado > 0.72 && resultado <= 0.78){
                        tipo = "MODERADO";
                    }else if(resultado >= 0.79 && resultado < 0.84) {
                        tipo = "ALTO";
                    }else if(resultado >= 0.84) {
                        tipo = "MUITO ALTO";
                    }
                }else if(idade >= 40 && idade <= 49) {
                    if (resultado <= 0.73) {
                        tipo = "BAIXO";
                    } else if (resultado > 0.73 && resultado <= 0.79) {
                        tipo = "MODERADO";
                    } else if (resultado >= 0.80 && resultado < 0.87) {
                        tipo = "ALTO";
                    } else if (resultado >= 87) {
                        tipo = "MUITO ALTO";
                    }
                }else if(idade >= 50 && idade <= 59) {
                    if (resultado <= 0.74) {
                        tipo = "BAIXO";
                    } else if (resultado > 0.74 && resultado <= 0.81) {
                        tipo = "MODERADO";
                    } else if (resultado >= 0.82 && resultado < 0.88) {
                        tipo = "ALTO";
                    } else if (resultado >= 0.88) {
                        tipo = "MUITO ALTO";
                    }
                }else if(idade > 59) {
                    if (resultado <= 0.76) {
                        tipo = "BAIXO";
                    } else if (resultado > 0.76 && resultado <= 0.83) {
                        tipo = "MODERADO";
                    } else if (resultado >= 0.84 && resultado < 0.90) {
                        tipo = "ALTO";
                    } else if (resultado >= 0.90) {
                        tipo = "MUITO ALTO";
                    }
                }
                break;
        }
        return tipo;
    }
}
