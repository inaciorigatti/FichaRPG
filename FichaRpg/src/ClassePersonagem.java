import java.io.Serializable;

public enum ClassePersonagem implements Serializable{
    ROCKERBOY("Rockerboy", 7, 6, 8, 5, 6, 5, 5, 5, 3),
    SOLO("Solo", 5, 8, 5, 9, 7, 7, 7, 8, 6),
    TECH("Tech", 9, 7, 8, 2, 6, 3, 7, 5, 1),
    INDEFINIDA("Indefinida", 0, 0, 0, 0, 0, 0, 0, 0, 0);

    public final String nome;
    public final int inteligencia, reflexos, destrezaTecnica, frieza,
            vontade, sorte, movimento, corpo, empatia;

    ClassePersonagem(String nome, int inteligencia, int reflexos, int destrezaTecnica,
                     int frieza, int vontade, int sorte, int movimento,
                     int corpo, int empatia) {
        this.nome = nome;
        this.inteligencia = inteligencia;
        this.reflexos = reflexos;
        this.destrezaTecnica = destrezaTecnica;
        this.frieza = frieza;
        this.vontade = vontade;
        this.sorte = sorte;
        this.movimento = movimento;
        this.corpo = corpo;
        this.empatia = empatia;
    }
}
