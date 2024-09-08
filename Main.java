import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Biblioteca biblioteca = new Biblioteca();
    public static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n---- Menu Biblioteca ----");
            System.out.println("1. Listar livros");
            System.out.println("2. Listar livros disponíveis para empréstimo");
            System.out.println("3. Cadastrar livro");
            System.out.println("4. Listar autores");
            System.out.println("5. Cadastrar autor");
            System.out.println("6. Escolher livro para empréstimo");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    listarLivros();
                    break;
                case 2:
                    listarLivrosDisponiveis();
                    break;
                case 3:
                    cadastrarLivro();
                    break;
                case 4:
                    listarAutores();
                    break;
                case 5:
                    cadastrarAutor();
                    break;
                case 6:
                    escolherLivroParaEmprestimo();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void cadastrarAutor() {
        System.out.println("\n---- Cadastro de Autores ----");
        System.out.println("Digite o nome do autor: ");
        String nome = scanner.nextLine();
        Date dataNascimento = null;
        boolean dataValida = false;

        while (!dataValida) {
            System.out.println("Informe a data de nascimento do autor (formato dd/MM/yyyy): ");
            String entradaData = scanner.nextLine();
            try {
                dataNascimento = formatoData.parse(entradaData);
                dataValida = true;
            } catch (ParseException e) {
                System.out.println("Formato de data inválido! Tente novamente.");
            }
        }

        biblioteca.adicionarAutor(new Autor(nome, dataNascimento));
        System.out.printf("Autor: %s cadastrado com sucesso!\n", nome);
    }

    public static void listarAutores() {
        System.out.println("\n---- Lista de Autores ----");
        if (biblioteca.listarAutores().isEmpty()) {
            System.out.println("Nenhum autor cadastrado.");
        } else {
            biblioteca.listarAutores().forEach(autor -> System.out.println(autor));
        }
    }

    public static void cadastrarLivro() {
        boolean autorSelecionadoValido = false;
        Autor autorSelecionado = null;

        if (biblioteca.listarAutores().isEmpty()) {
            System.out.println("Nenhum autor disponível. Cadastre um autor primeiro.");
            cadastrarAutor();
        }

        while (!autorSelecionadoValido) {
            System.out.println("Selecione o número do Autor cujo livro deseja cadastrar:");
            listarAutores();

            if (scanner.hasNextInt()) {
                int idAutor = scanner.nextInt();
                scanner.nextLine();

                autorSelecionado = biblioteca.encontrarAutorPorId(biblioteca.listarAutores(), idAutor);
                if (autorSelecionado != null) {
                    autorSelecionadoValido = true;
                    System.out.println("Autor selecionado: " + autorSelecionado.getNome());
                } else {
                    System.out.println("O ID " + idAutor + " não pertence a nenhum autor cadastrado. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next();
            }
        }

        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        biblioteca.adicionarLivro(new Livro(autorSelecionado.getNome(), titulo));
        System.out.printf("Livro: %s cadastrado com sucesso!\n", titulo);
    }

    public static void listarLivros() {
        System.out.println("\n---- Lista de Livros ----");
        if (biblioteca.listarLivros().isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            biblioteca.listarLivros().forEach(livro -> System.out.println(livro));
        }
    }

    public static void listarLivrosDisponiveis() {
        System.out.println("\n---- Lista de livros disponíveis para emprestimo ----");
        if (biblioteca.listarLivrosDisponiveis().isEmpty()) {
            System.out.println("Não há livros para emprestimo.");
        } else {
            biblioteca.listarLivrosDisponiveis().forEach(livro -> System.out.println(livro));
        }
    }

    public static void escolherLivroParaEmprestimo() {
        System.out.println("\n---- Escolher Livro para Empréstimo ----");

        List<Livro> livrosDisponiveis = biblioteca.listarLivrosDisponiveis();
        if (livrosDisponiveis.isEmpty()) {
            System.out.println("Nenhum livro disponível para empréstimo.");
            return;
        }

        System.out.println("Livros disponíveis:");
        livrosDisponiveis.forEach(livro -> System.out.printf("ID: %d - Título: %s, autor: %s\n", livro.getId(), livro.getTitulo(), livro.getAutor()));

        System.out.print("Digite o ID do livro que deseja emprestar: ");
        int idLivro = scanner.nextInt();
        scanner.nextLine();

        boolean sucesso = biblioteca.marcarLivroComoNaoDisponivel(idLivro);
        if (sucesso) {
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Livro não encontrado ou já emprestado.");
        }
    }


}
