import java.io.Serializable;
import java.util.Scanner;

public class Personagem implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private int idade;
    private double altura;
    private double peso;
    private ClassePersonagem classe; // Usando o enum ClassePersonagem
    private Arma arma; // Usando o enum Arma
    private String descricao;

    // Atributos específicos da classe (agora obtidos do enum)
    private int inteligencia;
    private int reflexos;
    private int destrezaTecnica;
    private int frieza;
    private int vontade;
    private int sorte;
    private int movimento;
    private int corpo;
    private int empatia;

    private Personagem(String nome, int idade, double altura, double peso,
                       ClassePersonagem classe, Arma arma, String descricao) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.classe = classe;
        this.arma = arma;
        this.descricao = descricao;

        // Atribui os atributos baseados na classe escolhida
        this.inteligencia = classe.inteligencia;
        this.reflexos = classe.reflexos;
        this.destrezaTecnica = classe.destrezaTecnica;
        this.frieza = classe.frieza;
        this.vontade = classe.vontade;
        this.sorte = classe.sorte;
        this.movimento = classe.movimento;
        this.corpo = classe.corpo;
        this.empatia = classe.empatia;
    }

    // Getters
    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
    public double getAltura() {
        return altura;
    }
    public double getPeso() {
        return peso;
    }
    public String getClasseNome() {
        return classe.nome;
    }
    public String getArma() {
        return arma.nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public int getInteligencia() {
        return inteligencia;
    }
    public int getReflexos() {
        return reflexos;
    }
    public int getDestrezaTecnica() {
        return destrezaTecnica;
    }
    public int getFrieza() {
        return frieza;
    }
    public int getVontade() {
        return vontade;
    }
    public int getSorte() {
        return sorte;
    }
    public int getMovimento() {
        return movimento;
    }
    public int getCorpo() {
        return corpo;
    }
    public int getEmpatia() {
        return empatia;
    }

    @Override
    public String toString() {
        return "Personagem {\n" +
                "  Nome: " + nome + "\n" +
                "  Idade: " + idade + "\n" +
                "  Altura: " + altura + "m\n" +
                "  Peso: " + peso + "kg\n" +
                "  Classe: " + classe.nome + "\n" +
                "  Arma: " + arma.nome + "\n" +
                "  Descrição: " + descricao + "\n" +
                "  Atributos:\n" +
                "    Inteligência: " + inteligencia + "\n" +
                "    Reflexos: " + reflexos + "\n" +
                "    Destreza Técnica: " + destrezaTecnica + "\n" +
                "    Frieza: " + frieza + "\n" +
                "    Vontade: " + vontade + "\n" +
                "    Sorte: " + sorte + "\n" +
                "    Movimento: " + movimento + "\n" +
                "    Corpo: " + corpo + "\n" +
                "    Empatia: " + empatia + "\n" +
                "}";
    }

    // Método estático para criar um personagem com entrada do usuário
    public static Personagem criarNovoPersonagemComEntradaDoUsuario(Scanner scanner) {
        System.out.println("\n--- Criar Novo Personagem ---");

        System.out.print("Nome do personagem: ");
        String nome = scanner.nextLine();
        while (nome.trim().isEmpty()) {
            System.out.println("Nome não pode ser vazio. Tente novamente.");
            System.out.print("Nome do personagem: ");
            nome = scanner.nextLine();
        }

        int idade = lerInteiro(scanner, "Idade do personagem: ", "Idade inválida. Deve ser um número positivo.");
        double altura = lerDouble(scanner, "Altura do personagem (ex: 1.75): ", "Altura inválida. Deve ser um número positivo.");
        double peso = lerDouble(scanner, "Peso do personagem (ex: 70.5): ", "Peso inválido. Deve ser um número positivo.");

        System.out.println("\nEscolha a Classe:");
        for (ClassePersonagem classe : ClassePersonagem.values()) {
            if (classe != ClassePersonagem.INDEFINIDA) {
                System.out.println((classe.ordinal() + 1) + ". " + classe.nome);
            }
        }
        ClassePersonagem classeEscolhida = null;
        do {
            System.out.print("Opção da Classe (1-" + (ClassePersonagem.values().length - 1) + "): ");
            try {
                String input = scanner.nextLine();
                if (input.trim().isEmpty()) {
                    System.out.println("Entrada não pode ser vazia.");
                    continue;
                }
                int escolha = Integer.parseInt(input);
                if (escolha >= 1 && escolha < ClassePersonagem.values().length) {
                    classeEscolhida = ClassePersonagem.values()[escolha - 1];
                } else {
                    System.out.println("Opção de classe inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida para classe. Por favor, insira um número.");
            }
        } while (classeEscolhida == null);

        System.out.println("\nEscolha a Arma:");
        for (Arma arma : Arma.values()) {
            if (arma != Arma.DESARMADO) {
                System.out.println((arma.ordinal() + 1) + ". " + arma.nome);
            }
        }
        Arma armaEscolhida = null;
        do {
            System.out.print("Opção da Arma (1-" + (Arma.values().length - 1) + "): ");
            try {
                String input = scanner.nextLine();
                if (input.trim().isEmpty()) {
                    System.out.println("Entrada não pode ser vazia.");
                    continue;
                }
                int escolha = Integer.parseInt(input);
                if (escolha >= 1 && escolha < Arma.values().length) {
                    armaEscolhida = Arma.values()[escolha - 1];
                } else {
                    System.out.println("Opção de arma inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida para arma. Por favor, insira um número.");
            }
        } while (armaEscolhida == null);

        System.out.print("Descrição/História do personagem: ");
        String descricao = scanner.nextLine();
        while (descricao.trim().isEmpty()) {
            System.out.println("Descrição não pode ser vazia. Tente novamente.");
            System.out.print("Descrição/História do personagem: ");
            descricao = scanner.nextLine();
        }

        return new Personagem(nome, idade, altura, peso, classeEscolhida, armaEscolhida, descricao);
    }

    private static int lerInteiro(Scanner scanner, String mensagemPrompt, String mensagemErro) {
        int valor = -1;
        boolean valido = false;
        do {
            System.out.print(mensagemPrompt);
            try {
                String input = scanner.nextLine();
                if (input.trim().isEmpty()) {
                    System.out.println("Entrada não pode ser vazia.");
                    continue;
                }
                valor = Integer.parseInt(input);
                if (valor > 0) {
                    valido = true;
                } else {
                    System.out.println(mensagemErro + " Deve ser um valor positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println(mensagemErro + " Por favor, insira um número inteiro válido.");
            }
        } while (!valido);
        return valor;
    }

    private static double lerDouble(Scanner scanner, String mensagemPrompt, String mensagemErro) {
        double valor = -1.0;
        boolean valido = false;
        do {
            System.out.print(mensagemPrompt);
            try {
                String input = scanner.nextLine();
                if (input.trim().isEmpty()) {
                    System.out.println("Entrada não pode ser vazia.");
                    continue;
                }
                valor = Double.parseDouble(input.replace(",", "."));
                if (valor > 0) {
                    valido = true;
                } else {
                    System.out.println(mensagemErro + " Deve ser um valor positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println(mensagemErro + " Por favor, insira um número decimal válido (ex: 1.75 ou 70,5).");
            }
        } while (!valido);
        return valor;
    }
}