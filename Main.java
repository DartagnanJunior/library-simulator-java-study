import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Biblioteca biblioteca = new Biblioteca();
    public static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
//

//
//        // Evoluir para receber autores e livros dinamico
//
//        Autor georgeMartin = new Autor(3, "George R.R. Martin", new Date());
//        Autor agathaChristie = new Autor(4, "Agatha Christie", new Date());
//        Autor isaacAsimov = new Autor(5, "Isaac Asimov", new Date());
//        Autor stephenKing = new Autor(6, "Stephen King", new Date());
//
//        biblioteca.adicionarAutores(georgeMartin, agathaChristie, isaacAsimov, stephenKing);
//
//        Livro livro1 = new Livro(1, georgeMartin.getNome(), "A Guerra dos Tronos");
//        Livro livro2 = new Livro(2, georgeMartin.getNome(), "A Fúria dos Reis");
//        Livro livro3 = new Livro(3, agathaChristie.getNome(), "Assassinato no Expresso do Oriente");
//        Livro livro4 = new Livro(4, agathaChristie.getNome(), "O Misterioso Caso de Styles");
//        Livro livro5 = new Livro(5, isaacAsimov.getNome(), "Fundação");
//        Livro livro6 = new Livro(6, isaacAsimov.getNome(), "Eu, Robô");
//        Livro livro7 = new Livro(7, stephenKing.getNome(), "O Iluminado");
//        Livro livro8 = new Livro(8, stephenKing.getNome(), "It: A Coisa");
//
//        biblioteca.adicionarLivros(livro1, livro2, livro3, livro4, livro5, livro6, livro7, livro8);
//
//        var autores = biblioteca.listarAutores();
//        var livros = biblioteca.listarLivros();
//
//        System.out.printf("Autores: ");
//        for (Autor a : autores) {
//            System.out.println(a.getNome());
//        }
//        System.out.printf("Livros: ");
//        for (Livro l : livros) {
//            System.out.println(l.getTitulo());
//        }

        while (true) {
            System.out.println("\n---- Menu Biblioteca ----");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Listar usuários");
            System.out.println("3. Cadastrar autor");
            System.out.println("4. Listar autores");
            System.out.println("5. Cadastrar livro");
            System.out.println("6. Listar livros");
            System.out.println("7. Listar livros disponíveis para empréstimo");
            System.out.println("8. Escolher livro para empréstimo");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
//                    cadastrarUsuario();
                    break;
                case 2:
//                    listarUsuarios();
                    break;
                case 3:
                    cadastrarAutor();
                    break;
                case 4:
                    listarAutores();
                    break;
                case 5:
                    cadastrarLivro();
                    break;
                case 6:
                    listarLivros();
                    break;
                case 7:
                    listarLivrosDisponiveis();
                    break;
                case 8:
//                    escolherLivroParaEmprestimo();
                    break;
                case 9:
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

    public static void listarLivros(){
        System.out.println("\n---- Lista de Livros ----");
        if (biblioteca.listarLivros().isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            biblioteca.listarLivros().forEach(livro -> System.out.println(livro));
        }
    }

    public static void listarLivrosDisponiveis(){
        System.out.println("\n---- Lista de livros disponíveis para emprestimo ----");
        if(biblioteca.listarLivrosDisponiveis().isEmpty()){
            System.out.println("Não há livros para emprestimo.");
        } else {
            biblioteca.listarLivrosDisponiveis().forEach(livro -> System.out.println(livro));
        }
    }


}
