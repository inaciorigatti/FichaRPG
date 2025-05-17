import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SalvarPersonagens {
    private static final String ARQUIVO_PERSONAGENS = "personagens.dat";

    public static void salvar(Map<String, Personagem> personagens) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_PERSONAGENS))) {
            oos.writeObject(personagens);
            System.out.println("Personagens salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar personagens: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Personagem> carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_PERSONAGENS))) {
            return (Map<String, Personagem>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Arquivo não existe ainda (primeira execução)
            return new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar personagens: " + e.getMessage());
            return new HashMap<>();
        }
    }
}