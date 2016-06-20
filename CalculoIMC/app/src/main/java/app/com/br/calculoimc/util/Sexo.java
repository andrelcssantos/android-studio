package app.com.br.calculoimc.util;

/**
 * Created by Andre on 20/06/2016.
 */
public enum Sexo {

    MASCULINO("Masculino"), FEMININO("Feminino");

    private Sexo(String descricao){
        this.descricao = descricao;
    }

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public static Sexo getSexo(int pos) {
        for (Sexo sexo : Sexo.values()) {
            if (sexo.ordinal() == pos) {
                return sexo;
            }
        }
        return null;
    }

}
