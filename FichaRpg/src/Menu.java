import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Map<String, Personagem> personagens;
    private Scanner scanner;

    public Menu() {
        this.personagens = SalvarPersonagens.carregar();
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
                SalvarPersonagens.salvar(personagens); // Salva antes de sair
                scanner.close();
                System.exit(0);
                break;

            case 1:
                criarPersonagem();
                break;

            case 2:
                deletarPersonagem();
                break;

            case 3:
                ImprimirPersonagens.exibirListaDePersonagens(this.personagens);
                mostrarMenu();
                break;
        }
    }

    private void criarPersonagem() {
        Personagem novoPersonagem = Personagem.criarNovoPersonagemComEntradaDoUsuario(this.scanner);
        personagens.put(novoPersonagem.getNome(), novoPersonagem);
        SalvarPersonagens.salvar(personagens);

        System.out.println("\nPersonagem \"" + novoPersonagem.getNome() + "\" criado com sucesso!");
        mostrarMenu();
    }

    private void deletarPersonagem() {
        if (personagens.isEmpty()) {
            System.out.println("Não há personagens para deletar.");
            mostrarMenu();
            return;
        }

        ImprimirPersonagens.exibirListaDePersonagens(this.personagens);
        System.out.print("\nDigite o nome do personagem a ser deletado: ");
        String nome = scanner.nextLine();

        if (personagens.containsKey(nome)) {
            personagens.remove(nome);
            SalvarPersonagens.salvar(personagens);
            System.out.println("Personagem \"" + nome + "\" deletado com sucesso!");
        } else {
            System.out.println("Personagem não encontrado.");
        }
        mostrarMenu();
    }
}