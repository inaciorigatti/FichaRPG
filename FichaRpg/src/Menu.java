import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private Map<String, Personagem> personagens;
    private Scanner scanner;

    public Menu() {
        this.personagens = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int escolha = -1;

        do {
            System.out.println("\n-= Cyberpunk Red =-\n");
            System.out.println("1. Criar personagem");
            System.out.println("2. Deletar personagem");
            System.out.println("3. Listar personagens");
            System.out.println("0. Sair\n");
            System.out.print("Escolha uma opção: ");

            try {
                String input = scanner.nextLine();
                if (input.trim().isEmpty()) {
                    System.out.println("Entrada não pode ser vazia. Tente novamente.");
                    escolha = -1;
                    continue;
                }
                escolha = Integer.parseInt(input);

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                escolha = -1;
            }

            if (escolha < 0 || escolha > 3) {
                if (escolha != -1) {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }

        } while (escolha < 0 || escolha > 3);

        switch (escolha) {
            case 0:
                System.out.println("Saindo do programa...");
                scanner.close();
                System.exit(0);
                break;

            case 1:
                criarPersonagem();
                break;

            case 2:
                System.out.println("Funcionalidade 'Deletar personagem' ainda não implementada.");
                mostrarMenu();
                break;

            case 3:
                // Chama o método estático da classe VisualizadorPersonagens
                ImprimirPersonagens.exibirListaDePersonagens(this.personagens);
                mostrarMenu(); // Volta ao menu
                break;
        }
    }

    private void criarPersonagem() {
        // Chama o método estático da classe Personagem para lidar com a criação
        Personagem novoPersonagem = Personagem.criarNovoPersonagemComEntradaDoUsuario(this.scanner);
        personagens.put(novoPersonagem.getNome(), novoPersonagem);

        System.out.println("\nPersonagem \"" + novoPersonagem.getNome() + "\" criado com sucesso!");

        mostrarMenu();
    }

}