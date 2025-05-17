import java.io.Serializable;

public enum Arma implements Serializable {
    PISTOLA_PESADA("Pistola Pesada"),
    RIFLE_ASSALTO("Rifle de Assalto"),
    FACA_COMBATE("Faca de Combate"),
    ESPINGARDA("Espingarda"),
    SMG("SMG"),
    ESPADA("Espada"),
    RIFLE("Rifle"),
    SNIPER("Sniper"),
    LANCA_CHAMAS("Lança-chamas"),
    DESARMADO("Desarmado");

    public final String nome;

    Arma(String nome) {
        this.nome = nome;
    }
}
