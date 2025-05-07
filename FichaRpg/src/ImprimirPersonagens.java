import java.util.Map;

public class ImprimirPersonagens {

    public static void exibirListaDePersonagens(Map<String, Personagem> personagens) {
        System.out.println("\n--- Lista de Personagens Criados ---");

        if (personagens == null || personagens.isEmpty()) {
            System.out.println("Nenhum personagem foi criado ainda.");
        } else {
            int contador = 1;
            for (Personagem p : personagens.values()) {
                System.out.println("\n--- Personagem " + contador + " ---");
                // Vamos usar o método toString() da classe Personagem que já está formatado
                System.out.println(p.toString());
                contador++;
            }
        }
        System.out.println("------------------------------------");
    }

}