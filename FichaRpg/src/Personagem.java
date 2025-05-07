import java.util.Scanner;

public class Personagem {
    private String nome;
    private int idade;
    private double altura;
    private double peso;
    private String classeNome; // "Rockerboy", "Solo", "Tech"
    private String arma;
    private String descricao;

    // Atributos específicos da classe
    private int inteligencia;
    private int reflexos;
    private int destrezaTecnica;
    private int frieza;
    private int vontade;
    private int sorte;
    private int movimento;
    private int corpo;
    private int empatia;


    private Personagem(String nome, int idade, double altura, double peso, int escolhaClasse, int escolhaArma, String descricao) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.descricao = descricao;

        definirClasseEAtributos(escolhaClasse);
        definirArma(escolhaArma);
    }

    private void definirClasseEAtributos(int escolhaClasse) {
        switch (escolhaClasse) {
            case 1: // Rockerboy
                this.classeNome = "Rockerboy";
                this.inteligencia = 7;
                this.reflexos = 6;
                this.destrezaTecnica = 8;
                this.frieza = 5;
                this.vontade = 6;
                this.sorte = 5;
                this.movimento = 5;
                this.corpo = 5;
                this.empatia = 3;
                break;
            case 2: // Solo
                this.classeNome = "Solo";
                this.inteligencia = 5;
                this.reflexos = 8;
                this.destrezaTecnica = 5;
                this.frieza = 9;
                this.vontade = 7;
                this.sorte = 7;
                this.movimento = 7;
                this.corpo = 8;
                this.empatia = 6;
                break;
            case 3: // Tech
                this.classeNome = "Tech";
                this.inteligencia = 9;
                this.reflexos = 7;
                this.destrezaTecnica = 8;
                this.frieza = 2;
                this.vontade = 6;
                this.sorte = 3;
                this.movimento = 7;
                this.corpo = 5;
                this.empatia = 1;
                break;
            default:
                this.classeNome = "Indefinida";
                this.inteligencia = 0;
                this.reflexos = 0;
                this.destrezaTecnica = 0;
                this.frieza = 0;
                this.vontade = 0;
                this.sorte = 0;
                this.movimento = 0;
                this.corpo = 0;
                this.empatia = 0;
                break;
        }
    }

    private void definirArma(int escolhaArma) {
        switch (escolhaArma) {
            case 1: this.arma = "Pistola Pesada"; break;
            case 2: this.arma = "Rifle de Assalto"; break;
            case 3: this.arma = "Faca de Combate"; break;
            case 4: this.arma = "Espingarda"; break;
            case 5: this.arma = "SMG"; break;
            case 6: this.arma = "Espada"; break;
            case 7: this.arma = "Rifle"; break;
            case 8: this.arma = "Sniper"; break;
            case 9: this.arma = "Lança-chamas"; break;
            default: this.arma = "Desarmado"; break;
        }
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
        return classeNome;
    }
    public String getArma() {
        return arma;
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
                "  Classe: " + classeNome + "\n" +
                "  Arma: " + arma + "\n" +
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
        System.out.println("1. Rockerboy");
        System.out.println("2. Solo");
        System.out.println("3. Tech");
        int escolhaClasse = -1;
        do {
            System.out.print("Opção da Classe (1-3): ");
            try {
                String input = scanner.nextLine();
                if (input.trim().isEmpty()) {
                    System.out.println("Entrada não pode ser vazia.");
                    continue;
                }
                escolhaClasse = Integer.parseInt(input);
                if (escolhaClasse < 1 || escolhaClasse > 3) {
                    System.out.println("Opção de classe inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida para classe. Por favor, insira um número.");
                escolhaClasse = -1;
            }
        } while (escolhaClasse < 1 || escolhaClasse > 3);

        System.out.println("\nEscolha a Arma:");
        System.out.println("1. Pistola Pesada");
        System.out.println("2. Rifle de Assalto");
        System.out.println("3. Faca de Combate");
        System.out.println("4. Espingarda");
        System.out.println("5. SMG");
        System.out.println("6. Espada");
        System.out.println("7. Rifle");
        System.out.println("8. Sniper");
        System.out.println("9. Lança-chamas");
        int escolhaArma = -1;
        do {
            System.out.print("Opção da Arma (1-9): ");
            try {
                String input = scanner.nextLine();
                if (input.trim().isEmpty()) {
                    System.out.println("Entrada não pode ser vazia.");
                    continue;
                }
                escolhaArma = Integer.parseInt(input);
                if (escolhaArma < 1 || escolhaArma > 9) {
                    System.out.println("Opção de arma inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida para arma. Por favor, insira um número.");
                escolhaArma = -1;
            }
        } while (escolhaArma < 1 || escolhaArma > 9);

        System.out.print("Descrição/História do personagem: ");
        String descricao = scanner.nextLine();
        while (descricao.trim().isEmpty()) {
            System.out.println("Descrição não pode ser vazia. Tente novamente.");
            System.out.print("Descrição/História do personagem: ");
            descricao = scanner.nextLine();
        }

        return new Personagem(nome, idade, altura, peso, escolhaClasse, escolhaArma, descricao);
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